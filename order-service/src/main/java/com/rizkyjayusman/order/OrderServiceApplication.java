package com.rizkyjayusman.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class OrderServiceApplication {

	private final PaymentServiceClient paymentService;
	private final InventoryServiceClient inventoryService;
	private final UserServiceClient userService;

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@PostMapping("/orders")
	public void createOrder(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer qty) {
		log.info("Execute OrderServiceApplication.createOrder() - start create order ..");

		String username = userService.getUserById(userId);
		String productName = inventoryService.getProductById(productId);
		log.info("Execute OrderServiceApplication.createOrder() - create order for user: {} with trx item : {} qty: {}", username, productName, qty);
	}

	@PostMapping("payments")
	public void pay(@RequestParam String paymentCode) {
		log.info("Execute OrderServiceApplication.pay() - process payment for payment code: {}", paymentCode);
		String res = this.paymentService.pay();
		log.info("Execute OrderServiceApplication.pay() - result: {}", res);
	}

}
