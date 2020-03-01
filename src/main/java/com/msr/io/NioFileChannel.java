package com.msr.io;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @description: NIO文件输入输出
 * @author: MaiShuRen
 * @date: 2020/2/4 15:23
 * @version: v1.0
 */

public class NioFileChannel {
    public static void main(String[] args) {
        String text = "hello nio file";
        System.out.println("向text.txt文件输入：" + text);
        try {

            nioFileChannelWrite(text);

            System.out.println("============读取文件内容==============");

            nioFileChannelRead();

            System.out.println("================NIO文件复制================");
            nioFileChannelCopy();
            System.out.println("==================================");
            scatteringRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void nioFileChannelCopy() throws IOException {
        //要输出的文件
        FileOutputStream fileOutputStream1 = new FileOutputStream("copy.txt");
        //要读取的文件
        FileInputStream fileInputStream1 = new FileInputStream("text.txt");
        //读数据的channel
        FileChannel fileChannel1 = fileInputStream1.getChannel();
        //输出数据的channel
        FileChannel fileChannel2 = fileOutputStream1.getChannel();
        //复制
        fileChannel2.transferFrom(fileChannel1, 0, fileChannel1.size());
    }

    private static void nioFileChannelWrite(String text) throws IOException {
        //创建输出流
        FileOutputStream fileOutputStream = new FileOutputStream("text.txt");
        //从输出流获取通道
        FileChannel fileChannel = fileOutputStream.getChannel();
        //初始化缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //向缓冲区填充数据
        buffer.put(text.getBytes());
        //缓冲区反转
        buffer.flip();
        //输出至文件
        fileChannel.write(buffer);
        fileChannel.close();
        fileOutputStream.close();
    }

    private static void nioFileChannelRead() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        channel.read(readBuffer);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("text.txt文件中的内容：" + new String(readBuffer.array()));
        channel.close();
        fileInputStream.close();
    }

    /**
     * 分散读取
     */
    public static void scatteringRead() throws IOException {
        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("text.txt");
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] bufArr = {buffer1, buffer2};
        channel.read(bufArr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(new String(bufArr[0].array(), 0, bufArr[0].limit()));
        channel.close();
        fileInputStream.close();

    }

    /**
     * 聚集写入
     *
     * @throws FileNotFoundException
     */
    public static void gatheringWrite() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("text.txt");

    }
}






