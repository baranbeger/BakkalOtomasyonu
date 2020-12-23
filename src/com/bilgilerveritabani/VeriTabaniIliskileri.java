package com.bilgilerveritabani;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class VeriTabaniIliskileri {
	
	Connection con=null;
	Statement std=null;
	ResultSet rs=null;
	
	public ResultSet Listele(String sorgu) {
		try {
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456789.");
			std=(Statement) con.createStatement();
			rs=std.executeQuery(sorgu);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
    public Statement Ekle(String sorgu) {
    	try {
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456789.");
			std=(Statement) con.createStatement();
			std.executeUpdate(sorgu);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return std;
		
    	
		
	}
    public Statement sil(String sorgu) {
     	try {
 			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456789.");
 			std=(Statement) con.createStatement();
 			std.executeUpdate(sorgu);
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return std;
 	}
     public Statement Editle(String sorgu) {
     	try {
 			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","123456789.");
 			std=(Statement) con.createStatement();
 			std.executeUpdate(sorgu);
 			
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return std;
 	}

   
     
     
     
     

    }
