package com.siddiqui.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.siddiqui.Authentication.Login;
import com.siddiqui.controllers.EmployeeController;
import com.siddiqui.controllers.ReimbursementController;
import com.siddiqui.model.Employee;
import com.siddiqui.services.EmployeeServices;

public class LoginControllerServlet extends HttpServlet {

	private EmployeeController employeeController = new EmployeeController();
	private ReimbursementController controller = new ReimbursementController();

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("application/json");
//
//		response.setStatus(404);
//
//		final String URL = request.getRequestURI().replace("/ProjectOne/", "");// strip out base URL info
//
//		System.out.println(URL);
//
//		String[] URLSections = URL.split("/");
//
////		switch (URLSections[0]) {
////		case "userLogin":
////			
////			break;
////		case "empployeeprotal":
////			employeeController.getAllTickets(response);
////			break;
////		case "home":
////			if (URLSections.length == 1) {
////				if (request.getMethod().equals("GET")) {
////					employeeController.getAllTickets(response);
////				}
////				else
////				if (request.getMethod().equals("POST")) {
////					
////				}
////			}
////			 else if (URLSections.length == 2) {
////				 URl is home/{HomeName} so urlselction
////				homeController.getOneHome(response, URLSections[1].toLowerCase())
////			}
////			break;
//
//		// }
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher reqDispatch = null;
		PrintWriter printWriter = response.getWriter();

		Employee employee = EmployeeServices.findbyUsername(username);

		if (username.equals(employee.getUsername()) && password.equals(employee.getPassword())) {

			Utils.currentEmployee = employee;

			String role = EmployeeServices.findByRoleId(employee.getUser_role_id());

			if (role.equals("employee")) {
				final String URL = request.getRequestURI().replace("/ProjectOne/login", "");// strip out base URL info
				System.out.println("Fakhar: " + URL);
				reqDispatch = request.getRequestDispatcher(URL + "/static/ProjectOne/employeeportal.html");
			} else if (role.equals("manager")) {
				reqDispatch = request.getRequestDispatcher("/static/projectone/managerportal.html");
			}

			reqDispatch.forward(request, response);

		} else {
			reqDispatch = request.getRequestDispatcher("index.html");
			reqDispatch.include(request, response);
			printWriter.print("<span style='color:red; text-align:center'>Invalid Username or Password </span>");
		}
	}
}
//		String username = request.getParameter("user_name");
//		String password = request.getParameter("password");
//
//		RequestDispatcher reqDispatch = null;
//		PrintWriter printWriter = response.getWriter();
//
//		String htmlRespone = "<html>";
//		htmlRespone += "<h2>Your username is: " + " : Password: " + password + "</h2>";
//		htmlRespone += "</html>";
//
//		printWriter.println(htmlRespone);
//
