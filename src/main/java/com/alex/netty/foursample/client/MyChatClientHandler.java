package com.alex.netty.foursample.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName:MyChatHandler
 * @description: MyChatHandler
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 15:48
 */
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        ChannelPipeline channel = ctx.pipeline();
        channel.writeAndFlush("连接成功");

    }
}
