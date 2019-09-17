package com.alex.netty.thirdSample.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @ClassName:MyChatInitializer
 * @description: MyChatInitializer
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 15:45
 */
public class MyChatInitializer extends  ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        //获取管道
        ChannelPipeline pipeline = ch.pipeline();
        //字符串解码器
        pipeline.addLast(new StringDecoder());
        //字符串编码器
        pipeline.addLast(new StringEncoder());
        //处理类
        //pipeline.addLast(new ClientHandler4());
    }
}
