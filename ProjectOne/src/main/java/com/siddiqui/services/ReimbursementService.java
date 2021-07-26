package com.siddiqui.services;

import java.util.List;

import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.repos.ReimbursementDAOImp;
import com.siddiqui.repos.RemibDAO;

public class ReimbursementService {

	private static RemibDAO remibDAO = new ReimbursementDAOImp();

	public List<ReimbursementPlan> getAllTickets() {
		return remibDAO.viewAllTickets();
	}

	public boolean addRequest(ReimbursementPlan plan) {
		return remibDAO.addRequest(plan);
	}

}
