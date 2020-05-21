package com.javaClasses;

public class Transaction {

	private int transactionId;
	private int senderNumber;
	private int receiverNumber;
	private double amount;
	
	public Transaction(int transactionId, int senderNumber, int receiverNumber, double amount) {
		this.transactionId = transactionId;
		this.senderNumber = senderNumber;
		this.receiverNumber = receiverNumber;
		this.amount = amount;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public int getSenderNumber() {
		return senderNumber;
	}

	public int getReceiverNumber() {
		return receiverNumber;
	}

	public double getAmount() {
		return amount;
	}
}
