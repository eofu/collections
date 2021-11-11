package com.myself.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ByteBuf2Bytes {
    private ByteBuf temp;

    private boolean end = true;

    public ByteBuf2Bytes(int length) {
        temp = Unpooled.buffer(length);
    }

    public void reading(ByteBuf datas) {
        datas.readBytes(temp, datas.readableBytes());
    }
}
