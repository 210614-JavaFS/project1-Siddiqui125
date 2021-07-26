package com.siddiqui.services;

import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.repos.EmployeeDAO;
import com.siddiqui.repos.EmployeeDAOImp;

public class EmployeeServices {

	private static EmployeeDAO dao = new EmployeeDAOImp();

	public static List<Employee> allTickets() {
		return dao.allTickets();
	}

	public static boolean addRequest(ReimbursementPlan plan) {
		return dao.addRequest(plan);
	}

	public static Employee findbyUsername(String username) {
		return dao.findbyUsername(username);

	}

	public static String findByRoleId(int roleid) {
		return dao.findByRoleId(roleid);
	}

}
