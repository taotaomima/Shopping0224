package com.gtt.shoppingsupportback.consumer;

import com.gtt.shoppingsupportback.mq.EmailEvent;
import com.gtt.shoppingsupportback.util.EmailUtil;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
@RocketMQMessageListener(topic = "SendPwdRestByEmail",consumerGroup = "shopping-group")
public class EmailConsumer implements RocketMQListener<EmailEvent> {

    @Autowired
    private EmailUtil emailUtil;

    @Value("${spring.mail.username}")
    private String fromEmail;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void onMessage(EmailEvent emailEvent) {
        logger.info("{}",emailEvent);
        emailUtil.sendRestCode(fromEmail,emailEvent.getToEmail(),emailEvent.getContent(),emailEvent.getTitle());
    }
}
