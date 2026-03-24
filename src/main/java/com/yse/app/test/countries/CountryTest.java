package com.yse.app.test.countries;

import com.yse.app.countries.CountriesDAO;
import com.yse.app.departments.DepartmentDAO;

public class CountryTest {

public static void main(String[] args) {
		
		CountriesDAO dao = new CountriesDAO();
		try {
			dao.ci("US");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
