package com.siddiqui.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siddiqui.model.Employee;
import com.siddiqui.services.EmployeeServices;
import com.siddiqui.utils.Utils;

public class LoginControllerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utils.log.debug("debugging");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		RequestDispatcher reqDispatch = null;

		Employee employee = EmployeeServices.findbyUsername(username);

		if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {

			String role = EmployeeServices.findByRoleId(employee.getUser_role_id());

			Utils.currentEmployee = employee;

			if (role.equals("employee")) {
				response.sendRedirect("/static/ProjectOne/employeeportal.html");

			} else if (role.equals("manager")) {
				response.sendRedirect("/static/ProjectOne/managerportal.html");
			}
		} else {

			reqDispatch.include(request, response);
			out.print("<span style='color:red; text-align:center'>Invalid Username or Password </span>");
		}
	}

}
