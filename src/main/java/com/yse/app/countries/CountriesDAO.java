package com.yse.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

import com.yse.app.util.DBConnection;

public class CountriesDAO {
	
	
	public void ci(String countryid) throws Exception {
		//한개의 정보만 꺼내고 싶을 때
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryid);
		//? 값 세팅 
				//원래는 첫번재가 0번이지만 오라클에서는 첫번째가 1번 
				//첫번째에 들어갈 값을 지정해줘야 하는데 몇번째인지 모르니 작성한 값을 가져오기 위해 
				//public void ci(String countryid) 매개변수 넣어주고 세팅도 아래처럼 해준다.
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("COUNTRY_NAME");
			System.out.println(name);
			
		}else {
			System.out.println("부서가 없다");
			
		}
		rs.close();
		st.close();
		con.close();
	}
	
	public void list() throws Exception {
		
		DBConnection connection = new DBConnection();
		Connection con = connection.getConnection();
		
		
		String sql = "SELECT * FROM COUNTRIES";
		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String name  = rs.getString("COUNTRY_NAME");
			String id = rs.getString("COUNTRY_ID");
			System.out.println(name + " : "+ id);
			
		
			
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		
	}

}
