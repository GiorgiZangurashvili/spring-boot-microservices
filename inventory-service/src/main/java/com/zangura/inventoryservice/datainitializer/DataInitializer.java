package com.zangura.inventoryservice.datainitializer;

import com.zangura.inventoryservice.domain.Inventory;
import com.zangura.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final InventoryRepository inventoryRepository;


    @Override
    public void run(String... args) {
        if (inventoryRepository.count() != 0) {
            return;
        }

        Inventory lenovo = new Inventory();
        lenovo.setSkuCode("lenovo_v15");
        lenovo.setQuantity(20);

        Inventory hp = new Inventory();
        hp.setSkuCode("hp_pavilion_dv7");
        hp.setQuantity(0);

        inventoryRepository.save(lenovo);
        inventoryRepository.save(hp);

    }

}
