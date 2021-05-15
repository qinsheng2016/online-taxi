package com.sqin.serviceorder.task;

import net.sf.json.JSONObject;
import com.sqin.serviceorder.dao.TblOrderEventDao;
import com.sqin.serviceorder.entity.TblOrderEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Queue;
import java.util.List;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 19:45 2021/5/15
 **/
@Component
public class ProduceTask {

    @Autowired
    private TblOrderEventDao tblOrderEventDao;

    @Autowired
    private Queue queue;

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;

    @Scheduled(cron="0/5 * * * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void task(){
        System.out.println("scheduled task");

        // select from db
        List<TblOrderEvent> tblOrderEventList = tblOrderEventDao.selectByOrderType("1");
        for(int i = 0; i < tblOrderEventList.size(); i++) {
            TblOrderEvent event = tblOrderEventList.get(i);

            // udpate db
            tblOrderEventDao.updateEvent(event.getOrderType());
            System.out.println("updated successful!");

            // send to message queue
            jmsMessagingTemplate.convertAndSend(queue, JSONObject.fromObject(event).toString());
        }

    }
}
