package com.thecodereveal.shopease.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequest {
    private UUID productId;
    private  UUID productVariantId;
    private Double discount;
    private Integer quantity;
}
