package com.rizkyjayusman.payment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

	@PostMapping
	public String pay(@RequestParam String paymentCode) {
		log.info("Execute PaymentServiceApplication.pay() - process payment for payment code: {}", paymentCode);
		String res = "paid!";
		log.info("Execute PaymentServiceApplication.pay() - process payment success");

		return res;
	}
}
