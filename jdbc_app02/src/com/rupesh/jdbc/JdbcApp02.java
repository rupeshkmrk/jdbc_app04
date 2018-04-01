package com.rupesh.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp02 {

	public static void main(String[] args){
		Connection con = null;
		Statement st = null;
		BufferedReader br = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "orcl");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Table Name : ");
			String tblName = br.readLine();
			String sql = "create table " +  tblName + " (CNO number primary key, CName varchar2(10))";
			st.execute(sql);
			System.out.println("Table created Successfully");
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				br.close();
				con.close();
				st.close();
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
