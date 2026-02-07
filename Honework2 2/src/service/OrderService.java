package service;

import java.util.List;

import model.Order;

public interface OrderService {

	//Create
		void addOrder(Order order);
		
		//read
		List<Order> allOrder();
		Order findById(int id);		
		
		//update(5)
		boolean updateOrder(String name,int id);
		boolean updateOrder(String name,int chiikawa,int id);
		boolean updateOrder(String name,int chiikawa,int disney,int id);
		boolean updateOrder(String name,int chiikawa,int disney,int horse,int id);
		
		//delete
		boolean deleteById(int id);
	}
