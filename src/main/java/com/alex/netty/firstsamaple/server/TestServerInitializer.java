package com.alex.netty.firstsamaple.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * @ClassName:TestServerInitializer
 * @description: 自定义初始化器
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 11:47
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {

    private static int IDLE_READE_TIME = 20;

    private static int IDLE_WIRTER_TIME = 20;

    private static int IDLE_READE_AND_WIRTER_TIME = 40;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();
        // 定义读写消息的时间 处理逻辑可指定名字哦 不指定的话 默认使用传入对象的名字
        pipeline.addLast("idleStateHandler", new IdleStateHandler(IDLE_READE_TIME, IDLE_WIRTER_TIME, IDLE_READE_AND_WIRTER_TIME));
        // 使用netty 内置 的protibuf编码器解码器
        pipeline.addLast(new HttpRequestEncoder());
        pipeline.addLast(new HttpRequestDecoder());
        pipeline.addLast(new HttpServerCodec());
        // 自定义处理逻辑
        pipeline.addLast(new TestServerhandler());
    }
}
