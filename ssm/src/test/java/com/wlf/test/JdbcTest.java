package com.wlf.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
* @author 作者 危凌峰:
* @version 创建时间：2021年4月17日 下午8:59:49
*/
public class JdbcTest {
	 private static final String driver="com.mysql.jdbc.Driver";
	   //"jdbc:mysql://127.0.0.1:3306/数据库名称"
	   private static final String url="jdbc:mysql://localhost:3306/sit";
	   private static final String user="root";
	   private static final String pwd="123";
	   Connection conn=null;
	   PreparedStatement ps=null;
	   ResultSet rs=null;
	   public static Connection getConnection(){
		   Connection conn=null;
		   try{
			   Class.forName(driver);
			   conn=DriverManager.getConnection(url,user,pwd);
		   }catch (Exception e) {
			e.printStackTrace();
		}
		   return conn;
	   }
	   
	   public static  void closeAll(Connection conn){
		   try{
			   if(conn!=null){
				   conn.close();
				   System.out.println("Mysql close success!");
			   }
		   }catch (Exception e) {
			e.printStackTrace();
		}
	   }
	   
	  public static void main(String[] args) {
		 Connection conn= getConnection();
		  if(conn !=null){
			  System.out.println("Mysql connect success!");
		  }else{
			  System.out.println("Mysql connect failed!");
		  }
		  closeAll(conn);
	}
}
