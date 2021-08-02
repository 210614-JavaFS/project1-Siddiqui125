package com.siddiqui.services;

import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.model.Status;
import com.siddiqui.model.Type;
import com.siddiqui.repos.ReimbursementDAOImp;
import com.siddiqui.repos.RemibDAO;

public class ReimbursementService {

	private static RemibDAO remibDAO = new ReimbursementDAOImp();

	public static List<ReimbursementPlan> getAllTickets() {
		return remibDAO.viewAllTickets();
	}

	public boolean addRequest(ReimbursementPlan plan) {
		return remibDAO.addRequest(plan);
	}

	public static boolean addStatus(Status status) {
		return remibDAO.addStatus(status);

	}

	public static boolean addTicketType(Type type) {
		return remibDAO.addType(type);
	}

	public static List<ReimbursementPlan> getAllTicketByUserId(int userId) {
		return remibDAO.getAllTicketByUserId(userId);
	}

	public static Type findTypeById(int typeId) {
		return remibDAO.findTypebyID(typeId);
	}

	public static Status findStatusById(int statusId) {
		return remibDAO.findStatusbyID(statusId);
	}

	public static List<ReimbursementPlan> findAllbyReimbID(String reimb_id) {
		return remibDAO.getAllbyReimbID(reimb_id);
	}

	public static boolean approveStatusByReimbid(int reimb_id, String action) {
		return remibDAO.approveStatusByReimbid(reimb_id, action);
	}

	public static boolean denyStatusByReimbid(int reimb_id, String action) {
		return remibDAO.denyStatusByReimbid(reimb_id, action);
	}

	public boolean updateStatusByStatusId(int status_id, String status) {
		return remibDAO.updateStatusByStatusId(status_id, status);
	}

}
