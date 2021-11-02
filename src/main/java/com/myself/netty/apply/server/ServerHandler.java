package com.myself.netty.apply.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        System.out.println(new Date() + "：服务端读到的数据->" + byteBuf.toString(StandardCharsets.UTF_8));
        ByteBuf out = getByteBuf(ctx);
        ctx.channel().writeAndFlush(out);
    }

    /**
     * channelRead执行后触发
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println(ctx.name() + "的消息已读取完毕");
    }

    /**
     * 通道激活时触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String name = ctx.name();
        System.out.println(name + "已连接！");
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        ByteBuf buffer = ctx.alloc().buffer();
        byte[] bytes = ("【服务端】：已接收到：" + new Date()).getBytes(StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);
        return buffer;
    }
}
