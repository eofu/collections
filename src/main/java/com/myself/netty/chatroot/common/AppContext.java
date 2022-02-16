package com.myself.netty.chatroot.common;

import com.myself.netty.chatroot.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Slf4j
public class AppContext {
    @Autowired
    private WebSocketServer webSocketServer;
    
    private Thread nettyThread;
    
    @PostConstruct
    public void init() {
        nettyThread = new Thread(webSocketServer);
        log.info("开启独立线程，启动Netty WebSocket服务器...");
        nettyThread.start();
        // log.info("加载用户数据...");
        // userInfoDao.loadUserInfo();
        // log.info("加载用户交流群数据...");
        // groupDao.loadGroupInfo();
    }
    
    @PreDestroy
    public void close() {
        // log.info("正在释放Netty Websocket相关连接...");
        // webSocketServer.close();
        // log.info("正在关闭Netty Websocket服务器线程...");
        // nettyThread.stop();
        // log.info("系统成功关闭！");
    }
}
