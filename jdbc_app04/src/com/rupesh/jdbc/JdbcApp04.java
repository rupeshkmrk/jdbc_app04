package com.rupesh.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = null; 
		BufferedReader br = null;
		Statement st = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "orcl");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			while(true) {

				System.out.print("Enter Employee No : ");
				int empNo = Integer.parseInt(br.readLine());
				System.out.print("Enter Employee Name : ");
				String name = br.readLine();
				String query = "insert into emp values (" + empNo + ",'" + name + "')";
				st.execute(query);
				System.out.println("Employee added successfully");
				System.out.println("Do you want to add more employee ? : [Yes/No]");
				String choice = br.readLine();
				if(choice.toUpperCase().equals("YES")){
					continue;
				}
				else
					break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}finally {
			try {
				br.close();
				con.close();
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
