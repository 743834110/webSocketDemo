package com.example.demo.component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * webSocket服务器
 * 一个server服务端对应后台的一个客户端
 */
@Component
@ServerEndpoint("/webSocket")
public class WebSocketClient {

    // 在线人数统计，应保证线程安全
    private static int ONLINE_COUNT = 0;


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 保证变量的原子性
    private AtomicInteger integer = new AtomicInteger(0);

    // 保证线程安全的集合
    private ConcurrentSkipListSet<WebSocketClient> socketServers
            = new ConcurrentSkipListSet<>();

    // 与客户端进行通信的会话
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.socketServers.add(this);
        this.session = session;
        this.increaseOnlineCount();
        try {
            this.sendMessage("连接成功");
        } catch (IOException e) {

            this.logger.info(e.getMessage());
        }
    }

    @OnClose
    public void onClose(){
        this.socketServers.remove(this);
        this.decreaseOnlineCount();
        this.logger.info("有一位用户退出了");
    }

    @OnMessage
    public void onMessage(Session session, String message){
        this.logger.info("客户端发来消息");

        for (WebSocketClient client : this.socketServers) {
            try {
                client.sendMessage(message);
            } catch (IOException e) {
                this.logger.info(client + ":" +"IO异常");
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        this.logger.info("发生错误");
        throwable.printStackTrace();
    }

    /**
     * 增加在线人数
     */
    private synchronized void increaseOnlineCount(){
        ONLINE_COUNT++;
    }

    /**
     * 减少在线人数
     */
    private synchronized void decreaseOnlineCount(){
        ONLINE_COUNT--;
    }

    /**
     * 获取在线人数
     * @return 在线人数
     */
    public synchronized int getOnlineCount(){
        return ONLINE_COUNT;
    }

    /**
     * 发送消息
     * @param text
     * @throws IOException
     */
    public void sendMessage(String text) throws IOException {
        this.session.getBasicRemote().sendText(text);
    }
}
