package com.alex.netty.secondsample.client;
import	java.time.LocalDateTime;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName:MyClientHandler
 * @description: MyClientHandler
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 14:59
 */
public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        System.out.println("client msg:" + msg);
        ctx.channel().writeAndFlush("Time"+LocalDateTime.now());
    }

//    @Override
////    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
////            throws Exception{
////        cause.printStackTrace();
////        ctx.close();
////    }
}
