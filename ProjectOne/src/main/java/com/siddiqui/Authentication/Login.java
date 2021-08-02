package com.siddiqui.Authentication;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddiqui.model.Employee;
import com.siddiqui.services.EmployeeServices;
import com.siddiqui.utils.Utils;

public class Login {

	private static ObjectMapper objMapper = new ObjectMapper();

	public static void userscreen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher reqDispatch = null;

		PrintWriter printWriter = response.getWriter();

		Employee employee = EmployeeServices.findbyUsername(username);
		String role = EmployeeServices.findByRoleId(employee.getUser_role_id());

		String json = objMapper.writeValueAsString(employee);

		System.out.println(json);

		printWriter.print(json);
		response.setStatus(200);

	}

}
