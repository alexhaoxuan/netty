package com.alex.netty.foursample.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

import java.util.UUID;

/**
 * @ClassName:MyServerHandler
 * @description: MyServerHandler
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 14:32
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent){
            IdleStateEvent idleStateEvent=(IdleStateEvent)evt;

            String event=null;

            switch (idleStateEvent.state()){
                case READER_IDLE:
                    event="读空闲";
                    break;
                case WRITER_IDLE:
                    event="写空闲";
                    break;
                case ALL_IDLE:
                    event = "读写空闲";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress()+"超时空闲"+event);
            ctx.channel().close();

        }
    }
}
