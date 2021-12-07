package com.rapipay.transaction.services;

import java.util.List;

import com.rapipay.transaction.entity.Transaction;

public interface TransactionServices {
	
    public Transaction getTransaction(int id);
    
    public List<Transaction> getAllTransaction();
	
	public Transaction insertTransaction(Transaction tx);
	
	public Object updateTransaction(Transaction tx, int id);
	
	public String deleteTransaction(int id);

	List<Transaction> getTransactionByAgentId(Integer agentId);

	String fundTransfer(Transaction transaction);

	List<Transaction> getTransactionByClientId(Integer clientId);
}
