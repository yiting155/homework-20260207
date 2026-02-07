package dao.lmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import model.Order;
import util.Tool;

public class OrderDaolmpl implements OrderDao{
	private Connection conn=Tool.getDb();

	@Override
	public void add(Order order) {
		String sql="insert into `Order`(name,Chiikawa,Disney,horse)values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, order.getName());
			ps.setInt(2,order.getChiikawa());
			ps.setInt(3,order.getDisney());
			ps.setInt(4,order.getHorse());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Order> selectAll() {
		String sql="select * from `Order`";
		List<Order> L=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Order o=new Order(sql, 0, 0, 0);
				
	 //---------------Order o=new Order();--------------//				
				
				o.setId(rs.getInt("id"));
				o.setName(rs.getString("name"));
				o.setChiikawa(rs.getInt("chiikawa"));
				o.setDisney(rs.getInt("disney"));
				o.setHorse(rs.getInt("horse"));
				L.add(o);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return L;
	}

	@Override
	public Order selectById(int id) {
		String sql="select * from `Order` where id=?";
		Order o=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				o=new Order(sql, id, id, id);
				
//---------------Order o=new Order();--------------//
				
				o.setId(rs.getInt("id"));
				o.setName(rs.getString("name"));
				o.setChiikawa(rs.getInt("chiikawa"));
				o.setDisney(rs.getInt("disney"));
				o.setHorse(rs.getInt("horse"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void update(Order order) {
		String sql="update `Order` set name=?,chiikawa=?,disney=?,horse=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,order.getName());
			ps.setInt(2,order.getChiikawa());
			ps.setInt(3,order.getDisney());
			ps.setInt(4,order.getHorse());
			ps.setInt(5,order.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(int id) {
		String sql="delete from `Order` where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
