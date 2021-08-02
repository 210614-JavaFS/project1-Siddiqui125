package com.siddiqui.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.model.Status;
import com.siddiqui.model.Ticket;
import com.siddiqui.model.Type;
import com.siddiqui.utils.Utils;

public class EmployeeServlet extends HttpServlet {
	HttpServletResponse response;

	private static ObjectMapper objMapper = new ObjectMapper();

	public void showAllTickets(HttpServletResponse response) throws IOException {

		List<ReimbursementPlan> list = Utils.reimbursementService
				.getAllTicketByUserId(Utils.currentEmployee.getUserId());
		List<Ticket> ticketList = new ArrayList<>();

		for (ReimbursementPlan item : list) {

			String firstname = Utils.employeeServices.getUsernameByUserId(item.getReimb_author()).getFirstname();
			String lastname = Utils.employeeServices.getUsernameByUserId(item.getReimb_author()).getLastname();
			String type = Utils.reimbursementService.findTypeById(item.getRemib_typeId()).getType();
			String description = item.getRemib_despcription();
			String amount = String.valueOf(item.getRemib_amount());
			String dateSubmitted = item.getRemib_submitted();
			String status = Utils.reimbursementService.findStatusById(item.getRemib_statusId()).getStatus();
			String approver;
			if (item.getRemib_resolver() == 0) {
				approver = " ";
			} else {
				approver = Utils.employeeServices.getUsernameByUserId(item.getRemib_resolver()).getFirstname();
			}

			String dateResolved = item.getRemib_resolved();
			Ticket ticket = new Ticket(firstname, lastname, type, description, amount, dateSubmitted, status, approver,
					dateResolved);
			ticketList.add(ticket);

		}

		String json = objMapper.writeValueAsString(ticketList);

		System.out.println(json);
		PrintWriter printWriter = response.getWriter();
		printWriter.print(json);
		response.setStatus(200);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		response.setStatus(404);
		showAllTickets(response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String amount = request.getParameter("amount");
		String description = request.getParameter("description".replace("%20", " "));
		String ticketType = request.getParameter("ticketType");

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		String dateSubmitted = dtf.format(now);

		ReimbursementPlan ticket = new ReimbursementPlan(Integer.valueOf(amount), dateSubmitted, "", description,
				Utils.currentEmployee.getUserId(), Utils.currentPlan.getRemib_resolver());

		if (Utils.reimbursementService.addRequest(ticket)) {

			System.out.println("Ticket Added Successfully");
		} else {
			System.out.println("Error while adding ticket into database");
		}

		List<ReimbursementPlan> ticketList = Utils.reimbursementService
				.getAllTicketByUserId(Utils.currentEmployee.getUserId());

		ReimbursementPlan ticketFromDb = ticketList.get(ticketList.size() - 1);

		Status currentTicketStatus = new Status(ticketFromDb.getRemib_statusId(), "Pending");
		if (Utils.reimbursementService.addStatus(currentTicketStatus)) {
			System.out.println("Ticket Status updated in Database");
		} else {
			System.out.println("Error while updating Ticket Status in Database");
		}

		Type currentTicketType = new Type(ticketFromDb.getRemib_typeId(), ticketType);

		if (Utils.reimbursementService.addTicketType(currentTicketType)) {
			System.out.println("Ticket Type updated in Database");
			out.println("<p> Congratulations, you has been successfully Submitted the Request</p>");
			response.sendRedirect("/static/ProjectOne/employeeportal.html");

		} else {

			System.out.println("Error while updating Ticket Type in Database");
		}
	}

}
