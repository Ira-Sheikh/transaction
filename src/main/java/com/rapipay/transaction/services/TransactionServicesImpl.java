package com.rapipay.transaction.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.transaction.dao.TransactionDao;
import com.rapipay.transaction.entity.Transaction;


@Service
public class TransactionServicesImpl implements TransactionServices {
	@Autowired
	TransactionDao transactionDao; 

	

	

	@Override
	public Transaction getTransaction(int id) {
		return transactionDao.findById(id).get();
	}

	@Override
	public Transaction insertTransaction(Transaction tx) {
		return transactionDao.saveAndFlush(tx);
	}

	@Override
	public Object updateTransaction(Transaction tx, int id) {
		if(transactionDao.existsById(id)) {
			Transaction oldTx = transactionDao.findById(id).get();
			
			oldTx.setAgentId(tx.getAgentId() != 0 ? tx.getAgentId() : oldTx.getAgentId());
			oldTx.setClientId(tx.getClientId() != 0 ? tx.getClientId() : oldTx.getClientId());
			oldTx.setAmount(tx.getAmount() != 0 ? tx.getAmount() : oldTx.getAmount());
			oldTx.settType(tx.gettType() != null ? tx.gettType() : oldTx.gettType());
			oldTx.settDate(tx.gettDate() != null ? tx.gettDate() : oldTx.gettDate());
		    return transactionDao.saveAndFlush(oldTx);
		}
		return "Transaction Not Found";
	}

	@Override
	public String deleteTransaction(int id) {
		transactionDao.deleteById(id);
		return "Transaction Deleted";
	}


	@Override
	public List<Transaction> getAllTransaction() {
		return transactionDao.findAll();
	}

}
