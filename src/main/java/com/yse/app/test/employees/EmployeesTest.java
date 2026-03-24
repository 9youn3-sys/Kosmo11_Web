package com.yse.app.test.employees;

import com.yse.app.employees.EmployeesDAO;

public class EmployeesTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		try {
			dao.eone(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
