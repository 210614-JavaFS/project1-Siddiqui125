package com.siddiqui.Authentication;

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

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("userId");
		String password = req.getParameter("password");

		RequestDispatcher reqDispatch = null;
		PrintWriter printWriter = resp.getWriter();

		Employee employee = EmployeeServices.findbyUsername(username);

		if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {

			Utils.currentEmployee = employee;

			String role = EmployeeServices.findByRoleId(employee.getUser_role_id());

			if (role.equals("employee")) {
				reqDispatch = req.getRequestDispatcher("employeeportal.html");
			} else if (role.equals("manager")) {
				reqDispatch = req.getRequestDispatcher("managerportal.html");
			}

			reqDispatch.forward(req, resp);

		} else {
			reqDispatch = req.getRequestDispatcher("index.html");
			reqDispatch.include(req, resp);
			printWriter.print("<span style='color:red; text-align:center'>Invalid Username or Password </span>");
		}
	}
}
