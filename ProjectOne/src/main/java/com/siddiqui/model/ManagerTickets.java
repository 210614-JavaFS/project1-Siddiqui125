package com.siddiqui.model;

public class ManagerTickets {
	String reimb_id;
	String firstname;
	String lastname;
	String type;
	String description;
	String amount;
	String dateSubmitted;
	String status;
	String approver;
	String dateResolved;

	public ManagerTickets(String reimb_id, String firstname, String lastname, String type, String description, String amount, String dateSubmitted,
			String status, String approver, String dateResolved) {
		super();
		this.reimb_id = reimb_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.description = description;
		this.amount = amount;
		this.dateSubmitted = dateSubmitted;
		this.status = status;
		this.approver = approver;
		this.dateResolved = dateResolved;
	}

	public String getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(String reimb_id) {
		this.reimb_id = reimb_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getDateResolved() {
		return dateResolved;
	}

	public void setDateResolved(String dateResolved) {
		this.dateResolved = dateResolved;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ManagerTickets [reimb_id=" + reimb_id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", type=" + type + ", description=" + description + ", amount=" + amount + ", dateSubmitted="
				+ dateSubmitted + ", status=" + status + ", approver=" + approver + ", dateResolved=" + dateResolved
				+ "]";
	}

	

}
