package com.gtt.shoppingsupportback.consumer;

import com.gtt.shoppingsupportback.mq.HotProductDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HotProductConsumer {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "hotproduct",groupId = "hot-product-group01")
    public void handleHotProduct(String productIdStr){
        logger.info("handle product",productIdStr);
        //对热点数据访问量的impl
     /*   ProductOperation productOperation = productOperationMapper.selectByPrimaryKey(productId);
        if(productOperation==null){
            productOperation = new ProductOperation();
            productOperation.setProductId(productId);
            productOperation.setAllCount(1);
            productOperation.setDayCount(1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.insertSelective(productOperation);
        }else{
            productOperation.setAllCount(productOperation.getAllCount()+1);
            productOperation.setDayCount(productOperation.getDayCount()+1);
            productOperation.setRecentTime(new Date());
            productOperationMapper.updateByPrimaryKeySelective(productOperation);
        }*/
    }
}
