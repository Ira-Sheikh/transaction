package com.rapipay.transaction.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int agentId;
	private String agentName;
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentState() {
		return agentState;
	}

	public void setAgentState(String agentState) {
		this.agentState = agentState;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void setWalletBalance(double walletBalance) {
		this.walletBalance = walletBalance;
	}

	private String agentState;
	private String bankName;
	private long accountNumber;
	private long phoneNumber;
	private double walletBalance;
	
	public Agent(String agentName, String agentState, String bankName, long accountNumber, long phoneNumber, double walletBalance) {
		this.agentName = agentName;
		this.agentState = agentState;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.walletBalance = walletBalance;
	}}

	