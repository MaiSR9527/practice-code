package com.msr.io.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/5 13:33
 * @version: v1.0
 */

public class NettyClient {

    public static void main(String[] args) {
        //1.创建线程组
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();

        //2.创建客户端启动助手，配置参数
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new NettyClientHandler());
                    }

                });
        System.out.println("netty client is ready...");
        try {
            //9.监听端口
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1",9999).sync();
            channelFuture.channel().closeFuture().sync();
            eventLoopGroup.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
