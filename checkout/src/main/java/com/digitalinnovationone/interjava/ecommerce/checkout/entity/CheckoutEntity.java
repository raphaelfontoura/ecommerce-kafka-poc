package com.digitalinnovationone.interjava.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Tolerate;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckoutEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String code;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        CREATED,
        APPROVED
    }
}
