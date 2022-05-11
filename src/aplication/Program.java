package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		// receiving dates of client
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.next();
		System.out.print("E-mail: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String dateSt = sc.next();
		Date birthDate = sdf2.parse(dateSt);
		Client client = new Client(name, email, birthDate);
		
		// receiving status
		System.out.print("Status 1-PENDING_PAYMENT 2-PROCESSING 3-SHIPPED 4-DELIVERED: ");
		int test = sc.nextInt();
		OrderStatus status = OrderStatus.PENDING_PAYMENT;
		switch (test) {
		case 1: 
			status = OrderStatus.PENDING_PAYMENT;
			break;
		case 2:
			status = OrderStatus.PROCESSING;
			break;
		case 3:
			status = OrderStatus.SHIPPED;
			break;
		case 4:
			status = OrderStatus.DELIVERED;
			break;
		default:
			System.out.println("Invalid value");
			break;
		}
		
		//receiving orders
		List<OrderItem> items = new ArrayList<>();
		System.out.println("How many items to this order? ");
		int quantityOrder = sc.nextInt();
		int num = 1;
		for(int i = 0; i<quantityOrder; i++) {
			System.out.println("item #"+num);
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.println("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quanity = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quanity, productPrice, product);
			items.add(item);
			num ++;
		}
		
		Date date = new Date();
		Order order = new Order(items, status, client, date);
		order.orderSummary();
		sc.close();
	}

}
