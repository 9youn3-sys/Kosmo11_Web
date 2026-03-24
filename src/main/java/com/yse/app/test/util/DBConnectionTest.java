//DBConnection 실행 여부를 위한 테스트용 메인 메서드

package com.yse.app.test.util;

import java.sql.Connection;

import com.yse.app.departments.DepartmentDAO;
import com.yse.app.util.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
		try {
			dao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
