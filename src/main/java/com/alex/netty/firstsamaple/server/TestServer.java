package com.alex.netty.firstsamaple.server;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ClassName:TestServer
 * @description: TestServer
 * @author: Alex
 * @Version：1.3
 * @create: 2019/09/17 11:22
 */

public class TestServer {
    private static int port=8899;

    public static void main(String[] args) {
        // 定义两个线程组
        // boss 线程组 接受客户端请求
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // boss 会将任务分发给 worke线程组
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            // netty启动器
            ServerBootstrap serverBootstrap = new ServerBootstrap ();
            // 绑定线程组 定义使用Nio 协议 并定义字处理器
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());
            // 设置启动的端口号
            ChannelFuture sync = serverBootstrap.bind(port).sync();
            System.out.println("启动成功");
            sync.channel().closeFuture().sync();
        }catch (InterruptedException  e) {
            // 打堆栈信息
            e.printStackTrace();
        }finally {
            //优雅的关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
