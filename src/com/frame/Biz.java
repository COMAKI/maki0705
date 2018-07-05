package com.frame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public abstract class Biz<T,V> {
	String user;
	String password;
	String url; 
	
	
	
	public Biz() {
		
		InputStream inputStream = null;
		
		try{
			Properties prop = new Properties();
			
			prop.load(new FileInputStream("C:\\skagh-lee-web\\mvc1\\dbprop.txt"));
		
			user = prop.getProperty("dbuser");
			password = prop.getProperty("dbpassword");
			url = prop.getProperty("dburl");
 		
			System.out.println("aaaa "+user + " "+ url);
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			if(inputStream!=null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = 
			DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public abstract void register(T obj) throws Exception;
	public abstract void remove(V id) throws Exception;
	public abstract void modify(T obj) throws Exception;
	public abstract T get(V id) throws Exception;
	public abstract ArrayList<T> get() throws Exception;
	
}













