package com.tutorial.tutorialbraintreeback.service;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ClientTokenRequest;
import com.braintreegateway.Environment;
import com.tutorial.tutorialbraintreeback.config.BraintreeConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    @Autowired
    BraintreeConfig config;

    public BraintreeGateway getGateway() {
        return new BraintreeGateway(
                Environment.SANDBOX,
                config.getMerchantId(),
                config.getPublicKey(),
                config.getPrivateKey()
        );
    }

    public String getToken() {
        ClientTokenRequest request = new ClientTokenRequest();
        return getGateway().clientToken().generate(request);
    }
}
