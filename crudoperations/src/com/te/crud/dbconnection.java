
package com.te.crud;

import java.sql.Connection;

import java.sql.DriverManager;

public class dbconnection {
	public static void main(String[] args) {
		dbconnection obj_db_connection=new dbconnection();
		System.out.println(obj_db_connection.get_connection());
	}
	
public Connection get_connection() {
	Connection connection=null;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
		
	}catch(Exception e) {
		System.out.println(e);
	}
	return connection;
}
}