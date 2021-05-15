package com.sqin.servicepay.component;

import com.sqin.servicepay.dao.TblOrderEventDao;
import com.sqin.servicepay.entity.TblOrderEvent;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import javax.jms.Session;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 0:05 2021/5/16
 **/
@Component
public class ConsumerQueue {
    @Autowired
    private TblOrderEventDao tblOrderEventDao;

    @JmsListener(destination = "ActiveMQQueue", containerFactory = "jmsListenerContainerFactory")
    public void receive(TextMessage textMessage, Session session) throws JMSException {

        try {
            System.out.println("收到的消息："+textMessage.getText());
            String content = textMessage.getText();

            TblOrderEvent tblOrderEvent = (TblOrderEvent)JSONObject.toBean(JSONObject.fromObject(content), TblOrderEvent.class);
            tblOrderEventDao.insert(tblOrderEvent);

            textMessage.acknowledge();
        } catch (Exception e) {
            System.out.println("get exception");
            session.recover();
        }

    }


    /**
     * 补偿 处理（人工，脚本）。自己根据自己情况。
     * @param text
     */
    @JmsListener(destination = "DLQ.ActiveMQQueue")
    public void receive2(String text){
        System.out.println("死信队列:"+text);
    }

}
