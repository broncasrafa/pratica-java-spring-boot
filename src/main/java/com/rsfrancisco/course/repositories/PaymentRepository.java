package com.rsfrancisco.course.repositories;

import com.rsfrancisco.course.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
