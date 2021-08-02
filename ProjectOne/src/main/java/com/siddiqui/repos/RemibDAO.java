package com.siddiqui.repos;

import java.util.List;

import com.siddiqui.model.Employee;
import com.siddiqui.model.ReimbursementPlan;
import com.siddiqui.model.Status;
import com.siddiqui.model.Type;

public interface RemibDAO {

	boolean addStatus(Status status);

	boolean addType(Type type);

	boolean addRequest(ReimbursementPlan plan);

	List<ReimbursementPlan> viewAllTickets();

	public Status findStatusbyID(int status_id);

	public Type findTypebyID(int type_id);

	public List<ReimbursementPlan> getAllTicketByUserId(int userId);

	public List<ReimbursementPlan> getAllbyReimbID(String reimb_id);

	public boolean approveStatusByReimbid(int reimb_id, String action);

	public boolean denyStatusByReimbid(int reimb_id, String action);

	public boolean updateStatusByStatusId(int status_id, String status);

}
