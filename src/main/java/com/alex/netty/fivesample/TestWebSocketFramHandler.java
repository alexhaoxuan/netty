package com.alex.netty.fivesample;
import	java.time.LocalDateTime;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

/**
 * @ClassName:TestWebSocketFramHandler
 * @description: TestWebSocketFramHandler
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 22:39
 */
public class TestWebSocketFramHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {

        ChannelPipeline pipeline = ctx.pipeline();
        System.out.println("收到消息:"+msg.text());

        ctx.writeAndFlush(new TextWebSocketFrame("服务器时间:"+LocalDateTime.now()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdd"+ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemove:" + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("异常发生");
        ctx.close();
    }
}
