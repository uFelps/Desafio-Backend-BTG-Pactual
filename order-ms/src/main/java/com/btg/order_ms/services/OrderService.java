package com.btg.order_ms.services;

import com.btg.order_ms.dto.NumberOfOrdersDTO;
import com.btg.order_ms.dto.OrderDTO;
import com.btg.order_ms.entities.Order;
import com.btg.order_ms.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public void saveOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setClientId(orderDTO.getClientId());

        order.setItens(orderDTO.getItens());
        calculateTotal(order);

        repository.save(order);
    }

    private void calculateTotal(Order order){
        order.setTotal(order.getItens()
                .stream()
                .map(x -> x.getPrice().multiply(BigDecimal.valueOf(x.getQuantity())))
                .reduce(BigDecimal::add).orElse(BigDecimal.ZERO));
    }

    public Page<OrderDTO> findAllOrdersByClient(Long id, Pageable pageable) {

        Page<Order> orders = repository.findAllByClientId(id, pageable);

        return orders.map(OrderDTO::new);
    }

    public NumberOfOrdersDTO findNumberOfOrdersByClient(Long clientId) {

        Long count = repository.countByClientId(clientId);

        return new NumberOfOrdersDTO(count);
    }
}
