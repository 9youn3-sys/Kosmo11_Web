package com.yse.app.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public Connection getConnection() throws Exception {
		
		//DB 호출 
		
		String user="hr";
		String password="hr";
		String url="jdbc:oracle:thin:@localhost:1521:xe"; //아이피,포트,SID
		String driver="oracle.jdbc.driver.OracleDriver"; //어떤 패키지 어떤 드라이버
		
		Class.forName(driver);//해당 코드는 위 driver클래스를 사용하겠다 
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
		
	}

}
