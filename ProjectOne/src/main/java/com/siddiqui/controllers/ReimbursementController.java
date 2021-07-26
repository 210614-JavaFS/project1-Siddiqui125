package com.siddiqui.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.services.ReimbursementService;

public class ReimbursementController {
//	private ReimbursementService reimbursementService = new ReimbursementService();
//	private ObjectMapper mapper = new ObjectMapper();
//
//	public void getAllTickets(HttpServletResponse response) throws ServletException, IOException {
//		List<ReimbursementPlan> list = ReimbursementService.getAllTickets();
//
//		String json = mapper.writeValueAsString(list);
//		response.getWriter().print(json);
//
//		response.setStatus(200);
//	}
//
//	public void addRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//		BufferedReader bufferedReader = request.getReader();
//		StringBuilder builder = new StringBuilder();
//		String line = bufferedReader.readLine();
//
//		while (line != null) {
//			builder.append(line);
//			line = bufferedReader.readLine();
//		}
//		String body = new String(builder);
//
//		ReimbursementPlan plan = mapper.readValue(body, ReimbursementPlan.class);
//		if (ReimbursementService.addRequest(plan)) {
//			response.setStatus(201);
//		} else {
//			response.setStatus(406);
//		}
//	}
}
