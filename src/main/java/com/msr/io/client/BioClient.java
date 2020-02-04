package com.msr.io.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @description: BIO客户端
 * @author: MaiShuRen
 * @date: 2020/2/4 14:54
 * @version: v1.0
 */

public class BioClient {

    public static void main(String[] args) throws IOException {
        while (true){
            //创建Socket对象
            Socket socket = new Socket("127.0.0.1",6666);
            //从连接中获取输入流信息
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请输入：");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.nextLine();
            outputStream.write(msg.getBytes());
            //从连接中获取输入流,  阻塞
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[20];
            inputStream.read(bytes);
            System.out.println("BioServer say:"+new String(bytes).trim());
            socket.close();
        }
    }
}
