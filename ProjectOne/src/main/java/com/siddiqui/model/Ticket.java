package com.siddiqui.model;

public class Ticket {
	String firstname;
	String lastname;
	String type;
	String description;
	String amount;
	String dateSubmitted;
	String status;
	String approver;
	String dateResolved;

	public Ticket(String firstname, String lastname, String type, String description, String amount,
			String dateSubmitted, String status, String approver, String dateResolved) {
		super();
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

	@Override
	public String toString() {
		return "Ticket [type=" + type + ", description=" + description + ", amount=" + amount + ", dateSubmitted="
				+ dateSubmitted + ", status=" + status + ", approver=" + approver + ", dateResolved=" + dateResolved
				+ ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
