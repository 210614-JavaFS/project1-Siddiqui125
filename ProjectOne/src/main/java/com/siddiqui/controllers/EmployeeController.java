package com.siddiqui.controllers;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.services.EmployeeServices;
import com.siddiqui.utils.Utils;

public class EmployeeController extends HttpServlet {

	private static ObjectMapper objMapper = new ObjectMapper();

	public void getAllTickets(HttpServletResponse response) throws IOException {
		List<Employee> list = EmployeeServices.allTickets();

		String json = objMapper.writeValueAsString(list);

		response.getWriter().print(json);
		response.setStatus(200);
	}

	public void addRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BufferedReader bufferedReader = request.getReader();
		StringBuilder builder = new StringBuilder();
		String line = bufferedReader.readLine();

		while (line != null) {
			builder.append(line);
			line = bufferedReader.readLine();
		}
		String body = new String(builder);
		ReimbursementPlan remib_request = new ReimbursementPlan();
		remib_request = objMapper.readValue(body, ReimbursementPlan.class);

		if (Utils.reimbursementService.addRequest(remib_request)) {
			response.setStatus(201);
		} else {
			response.setStatus(406);
		}
	}
}
