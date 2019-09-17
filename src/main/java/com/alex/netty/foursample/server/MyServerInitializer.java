package com.alex.netty.foursample.server;

import com.alex.netty.secondsample.server.MyServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * @ClassName:MyServerInitializer
 * @description: MyServerInitializer
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 14:26
 */
public class MyServerInitializer extends ChannelInitializer<SocketChannel> {

    private static final int READER_IDLE_TIME=2;

    private static final int WRITER_IDLE_TIME=2;

    private static final int WRITER_READER_IDLE_TIME=4;



    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        // 空闲检测的处理器
        channelPipeline.addLast(new IdleStateHandler(READER_IDLE_TIME,WRITER_IDLE_TIME,WRITER_READER_IDLE_TIME));
        channelPipeline.addLast(new MyServerHandler());
    }
}
