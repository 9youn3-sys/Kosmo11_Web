package com.yse.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yse.app.util.DBConnection;

public class DepartmentDAO {
	
	public void list() throws Exception {
		
		//1. DB 연결 (DB서버에 접속해서 로그인까지)
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		//2. 쿼리문 작성
		String sql="SELECT * FROM DEPARTMENTS";
		
		//3. 쿼리문 미리 전송 
		PreparedStatement st= con.prepareStatement(sql);
		
		
		//4. 결과처리 
		
		
		//5. 최종전송 및 결과 처리 
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("DEPARTMENT_NAME");
			int id = rs.getInt("DEPARTMENT_ID");
			System.out.println(name + " : "+ id);
			
		}
		
		//6. 연결 해제 
		rs.close();
		st.close();
		con.close();
		
	}

}
