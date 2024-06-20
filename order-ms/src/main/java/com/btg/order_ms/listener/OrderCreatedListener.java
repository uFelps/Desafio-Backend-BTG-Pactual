package com.btg.order_ms.listener;

import com.btg.order_ms.dto.OrderDTO;
import com.btg.order_ms.services.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedListener {

    @Autowired
    private OrderService orderService;

    @RabbitListener(queues = "btg-pactual-order-created")
    public void receiveMessage(@Payload OrderDTO orderDTO){
        orderService.saveOrder(orderDTO);
    }
}
