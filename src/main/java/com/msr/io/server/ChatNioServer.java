package com.msr.io.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/4 17:42
 * @version: v1.0
 */

public class ChatNioServer {

    private static final int PORT = 9999;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Selector selector;
    private ServerSocketChannel serverSocketChannel;

    public ChatNioServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatNioServer server = new ChatNioServer();
        server.start();
    }

    public void start() {
        try {
            //不断轮询
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            SocketChannel sc = serverSocketChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector,SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress().toString().substring(1)+"上线了...");
                            //将此channel对应的channel设置为accept,接受其他用户段请求
                            selectionKey.interestOps(SelectionKey.OP_ACCEPT);
                        }
                        if (selectionKey.isReadable()){
                            readMsg(selectionKey);
                        }
                        iterator.remove();
                    }
                }else {
                    System.out.println("waiting...");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readMsg(SelectionKey key) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = socketChannel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array());
                printInfo(msg);
                //将关联的channel设置未read,准备接受数据
                key.interestOps(SelectionKey.OP_READ);
                //广播数据
                BroadCast(socketChannel, msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void BroadCast(SocketChannel channel, String msg) {
        System.out.println("发送广播...");
        for (SelectionKey key : selector.keys()) {
            Channel target = key.channel();
            //排除自身
            if (target instanceof SocketChannel && target != channel) {
                SocketChannel socketChannel = (SocketChannel) target;
                //将数据填充至缓冲区
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //往通道写数据
                try {
                    socketChannel.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void printInfo(String msg) {
        System.out.println("[" + simpleDateFormat.format(new Date()) + "]->" + msg);

    }

}
