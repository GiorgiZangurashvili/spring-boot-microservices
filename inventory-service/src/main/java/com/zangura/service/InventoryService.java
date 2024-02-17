package com.zangura.service;

import com.zangura.dto.InventoryResponse;
import com.zangura.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventory -> InventoryResponse
                       .builder()
                       .skuCode(inventory.getSkuCode())
                       .isInStock(inventory.getQuantity() > 0)
                       .build())
                .collect(Collectors.toList());
    }
}