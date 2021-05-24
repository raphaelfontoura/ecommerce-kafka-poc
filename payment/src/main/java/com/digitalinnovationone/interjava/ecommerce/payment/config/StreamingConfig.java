package com.digitalinnovationone.interjava.ecommerce.payment.config;

import com.digitalinnovationone.interjava.ecommerce.payment.streaming.ICheckoutProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(ICheckoutProcessor.class)
public class StreamingConfig {
}
