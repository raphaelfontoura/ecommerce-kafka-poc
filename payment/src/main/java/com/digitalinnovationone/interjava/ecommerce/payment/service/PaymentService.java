package com.digitalinnovationone.interjava.ecommerce.payment.service;

import com.digitalinnovationone.interjava.ecommerce.payment.entity.PaymentEntity;
import com.digitalinnovationone.interjava.ecommerce.payment.event.CheckoutCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.payment.repository.IPaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService implements IPaymentService{

    private final IPaymentRepository repository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode().toString())
                .code(UUID.randomUUID().toString())
                .build();
        repository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}
