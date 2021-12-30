package com.myself.io.nio.Reactor1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class Handler implements Runnable {
    static final int READING = 1, SENDING = 1;
    final SocketChannel channel;
    final SelectionKey sk;
    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    int state = READING;

    public Handler(SocketChannel c, Selector selector) throws IOException {
        this.channel = c;
        c.configureBlocking(false);
        sk = channel.register(selector, 0);
        // 将Handler作为callback对象
        sk.attach(this);
        // 第二步，注册就绪事件
        sk.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    void read() throws IOException {
        channel.read(input);
        if (inputIsComplete()) {
            process();
            state = SENDING;
            // 第三步，接收write就绪事件
            sk.interestOps(SelectionKey.OP_WRITE);
        }
    }

    void send() throws IOException {
        channel.write(output);
        // write完就结束了，关闭select key
        if (outputIsComplete()) {
            sk.cancel();
        }
    }

    boolean inputIsComplete() {
        return false;
    }

    boolean outputIsComplete() {
        return false;
    }

    void process() {
        return;
    }

    @Override
    public void run() {

    }
}
