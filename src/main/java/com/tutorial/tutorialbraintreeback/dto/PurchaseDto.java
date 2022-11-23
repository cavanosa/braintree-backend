package com.tutorial.tutorialbraintreeback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseDto {
    private String nonce;
    private BigDecimal amount;
}
