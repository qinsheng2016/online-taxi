package com.sqin.cloudeureka.listen;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;

import java.util.Timer;
import java.util.TimerTask;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 0:11 2021/4/27
 **/
public class TestEvent {

    public void listen(EurekaInstanceCanceledEvent event) {
        // 发邮件，短信
        System.out.println("下线：" + event.getServerId());
    }

    public static void main(String[] args) {
    }
}
