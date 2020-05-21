package com.javaClasses;

public class Message {

	private int messageId;
	private int accountNo;
	private String name;
	private String email;
	private String message;
	private String time;
	
	public Message(int messageId, int accountNo, String name, String email,String message, String time) {
		this.messageId = messageId;
		this.accountNo = accountNo;
		this.name = name;
		this.email = email;
		this.message = message;
		this.time = time;
	}

	public int getMessageId() {
		return messageId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public String getEmail() {
		return email;
	}

	public String getTime() {
		return time;
	}

}
