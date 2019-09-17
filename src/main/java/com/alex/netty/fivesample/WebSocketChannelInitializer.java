package com.alex.netty.fivesample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @ClassName:WebSocketChannelInitializer
 * @description: WebSocketChannelInitializer
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 22:25
 */
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {

    // websocket  基于http 请求

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();


        pipeline.addLast("httpServerCodec", new HttpServerCodec());

        pipeline.addLast("chunkedWriteHandler", new ChunkedWriteHandler());
        // 聚合处理器 补全 请求头  响应头
        pipeline.addLast("httpObjectAggregator", new HttpObjectAggregator(8892));

        pipeline.addLast("webSocketServerProtocolHandler",new WebSocketServerProtocolHandler("/ws"));

        pipeline.addLast("testWebSocketFramHandler",new TestWebSocketFramHandler());

    }
}
