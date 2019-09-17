package com.alex.netty.firstsamaple.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ClassName:MyServerHandler
 * @description: MyServerHandler
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 14:32
 */
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 获取上下文对象
        System.out.println(ctx.channel().remoteAddress()+","+msg);

        ctx.channel().writeAndFlush("from"+ UUID.randomUUID());
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception{
        cause.printStackTrace();
    }
}
