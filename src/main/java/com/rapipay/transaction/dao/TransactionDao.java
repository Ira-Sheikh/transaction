package com.rapipay.transaction.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.rapipay.transaction.entity.Transaction;

public interface TransactionDao extends JpaRepository<Transaction, Integer> {

}
