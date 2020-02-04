package com.msr.io.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description: NIO服务器
 * @author: MaiShuRen
 * @date: 2020/2/4 15:58
 * @version: v1.0
 */

public class NioServer {

    public static void main(String[] args) {
        try {
            //1.得到ServerSocketChannel
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            //2.得到selector
            Selector selector = Selector.open();
            //3.服务器设置
            serverSocketChannel.bind(new InetSocketAddress(8888));
            //4.非阻塞
            serverSocketChannel.configureBlocking(false);
            //5.注册ServerSocketChannel
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //6.接收客户端请求
            while (true) {
                //6.1监控客户端,
                if (selector.select(TimeUnit.SECONDS.toSeconds(2000)) == 0) {
                    System.out.println("无客户端连接....依然监控中....可以做其他事情....");
                    continue;
                }
                //6.2 得到通道事件
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    //客户端连接请求事件
                    if (selectionKey.isAcceptable()) {
                        System.out.println("OP_ACCEPT");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    //客户端读事件
                    if (selectionKey.isReadable()) {
                        System.out.println("OP_READ");
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
                        channel.read(byteBuffer);
                        System.out.println("客户端发来数据:" + new String(byteBuffer.array()));
                    }
                    //手动从集合中移除当前 key,防止重复处理
                    selectionKeys.remove(selectionKey);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
