package com.yse.app.test.departments;

import com.yse.app.departments.DepartmentDAO;

public class DepartmentsTest {

	public static void main(String[] args) {
		
		DepartmentDAO dao = new DepartmentDAO();
		try {
			dao.detail(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

	
