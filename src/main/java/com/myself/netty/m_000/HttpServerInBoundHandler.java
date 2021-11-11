package com.myself.netty.m_000;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;

public class HttpServerInBoundHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // private ByteBufToBytes reader
        if (msg instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) msg;
            String messageType = httpRequest.headers().get("messageType");
            String businessType = httpRequest.headers().get("businessType");
            System.out.println("messageType:    " + messageType);
            System.out.println("businessType:    " + businessType);
            if (HttpUtil.isContentLengthSet(httpRequest)) {

            }

        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }
}
