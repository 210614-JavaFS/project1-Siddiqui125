package com.siddiqui.servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.siddiqui.model.ManagerTickets;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.services.ReimbursementService;
import com.siddiqui.utils.Utils;

public class ManagerServlet extends HttpServlet {

	private static ObjectMapper objMapper = new ObjectMapper();

	public void showAllTickets(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("application/json");

//		response.setStatus(404);

		List<ReimbursementPlan> list = Utils.reimbursementService.getAllTickets();
		List<ManagerTickets> ticketList = new ArrayList<>();

		for (ReimbursementPlan item : list) {
			String reimb_id = String.valueOf(item.getRemib_id());
			String type = Utils.reimbursementService.findTypeById(item.getRemib_typeId()).getType();

			String dateSubmitted = item.getRemib_submitted();
			String status = Utils.reimbursementService.findStatusById(item.getRemib_statusId()).getStatus();
			String approver;
			if (item.getRemib_resolver() == 0) {
				approver = " ";
			} else {
				approver = Utils.employeeServices.getUsernameByUserId(item.getRemib_resolver()).getFirstname();
			}
			String firstname = Utils.employeeServices.getUsernameByUserId(item.getReimb_author()).getFirstname();
			String lastname = Utils.employeeServices.getUsernameByUserId(item.getReimb_author()).getLastname();
			String dateResolved = item.getRemib_resolved();
			String description = item.getRemib_despcription();
			String amount = String.valueOf(item.getRemib_amount());
			ManagerTickets mticket = new ManagerTickets(reimb_id, firstname, lastname, type, description, amount,
					dateSubmitted, status, approver, dateResolved);
			ticketList.add(mticket);

		}

		String json = objMapper.writeValueAsString(ticketList);

		PrintWriter printWriter = response.getWriter();

		printWriter.print(json);
		response.setStatus(200);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String epath = request.getServletPath();

		if (epath.equals("/list")) {
			response.setContentType("application/json");
			response.setStatus(404);
			showAllTickets(request, response);
		} else if (epath.equals("/approve")) {

			String reimb_id = request.getParameter("approveId");
			Utils.reimbursementService.approveStatusByReimbid(Integer.valueOf(reimb_id), "approve");

		} else if (epath.equals("/deny")) {

			String reimb_id = request.getParameter("denyId");
			Utils.reimbursementService.denyStatusByReimbid(Integer.valueOf(reimb_id), "deny");

		}

	}
}
