package com.yse.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yse.app.util.DBConnection;

public class DepartmentDAO {
	private DBConnection connection;
	
	public DepartmentDAO() {
		
		this.connection = new DBConnection();
	}
		
	
	
	public void detail(int departmentid) throws Exception {
		//부서 한개만 꺼낼 때 
		
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		//? 값 세팅 
		//원래는 첫번재가 0번이지만 오라클에서는 첫번째가 1번 
		//첫번째에 들어갈 값을 지정해줘야 하는데 몇번째인지 모르니 작성한 값을 가져오기 위해 
		//public void detail(int departmentid) 매개변수 넣어주고 세팅도 아래처럼 해준다.
		st.setInt(1, departmentid);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("DEPARTMENT_NAME");
			System.out.println(name);
			
		}else {
			System.out.println("부서가 없다");
			
		}
		
		rs.close();
		st.close();
		con.close();
	}
	
	public void list() throws Exception {
		
		//1. DB 연결 (DB서버에 접속해서 로그인까지)
		
		Connection con = connection.getConnection();
		
		//2. 쿼리문 작성
		String sql="""
				SELECT * FROM DEPARTMENTS
				ORDER BY DEPARTMENT_ID DESC
				""";
				
		
		//3. 쿼리문 미리 전송 
		PreparedStatement st= con.prepareStatement(sql);
		
		
		
		//4. 결과처리 (? 값을작성)
		
		
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
