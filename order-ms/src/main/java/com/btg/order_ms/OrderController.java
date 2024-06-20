package com.btg.order_ms;

import com.btg.order_ms.dto.NumberOfOrdersDTO;
import com.btg.order_ms.dto.OrderDTO;
import com.btg.order_ms.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/clients/{id}/orders")
    public ResponseEntity<Page<OrderDTO>> findAllOrdersByClient(@PathVariable Long id, Pageable pageable){
        return ResponseEntity.ok(orderService.findAllOrdersByClient(id, pageable));
    }

    @GetMapping(value = "/clients/{id}/orders/quantity")
    public ResponseEntity<NumberOfOrdersDTO> findNumberOfOrdersByClient(@PathVariable Long id){
        return ResponseEntity.ok(orderService.findNumberOfOrdersByClient(id));
    }
}
