package com.training;
import java.sql.*;  

public class Jdbc {

	public static void main(String[] args) {
//		String query= "select * from alien where fname='Ram'";
//		String query="";
		try{  
		Class.forName("com.mysql.cj.jdbc.Driver");  
		  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/detail","root","root");  
		  
//		PreparedStatement stmt=con.prepareStatement("insert into alien values(?,?,?,?,?)");  
//		PreparedStatement stmt=con.prepareStatement("delete from alien where aid=?"); 
		PreparedStatement stmt=con.prepareStatement("update alien set color='Pink',fname='Karan' where aid=?"); 

		
		stmt.setInt(1,104);//1 specifies the first parameter in the query  
//		stmt.setString(2,"Mahesh");  
//		stmt.setString(3, "Babu");
//		stmt.setString(4, "Sahay");
//		stmt.setString(5, "pink");
		  
		int i=stmt.executeUpdate();  
		System.out.println(i+" records affected");  
		
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery(query); 
//		int result=stmt.executeUpdate("delete from emp765 where id=33");  
//		System.out.println(result+" records affected");  
		  
//		String data="";
//		while(rs.next()) {
//			data=rs.getInt(1)+": "+rs.getString(2)+": "+rs.getString(3)+": "+rs.getString(5);
//			System.out.println(data);
//		}
		stmt.close();
		con.close(); 
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
