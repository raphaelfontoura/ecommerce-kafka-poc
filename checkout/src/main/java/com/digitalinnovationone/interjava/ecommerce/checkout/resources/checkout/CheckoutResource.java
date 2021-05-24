package com.digitalinnovationone.interjava.ecommerce.checkout.resources.checkout;

import com.digitalinnovationone.interjava.ecommerce.checkout.entity.CheckoutEntity;
import com.digitalinnovationone.interjava.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.digitalinnovationone.interjava.ecommerce.checkout.service.ICheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/checkout")
@RequiredArgsConstructor
public class CheckoutResource {

    private final ICheckoutService checkoutService;

    @PostMapping("/")
    public ResponseEntity<CheckoutResponse> create(@RequestBody CheckoutRequest checkoutRequest) {
        CheckoutEntity checkoutEntity = checkoutService.create(checkoutRequest).orElseThrow();
        CheckoutResponse checkoutResponse = CheckoutResponse.builder()
                .code(checkoutEntity.getCode())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(checkoutResponse);
    }
}
