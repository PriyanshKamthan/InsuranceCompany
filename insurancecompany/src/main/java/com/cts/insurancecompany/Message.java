package com.cts.insurancecompany;

public class Message {
	String msg;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return msg;
	}

	public void setMessage(String message) {
		this.msg = message;
	}

	public Message(String message) {
		super();
		this.msg = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + msg + "]";
	}
}
