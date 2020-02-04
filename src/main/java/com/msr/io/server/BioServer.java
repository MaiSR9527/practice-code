package com.msr.io.server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: BIO服务端
 * @Author: MaiShuRen
 * @Date: 2019/11/6 10:43
 */
public class BioServer {


    public static void main(String[] args) {
        System.out.println("服务器启动，等待连接...");

        InputStream inputStream = null;
        Socket socket = null;
        try {
            // 创建ServerSocket对象
            ServerSocket serverSocket = new ServerSocket(6666);
            //监听客户端，阻塞
            socket = serverSocket.accept();
            //获取输入流
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int read = inputStream.read(bytes);

            String clientIP = socket.getInetAddress().getHostAddress();
            System.out.println(clientIP+"say:"+new String(bytes).trim());

            //获取输出流
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream!=null){
                    inputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
