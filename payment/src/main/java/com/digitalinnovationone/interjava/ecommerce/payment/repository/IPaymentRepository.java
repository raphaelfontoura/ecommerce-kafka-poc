package com.digitalinnovationone.interjava.ecommerce.payment.repository;

import com.digitalinnovationone.interjava.ecommerce.payment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
