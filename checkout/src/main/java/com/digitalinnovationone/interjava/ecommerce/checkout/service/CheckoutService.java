package com.digitalinnovationone.interjava.ecommerce.checkout.service;

import com.digitalinnovationone.interjava.ecommerce.checkout.entity.CheckoutEntity;
import com.digitalinnovationone.interjava.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.checkout.repository.ICheckoutRepository;
import com.digitalinnovationone.interjava.ecommerce.checkout.resources.checkout.CheckoutRequest;
import com.digitalinnovationone.interjava.ecommerce.checkout.streaming.ICheckoutCreatedSource;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutService implements ICheckoutService{

    private final ICheckoutRepository checkoutRepository;
    private final ICheckoutCreatedSource checkoutCreatedSource;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(entity);
    }
}
