package service.lmpl;
import java.util.List;
import dao.lmpl.OrderDaolmpl;
import model.Order;
import service.OrderService;
public class OrderServicelmpl implements OrderService{
	public static void main(String []args)
	{
		//System.out.println(new OrderServicelmpl().addOrder(new Order("Mary",1,2,0)));//(1)新增
	}
	
	private OrderDaolmpl ord=new OrderDaolmpl();
	
	@Override//(1)新增
	public void addOrder(Order order) {
		ord.add(order);
	}
	
	@Override//(2)查詢
	public Order findById(int id) {
		Order o=null;
		if(id>=1) {
			o=ord.selectById(id);
		}
		return o;
	}
	
	@Override
	public boolean updateOrder(String name, int id) {
		Order o=ord.selectById(id);
		boolean or=false;
		if(o!=null) {
			o.setName(name);
			ord.update(o);
			or=true;
		}
		return or;
	}
	@Override
	public boolean updateOrder(String name, int chiikawa, int id) {
		Order o=ord.selectById(id);
		boolean or=false;
		if(o!=null) {
			o.setName(name);
			o.setChiikawa(chiikawa);
			ord.update(o);
			or=true;
		}
		return or;
	}
	@Override
	public boolean updateOrder(String name, int chiikawa, int disney, int id) {
		Order o=ord.selectById(id);
		boolean or=false;
		if(o!=null) {
			o.setName(name);
			o.setChiikawa(chiikawa);
			o.setDisney(disney);
			ord.update(o);
			or=true;
		}
		return or;
	}
	@Override
	public boolean updateOrder(String name, int chiikawa, int disney, int horse, int id) {
		Order o=ord.selectById(id);
		boolean or=false;
		if(o!=null) {
			o.setName(name);
			o.setChiikawa(chiikawa);
			o.setDisney(disney);
			o.setHorse(horse);
			ord.update(o);
			or=true;
		}
		return or;
	}
	@Override
	public boolean deleteById(int id) {
		boolean del=false;
		if(id>=1) {
			ord.deleteById(id);
			del=true;
		}
		return del;
	}
	@Override
	public List<Order> allOrder() {
		return ord.selectAll();
	}
	
}
