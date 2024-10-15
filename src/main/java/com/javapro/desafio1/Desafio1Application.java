package com.javapro.desafio1;

import com.javapro.desafio1.entities.Order;
import com.javapro.desafio1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	@Autowired
	private OrderService orderService;

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o código do produto:");
		int code = sc.nextInt();
		System.out.println("Insira o valor do produto:");
		double value = sc.nextDouble();
		System.out.println("Insira o desconto");
		double discount = sc.nextDouble();

		Order order = new Order(code, value, discount);

		System.out.println("Pedido código: "+order.getCode());
		System.out.printf("Valor Total : R$ %.2f", orderService.total(order));


	}

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

}
