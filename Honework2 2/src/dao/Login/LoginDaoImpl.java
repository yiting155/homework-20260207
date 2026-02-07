package dao.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.Login.LoginDao;
import model.Login;
import util.Tool;

public class LoginDaoImpl implements LoginDao{

	Connection conn=Tool.getDb();
	
	public void add(Login login) {
		String Sql="insert into login(name,username,password) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(Sql);
			ps.setString(1, login.getName());
			ps.setString(2, login.getUsername());
			ps.setString(3, login.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Login> selectByUsernameAndPassword(String username, String password) {
		String sql="select * from login where username=? and password=?";
		List<Login> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Login login=new Login();
				login.setId(rs.getInt("id"));
				login.setName(rs.getString("name"));
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				l.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;	}

	@Override
	public List<Login> selectByUsername(String username) {
		String sql="select * from login where username=? ";
		List<Login> l=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Login login=new Login();
				login.setId(rs.getInt("id"));
				login.setName(rs.getString("name"));
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password"));
				l.add(login);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	
	
	}

