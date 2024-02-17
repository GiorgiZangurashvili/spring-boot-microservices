package com.zangura.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
