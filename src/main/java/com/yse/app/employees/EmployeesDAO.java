package com.yse.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yse.app.util.DBConnection;

public class EmployeesDAO {
	
	//멤버변수 선언 
	private DBConnection connection;
	
	public EmployeesDAO() {
		
		this.connection = new DBConnection();
	}
	
	
	public void eone(int employee_id) throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
				
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, employee_id);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getNString("FIRST_NAME");
			System.out.println(name);
			
		}else {
			System.out.println("없다");
		}
		
		rs.close();
		st.close();
		con.close();
			
	}
	
	//전체 데이터 이름, 사원ID조회 
	public void eall() throws Exception {
		
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			String name = rs.getString("FIRST_NAME");
			String id = rs.getString("EMPLOYEE_ID");
			System.out.println(name + " : "+ id);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
