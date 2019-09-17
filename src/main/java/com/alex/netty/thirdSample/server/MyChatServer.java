package com.alex.netty.thirdSample.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName:MyChatServer
 * @description: MyChatServer
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 15:14
 */
public class MyChatServer {
    private static final int port = 8891;


    public static void main(String[] args) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 这里handler childchanhler 都可以使用
            // handler 针对boss 起作用 childhandle 对worker 起作用
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class).childHandler(new MyChatServerInitializer());

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("启动成功");
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }
    }
}
