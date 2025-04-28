package com.example.api_kokostore.application.dto.order;


public record OrderRequest(
        Long customerId,
        int paymentId
) {
}
