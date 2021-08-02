package com.siddiqui.model;

public class Type {
	int type_id;
	String type;

	public Type( int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}

	public Type() {
		super();
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Type [type=" + type + "]";
	}

}
