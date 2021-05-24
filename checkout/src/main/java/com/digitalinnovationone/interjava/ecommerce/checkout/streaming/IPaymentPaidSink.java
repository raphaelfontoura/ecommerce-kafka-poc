package com.digitalinnovationone.interjava.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IPaymentPaidSink {

    String INPUT = "payment-paid-input";

    @Input(INPUT)
    SubscribableChannel input();
}
