package com.digitalinnovationone.interjava.ecommerce.checkout.service;

import com.digitalinnovationone.interjava.ecommerce.checkout.entity.CheckoutEntity;
import com.digitalinnovationone.interjava.ecommerce.checkout.resources.checkout.CheckoutRequest;

import java.util.Optional;

public interface ICheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
