package com.msr.io.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @description: NIO客户端
 * @author: MaiShuRen
 * @date: 2020/2/4 15:58
 * @version: v1.0
 */

public class NioClient {

    public static void main(String[] args) {
        try {
            //1.得到channel
            SocketChannel channel = SocketChannel.open();
            //2.非阻塞
            channel.configureBlocking(false);
            //3.服务端地址 IP+PORT
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 8888);
            //4.连接服务器
            if (!channel.connect(address)) {
                while (!channel.finishConnect()) {
                    //nio连接不上可以去做其他事情，再重连

                    System.out.println("连接失败。。。尝试重连~~~~");
                }
            }
            String msg = "hello NIO server";
            //5.得到缓冲区
            ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
            //6.发送数据
            channel.write(buffer);
            //阻止main线程结束
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
