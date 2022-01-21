
package com.te.crud;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class crud_test {
	
	
	public static void main(String[] args) {
		crud_test objtest=new crud_test();
	objtest.create_data("5", "angular", "angular@gmail.com");
	//	objtest.read_data("2");
		//objtest.update_data("4", "324", "java69", "java69@gmail.com");
		//objtest.delete_data("32");
	}
	
	
	public void update_data(String sl_no,String new_sl_no,String name,String email) {
		dbconnection obj_db_connection=new dbconnection();
		Connection connection=obj_db_connection.get_connection();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String query="update user set sl_no=?,name=?,email=? where sl_no=?";
			ps=(PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, new_sl_no);
			ps.setString(2, name);
			ps.setString(3, email);
			ps.setString(4, sl_no);
		
			System.out.println(ps);
			ps.executeUpdate();
			
			
		
			
			
		}catch(Exception e){
			System.out.println(e);
		}}
	
	public void read_data(String sl_no) {
		dbconnection obj_db_connection=new dbconnection();
		Connection connection=obj_db_connection.get_connection();
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			String query="select * from user where sl_no=?";
			ps=(PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, sl_no);
		
			System.out.println(ps);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				System.out.println("sl_no="+rs.getString("sl_no"));
				System.out.println("name="+rs.getString("name"));
				System.out.println("email="+rs.getString("email"));
				
				System.out.println("=============");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
public void create_data(String sl_no,String name,String email) {
	dbconnection obj_db_connection=new dbconnection();
	Connection connection=obj_db_connection.get_connection();
	
	PreparedStatement ps=null;
	try {
		String query="insert into user(sl_no,name,email) values(?,?,?)";
		ps=(PreparedStatement) connection.prepareStatement(query);
		ps.setString(1, sl_no);
		ps.setString(2,name);
		ps.setString(3, email);
		System.out.println(ps);
		ps.executeUpdate();
		
	}catch(Exception e){
		System.out.println(e);
	}
}
public void delete_data(String sl_no) {
	dbconnection obj_db_connection=new dbconnection();
	Connection connection=obj_db_connection.get_connection();
	
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		String query="delete from user where sl_no=?";
		ps=(PreparedStatement) connection.prepareStatement(query);
		ps.setString(1,sl_no);
	
	
		System.out.println(ps);
		ps.executeUpdate();
		
		
	
		
		
	}catch(Exception e){
		System.out.println(e);
	}}


private Connection get_connection() {
	// TODO Auto-generated method stub
	return null;
}
}