package com.myself.netty.apply.client;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ClientHandler extends ChannelInboundHandlerAdapter {

    /**
     * channelActive()方法会在客户端与服务器建立连接后调用。在这里面编写逻辑代码
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client send message:");
        // 1、获取数据
        ByteBuf buffer = getByteBuf(ctx);
        // 2、写数据
        ctx.channel().writeAndFlush(buffer);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        // 1、获取二进制抽象ByteBuf
        // 把字符串的二进制数据填充到ByteBuf。
        ByteBuf buffer = ctx.alloc().buffer();
        // 2、准备数据，指定字符串的字符集为UTF-8
        byte[] bytes = ("【客户端】：这是客户端发送的消息：" + new Date()).getBytes(StandardCharsets.UTF_8);
        // 3、填充数据到ByteBuf
        // 把数据写到服务器
        buffer.writeBytes(bytes);
        return buffer;
    }

    /**
     * 在接受到服务端的消息后调用
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        // 接收服务端消息
        System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
    }
}
