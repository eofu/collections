package com.myself.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyServer {
	public static void main(String[] args) {
		NioEventLoopGroup boseGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);

		ServerBootstrap bootstrap = new ServerBootstrap();

	}
}
