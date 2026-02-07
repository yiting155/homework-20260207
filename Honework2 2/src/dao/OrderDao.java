package dao;

import java.util.List;

import model.Order;

public interface OrderDao {
	
	//Create
	void add(Order order);
	
	//Read
	List<Order> selectAll();
	
	Order selectById(int id);

	//Update
	void update(Order order);
	
	
	//Delete
	void deleteById(int id);


}
