package com.myself.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * NIO
 * Reactor模式的简版
 * Reactor模式，是基于Java NIO的，在他的基础上，抽象出来两个组件——Reactor和Handler两个组件：
 * （1）Reactor：负责响应IO事件，当检测到一个新的事件，将其发送给相应的Handler去处理；新的事件包含连接建立就绪、读就绪、写就绪等。
 * （2）Handler:将自身（handler）与事件绑定，负责事件的处理，完成channel的读入，完成处理业务逻辑后，负责将结果写出channel。
 */
public class Server {
    public static void testServer() throws IOException {
        // 1、获取selector选择器
        Selector selector = Selector.open();
        // 2、获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 3、设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 4、绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8877));
        // 5、将通道注册到选择器上，并注册的操作为“接收”操作
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 6、采用轮询的方式，查询获取“准备就绪”注册过的操作
        while (selector.select() > 0) {
            // 7、获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
            Iterator<SelectionKey> selectionKeyIterator = selector.selectedKeys().iterator();
            while (selectionKeyIterator.hasNext()) {
                // 8、获取准备就绪的事件
                SelectionKey selectionKey = selectionKeyIterator.next();
                // 9、判断key是具体什么事件
                if (selectionKey.isAcceptable()) {
                    // 10、若接受的事件是“接收就绪”操作，就获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 11、切换为非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 12、将该通道注册到selector选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    // 13、获取该选择器上的“读就绪”通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    // 14、读取数据
                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                    int length = 0;
                    if ((length = socketChannel.read(byteBuffer)) != -1) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), 0, length));
                        byteBuffer.clear();
                    }
                    socketChannel.close();
                }
                // 15、移除选择键
                selectionKeyIterator.remove();
            }
        }
        // 关闭连接
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws IOException {
        testServer();
    }
}
