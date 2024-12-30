package com.rizkyjayusman.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {

    @GetMapping
    String getProductById(@RequestParam("productId") Long productId);

}
