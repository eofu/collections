package com.myself.netty.demo.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServerDemo {
    public void server() throws IOException {
        // 1、打开ServerSocketChannel，用于监听客户端的连接，它是所有客户端的父管道。
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2、绑定监听地址 InetSocketAddress，设定连接为非阻塞模式。
        serverSocketChannel.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), 8877));
        serverSocketChannel.configureBlocking(false);
        // 3、创建Selector，启动线程。创建Reactor线程，创建多路复用器并启动线程。
        Selector selector = Selector.open();
        // new Thread(new ReactorTask()).start();
        // 4、将ServerSocketChannel注册到Reactor的多路复用器Selector上，监听SelectionKEY.OP_ACCEPT事件
        // serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, ioHandler);
        // 5、Selector轮询就绪的Key。多路复用器在线程run方法的无线循环体内轮询准备就绪的Key。
        int num = selector.select();
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            // ...deal with I/O event
        }
        // 6、handlerAccept()处理新的客户端接入。多路复用器监听到有新的客户端接入，处理新的接入请求，完成TCP三次握手，建立物理链路。
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 7、设置新建客户端连接的Socket参数。设置客户端链路的TCP参数。
        socketChannel.configureBlocking(false);
        socketChannel.socket().setReuseAddress(true);
        // 8、向Selector注册监听读操作SelectionKEY.OP_READ。将新接入的客户端连接注册到Reactor线程的多路复用器上，监听读操作，用来读取客户端发送的网络消息。
        // socketChannel.register(selector, SelectionKey.OP_READ, ioHandler);
        // 9、handlerRead()异步读请求消息到ByteBuffer。异步读取客户端请求消息到缓冲区。
        // socketChannel.read(msg);
        // 10、decode请求消息。对ByteBuffer进行编解码，如果有半包消息指针Reset，继续读取后续报文，将解码成功的消息封装成Task，投递到业务线程池中，进行业务逻辑编排
        Object message = null;
        // while (buffer.hasRemain()) {
        //     byteBuffer.mark();
        //     Object message = decode(byteBuffer);
        //     if (message == null) {
        //         byteBuffer.reset();
        //         break;
        //     }
        //     messageList.add(message);
        // }
        // if (!byteBuffer.hasRemain()) {
        //     byteBuffer.clear();
        // } else {
        //     byteBuffer.compact();
        // }
        // if (messageList != null && !messageList.isEmpty()) {
        //     for (Object messageE : messageList) {
        //         handlerTask(messageE);
        //     }
        // }

        // 11、异步写ByteBuffer到SocketChannel。将POJO对象encode成ByteBuffer，调用SocketChannle的异步write接口，将消息异步发送给客户端。
        // socketChannel.write(buffer);

        // 如果发送去TCP缓冲区满，会导致写半包，此时需要注册监听写操作位，循环写，直到整包消息写入TCP缓冲区。
    }
}
