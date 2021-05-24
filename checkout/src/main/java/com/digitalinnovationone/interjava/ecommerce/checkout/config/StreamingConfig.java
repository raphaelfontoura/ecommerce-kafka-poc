package com.digitalinnovationone.interjava.ecommerce.checkout.config;

import com.digitalinnovationone.interjava.ecommerce.checkout.streaming.ICheckoutCreatedSource;
import com.digitalinnovationone.interjava.ecommerce.checkout.streaming.IPaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        ICheckoutCreatedSource.class,
        IPaymentPaidSink.class
})
public class StreamingConfig {
}
