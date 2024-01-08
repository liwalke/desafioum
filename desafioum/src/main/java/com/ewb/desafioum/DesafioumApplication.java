package com.ewb.desafioum;

import com.ewb.desafioum.entities.Order;
import com.ewb.desafioum.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DesafioumApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int code;
		double basic, discount;

		System.out.println("DADOS DO PEDIDO:\n");
		System.out.println("Digite o código do pedido:");
		code = sc.nextInt();
		System.out.println("Digite o valor básico do pedido:");
		basic = sc.nextDouble();
		System.out.println("Digite o valor do desconto:");
		discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		System.out.println("\nPedido código: " + order.getCode() + "\nValor total: " + orderService.total(order));

		sc.close();
	}
}
