package com.digitalinnovationone.interjava.ecommerce.payment.service;

import com.digitalinnovationone.interjava.ecommerce.payment.entity.PaymentEntity;
import com.digitalinnovationone.interjava.ecommerce.payment.event.CheckoutCreatedEvent;

import java.util.Optional;

public interface IPaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
