package com.myself.netty.demo.client;

public class NioClientDemo {
    public void client() {
        // 1、打开SocketChannel，绑定客户端端口
        // 2、设置SocketChannel为非阻塞模式，同时设置客户端连接的TCP参数。
        // 3、异步连接服务端
        // 4、判断是否连接成功，如果连接成功，则注册读事件到多路复用器中。如果当前没连接成功（异步连接返回false，说明客户端已经发送sync包，服务端没有返回ack包，物理链路还没有建立）
        // 5、向Reactor线程的多路复用器注册OP_CONNECT事件，监听服务端的TCP ACK应答
        // 6、创建Reactor线程，创建多路复用器并启动线程
        // 7、多路复用器在线程run方法的无限循环体内轮询准备就绪的Key
        // 8、接收connect事件进行处理
        // 9、
        // 10、注册事件到多路复用器
        // 11、异步读客户端请求到缓冲区
        // 12、对ByteBuffer进行编解码，如果有半包指针Reset，继续读取后续报文，将解码成功的消息封装成Task，投递到业务线程池中
        // 13、将Pojo对象encode成ByteBuffer，调用SocketChannel的异步write接口，将消息发送给客户端
    }
}
