package com.btg.order_ms.dto;

import com.btg.order_ms.entities.Item;
import com.btg.order_ms.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDTO {

    private Long orderId;
    private Long clientId;
    private BigDecimal total;
    private List<Item> itens = new ArrayList<>();

    public OrderDTO(Order order) {
        orderId = order.getOrderId();
        clientId = order.getClientId();
        total = order.getTotal();
        itens = order.getItens();
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", itens=" + itens +
                '}';
    }
}
