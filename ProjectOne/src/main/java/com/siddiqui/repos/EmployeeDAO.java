package com.siddiqui.repos;

import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;

public interface EmployeeDAO {

	public List<Employee> allTickets();

	public boolean addRequest(ReimbursementPlan plan);

	public Employee findbyUsername(String username);

	public String findByRoleId(int roleId);

}
