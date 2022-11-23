package com.tutorial.tutorialbraintreeback.controller;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.tutorial.tutorialbraintreeback.dto.ClientTokenDto;
import com.tutorial.tutorialbraintreeback.dto.PurchaseDto;
import com.tutorial.tutorialbraintreeback.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/token")
    public ResponseEntity<ClientTokenDto> getToken() {
        return ResponseEntity.ok(paymentService.getToken());
    }

    @PostMapping("/checkout")
    public ResponseEntity<Result<Transaction>> checkout(@RequestBody PurchaseDto dto) {
        return ResponseEntity.ok(paymentService.checkout(dto));
    }
}
