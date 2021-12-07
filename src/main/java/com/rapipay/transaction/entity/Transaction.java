package com.rapipay.transaction.entity;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Generated;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	private LocalDate tDate=LocalDate.now();
	public int gettId() {
		return tId;
	}


	public LocalDate gettDate() {
		return tDate;
	}

	public void settDate(LocalDate tDate) {
		this.tDate = tDate;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String gettType() {
		return tType;
	}

	public void settType(String tType) {
		this.tType = tType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private int agentId;
	private int clientId;
	private String tType;
	private int amount;
	
	public Transaction(LocalDate tDate, int agentId, int clientId, String type, int amount) {
	
		this.agentId = agentId; 
		this.clientId = clientId;
		this.tType = type;
		this.amount = amount;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	

	
}