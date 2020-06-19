package com.capgemini.servletswithoutsession.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.capgemini.servletswithoutsession.dto.Bean;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmployeeDaoImpl implements EmployeeDao{

	public boolean deleteEmployeeById(int id) {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "delete from details where sid=?";

		try (Connection connection = (Connection) DriverManager.getConnection(url);
				java.sql.PreparedStatement ps = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			 
            ps.setInt(1,id);  
           int status=ps.executeUpdate();   
	   if(status!=0) {
		return true;
	   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	

	public boolean updateEmployee(Bean b) {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "update  details set sname=? where sid=?";

		try (Connection connection = (Connection) DriverManager.getConnection(url);
				java.sql.PreparedStatement ps = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			 ps.setString(1,b.getSname());  
	            ps.setInt(2,b.getSid());
		
	            int status=ps.executeUpdate();   
	     	   if(status!=0) {
	     		return true;
	     	   }
	     		} catch (Exception e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     		}
	     		return false;
	     	}

	public boolean addEmployeeDetails(Bean b2) {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "insert into details(sid,sname,email,dept) values(?,?,?,?)";

		try (Connection connection = (Connection) DriverManager.getConnection(url);
				java.sql.PreparedStatement ps = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
	            ps.setInt(2,b2.getSid());
	            ps.setString(1,b2.getSname()); 
	            ps.setInt(2,b2.getDept());
	            ps.setString(1,b2.getEmail()); 
	            int status=ps.executeUpdate();   
		     	   if(status!=0) {
		     		return true;
		     	   }
		     		} catch (Exception e) {
		     			// TODO Auto-generated catch block
		     			e.printStackTrace();
		     		}
		     		return false;
		     	}
			

	public Bean getEmployeeDetailsById(int id) {
		ResultSet res=null;
	
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "select * from details where sid=?";

		try (Connection connection = (Connection) DriverManager.getConnection(url);
				java.sql.PreparedStatement ps = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
	
			ps.setInt(1, id);
			res = ps.executeQuery();
			Bean b3=new Bean();
			if(res.next()) {
				b3.setSid(res.getInt("sid"));
				b3.setSname(res.getString("name"));
				b3.setEmail(res.getString("email"));
				b3.setDept(res.getInt("dept"));
				return b3;
				
			} else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
		return null;
	}
		

	public ArrayList<Bean> getAllEmployeeDetails() {
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=root";
		String query = "select * from details";
       ArrayList<Bean> bean=new ArrayList<Bean>();
		try (Connection connection = (Connection) DriverManager.getConnection(url);
				java.sql.PreparedStatement ps = connection.prepareStatement(query);
				ResultSet res = ps.executeQuery();) {
			Class.forName("com.mysql.jdbc.Driver");
			Bean b4=new Bean();
			if(res.next()) {
				b4.setSid(res.getInt("sid"));
				b4.setSname(res.getString("name"));
				b4.setEmail(res.getString("email"));
				b4.setDept(res.getInt("dept"));
				bean.add(b4);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
				
			
	
}
