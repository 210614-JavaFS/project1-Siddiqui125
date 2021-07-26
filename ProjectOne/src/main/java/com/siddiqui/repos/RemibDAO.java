package com.siddiqui.repos;

import java.util.List;

import com.siddiqui.model.ReimbursementPlan;

public interface RemibDAO {

	boolean addRequest(ReimbursementPlan plan);

	List<ReimbursementPlan> viewAllTickets();

}
