package com.example.api_kokostore.application.dto.order;

import java.util.List;

public record DetailOrderRequest(
        OrderRequest order,
        List<PayloadProduct> cart
) {
}
