package com.example.api_kokostore.application.dto.order;

import com.example.api_kokostore.domain.enums.StatusOrder;

public record OrderRequest(
        Long customerId,
        int paymentId
) {
}
