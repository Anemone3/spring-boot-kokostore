package com.example.api_kokostore.application.dto.order;

import java.util.List;
import java.util.UUID;

public record OrderResponse(
                UUID id,
                double total,
                int quantity,
                List<DetailOrderResponse> details) {

}
