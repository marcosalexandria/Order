package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private List<OrderItem> items = new ArrayList<>();
	private OrderStatus status;
	private Client client;
	
	public Order() {
		super();
	}
	
	public Order(Date moment, List<OrderItem> items, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.items = items;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		this.items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		this.items.add(item);
	}
	
	public Double total() {
		Double totalPrice = 0.0;
		for(OrderItem item: items) {
			totalPrice =+ item.getPrice() * item.getQuantity();
		}
		return totalPrice;
	}
	
	public void orderSummary() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Order moment: "+sdf2.format(moment));
		System.out.println("Order status:t: "+this.status);
		System.out.println("\nClient: "+ client.toString());
		for(OrderItem item: items) {
			System.out.println(item.getProduct() + ", " + item.getPrice() + ", " + item.getQuantity());
		}
	}
}
