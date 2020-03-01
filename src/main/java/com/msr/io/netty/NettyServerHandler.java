package com.msr.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @description: 服务器端业务处理类
 * @author: MaiShuRen
 * @date: 2020/2/5 13:34
 * @version: v1.0
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * 读取数据事件
     *
     * @param ctx handler上下文
     * @param msg 信息
     * @throws Exception 异常
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("handler上下文:" + ctx);
        ByteBuf buffer = (ByteBuf) msg;
        System.out.println("客户端发来的信息：" + buffer.toString(CharsetUtil.UTF_8));
    }

    /**
     * 读取事件完成
     *
     * @param ctx handler上下文
     * @throws Exception 异常
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello client",CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
