package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
