package com.msr.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @description:
 * @author: MaiShuRen
 * @date: 2020/2/5 13:33
 * @version: v1.0
 */

public class NettyServer {

    public static void main(String[] args) {
        //1.创建一个线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup();

        //2.创建一个线程组,处理网络操作
        EventLoopGroup workGroup = new NioEventLoopGroup();

        //3.创建服务器启动助手来配置参数
        ServerBootstrap bootstrap = new ServerBootstrap();
        //4.配置两个线程组
        bootstrap.group(bossGroup, workGroup)
                //5.配置服务端通道
                .channel(NioServerSocketChannel.class)
                //6.设置线程队列中等待连接的个数
                .option(ChannelOption.SO_BACKLOG, 128)
                //7.保持活动连接状态
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                //8.添加自定义的业务处理类
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        ChannelPipeline pipeline = socketChannel.pipeline();
                        pipeline.addLast(new NettyServerHandler());
                    }
                });
        System.out.println("NettyServer is ready...");
        try {
            //9.监听端口
            ChannelFuture channelFuture = bootstrap.bind(9999).sync();
            channelFuture.channel().closeFuture().sync();
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
