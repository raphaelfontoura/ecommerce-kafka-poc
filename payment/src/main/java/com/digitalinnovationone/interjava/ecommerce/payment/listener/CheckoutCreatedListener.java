package com.digitalinnovationone.interjava.ecommerce.payment.listener;

import com.digitalinnovationone.interjava.ecommerce.payment.entity.PaymentEntity;
import com.digitalinnovationone.interjava.ecommerce.payment.event.CheckoutCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.payment.event.PaymentCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.payment.service.IPaymentService;
import com.digitalinnovationone.interjava.ecommerce.payment.streaming.ICheckoutProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {

    private final ICheckoutProcessor checkoutProcessor;
    private final IPaymentService paymentService;

    @StreamListener(ICheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent event) {
        final PaymentEntity paymentEntity = paymentService.create(event).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setCheckoutStatus(paymentEntity.getCode())
                .setPaymentCode(UUID.randomUUID().toString())
                .build();

        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
