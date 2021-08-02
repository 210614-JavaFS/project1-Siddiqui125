package com.siddiqui.model;

public class Status {

	String status;
	int status_id;

	public Status(int status_id, String status) {
		this.status_id = status_id;
		this.status = status;
	}

	public Status() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	@Override
	public String toString() {
		return "Status [status=" + status + "]";
	}

}
