package com.siddiqui.model;

public class ReimbursementPlan {
	int remib_id;
	int remib_amount;
	String remib_submitted;
	String remib_resolved;
	String remib_despcription;
	int reimb_author;
	int remib_resolver;
	int remib_statusId;
	int remib_typeId;

	public ReimbursementPlan() {
		super();
	}

	public ReimbursementPlan(int remib_amount, String remib_submitted, String remib_resolved, String remib_despcription,
			int reimb_author, int remib_resolver) {
		super();
		this.remib_amount = remib_amount;
		this.remib_submitted = remib_submitted;
		this.remib_resolved = remib_resolved;
		this.remib_despcription = remib_despcription;
		this.reimb_author = reimb_author;
		this.remib_resolver = remib_resolver;
	}

	public int getRemib_id() {
		return remib_id;
	}

	public void setRemib_id(int remib_id) {
		this.remib_id = remib_id;
	}

	public int getRemib_amount() {
		return remib_amount;
	}

	public void setRemib_amount(int remib_amount) {
		this.remib_amount = remib_amount;
	}

	public String getRemib_submitted() {
		return remib_submitted;
	}

	public void setRemib_submitted(String remib_submitted) {
		this.remib_submitted = remib_submitted;
	}

	public String getRemib_resolved() {
		return remib_resolved;
	}

	public void setRemib_resolved(String remib_resolved) {
		this.remib_resolved = remib_resolved;
	}

	public String getRemib_despcription() {
		return remib_despcription;
	}

	public void setRemib_despcription(String remib_despcription) {
		this.remib_despcription = remib_despcription;
	}

	public int getReimb_author() {
		return reimb_author;
	}

	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}

	public int getRemib_resolver() {
		return remib_resolver;
	}

	public void setRemib_resolver(int remib_resolver) {
		this.remib_resolver = remib_resolver;
	}

	public int getRemib_statusId() {
		return remib_statusId;
	}

	public void setRemib_statusId(int remib_statusId) {
		this.remib_statusId = remib_statusId;
	}

	public int getRemib_typeId() {
		return remib_typeId;
	}

	public void setRemib_typeId(int remib_typeId) {
		this.remib_typeId = remib_typeId;
	}

	@Override
	public String toString() {
		return "ReimbursementPlan [remib_id=" + remib_id + ", remib_amount=" + remib_amount + ", remib_submitted="
				+ remib_submitted + ", remib_resolved=" + remib_resolved + ", remib_despcription=" + remib_despcription
				+ ", reimb_author=" + reimb_author + ", remib_resolver=" + remib_resolver + ", remib_statusId="
				+ remib_statusId + ", remib_typeId=" + remib_typeId + "]";
	}

}
