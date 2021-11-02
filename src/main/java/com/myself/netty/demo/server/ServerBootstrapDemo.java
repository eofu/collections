package com.myself.netty.demo.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ServerBootstrapDemo extends Bootstrap {

    public static void main(String[] args) {
        // 1、创建两个EventGroup（两个线程组），bossGroup是监听客户端请求，workerGroup是处理每条连接的数据读写
        NioEventLoopGroup boseGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        // 2、通过无参构造创建server的启动辅助类，用来引导服务器的启动工作
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap
                // 配置两个工作线程组
                .group(boseGroup, workerGroup)
                // 配置服务端的IO模型 NioServerSocketChannel为NIO模型 OioServerSocketChannel为BIO模型
                .channel(NioServerSocketChannel.class)
                // 用于配置每条连接的数据读写和业务逻辑等
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                    }
                })
                .bind(8888);

    }
}
