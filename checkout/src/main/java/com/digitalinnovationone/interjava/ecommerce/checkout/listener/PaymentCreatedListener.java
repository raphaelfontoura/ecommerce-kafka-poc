package com.digitalinnovationone.interjava.ecommerce.checkout.listener;

import com.digitalinnovationone.interjava.ecommerce.checkout.entity.CheckoutEntity;
import com.digitalinnovationone.interjava.ecommerce.checkout.event.PaymentCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.checkout.repository.ICheckoutRepository;
import com.digitalinnovationone.interjava.ecommerce.checkout.streaming.IPaymentPaidSink;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentCreatedListener {

    private ICheckoutRepository checkoutRepository;

    @StreamListener(IPaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event){
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);
        checkoutRepository.save(checkoutEntity);
    }
}
