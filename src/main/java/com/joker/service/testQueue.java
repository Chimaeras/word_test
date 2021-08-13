package com.joker.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class testQueue {
    //下单消息
    private String placeOrder;
    //订单完成消息
    private String completeOrder;

    public String getPlaceOrder ( ) {
        return placeOrder;
    }

    @Async
    public void setPlaceOrder ( String placeOrder ) {
        log.info( "接到下单请求" + placeOrder );
        //模拟处理
        try {
            Thread.sleep( 1000 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        //给completeOrder赋值
        this.completeOrder = placeOrder;
        log.info( "下单请求处理完毕" + placeOrder );
    }

    public String getCompleteOrder ( ) {
        return completeOrder;
    }

    public void setCompleteOrder ( String completeOrder ) {
        this.completeOrder = completeOrder;
    }


}
