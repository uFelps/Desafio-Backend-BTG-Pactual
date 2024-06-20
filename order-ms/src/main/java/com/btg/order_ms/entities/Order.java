package com.btg.order_ms.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "tb_orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {

    @MongoId
    private Long orderId;
    @Indexed(name = "client_id_index")
    private Long clientId;
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal total;
    private List<Item> itens = new ArrayList<>();

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", total=" + total +
                ", itens=" + itens +
                '}';
    }
}
