package com.myself.io.nio.Reactor2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MThreadHandler implements Runnable {
    static final int READING = 1, SENDING = 1;
    final SocketChannel socketChannel;
    final SelectionKey selectionKey;
    ByteBuffer input = ByteBuffer.allocate(1024);
    ByteBuffer output = ByteBuffer.allocate(1024);
    int state = READING;
    ExecutorService pool = Executors.newFixedThreadPool(2);
    static final int PROCESSING = 3;

    public MThreadHandler(SocketChannel channel, SelectionKey sk) throws IOException {
        this.socketChannel = channel;
        socketChannel.configureBlocking(false);
        this.selectionKey = sk;
    }

    @Override
    public void run() {

    }
}
