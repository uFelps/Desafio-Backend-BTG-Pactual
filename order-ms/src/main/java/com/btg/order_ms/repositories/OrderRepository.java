package com.btg.order_ms.repositories;

import com.btg.order_ms.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface OrderRepository extends MongoRepository<Order, Long> {
    Page<Order> findAllByClientId(Long id, Pageable pageable);

    @Query(value = "{clientId: ?0}", count = true)
    Long countByClientId(Long clientId);
}
