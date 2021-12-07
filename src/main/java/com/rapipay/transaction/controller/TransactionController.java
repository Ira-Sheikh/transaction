package com.rapipay.transaction.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rapipay.transaction.entity.Agent;
import com.rapipay.transaction.entity.Client;
import com.rapipay.transaction.entity.Transaction;
import com.rapipay.transaction.services.TransactionServices;


@RestController
public class TransactionController {

	@Autowired
	
	TransactionServices service;
	
	
	@GetMapping("/transaction/client/{id}")
	public List<Transaction> getTransactionByClientId(@PathVariable int id)
	{
		return service.getTransactionByClientId(id);
	}
	
	@GetMapping("/transaction/agent/{id}")
	public List<Transaction> getTransactionByAgentId(@PathVariable int id)
	{
		return service.getTransactionByClientId(id);
	}

	
	@GetMapping("/transaction/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		return service.getTransaction(id);
	}
	
	
	@GetMapping("/transaction/all")
	public List<Transaction> getAllTransaction() {
		return service.getAllTransaction();
	}
	
	@PostMapping("/transaction/insert")
	public Transaction insertTransaction(@RequestBody Transaction transaction) {
		return service.insertTransaction(transaction);
	}
	
	@PutMapping("/transaction/update/{id}")
	public Object updateTransaction(@RequestBody Transaction tx, @PathVariable int id) {
		return service.updateTransaction(tx, id);
	}
	
	@DeleteMapping("/transaction/delete/{id}")
	public String deleteTransaction(@PathVariable int id) {
		return service.deleteTransaction(id);
	}
	
	
	@Autowired
	RestTemplate restTemplate;
	@PostMapping("/fundTransfer")
	public String findTransfer(@RequestBody Transaction t) {
		
		
		Integer agentId = t.getAgentId();
		Integer clientId = t.getClientId();
		
		Agent agent = this.restTemplate.getForObject("http://localhost:8085/agent/"+agentId, Agent.class);
		Client client = this.restTemplate.getForObject("http://localhost:8082/client/"+clientId, Client.class);
		if(agent==null) {
			return "Agent of this id is not exits";
		}
		
		if(client==null) {
			return "Client of this id is not exits";
		}
		
		
			if(agent.getWalletBalance()-t.getAmount()<5000) {
				return "Sorry!! Agent does not have sufficient balance";
			}
			else {
				agent.setWalletBalance(agent.getWalletBalance()-t.getAmount());
				client.setWalletBalance(client.getWalletBalance()+t.getAmount());
				
			}
			
			
		

				
			
		
		

		//updating agent details
		this.restTemplate.put("http://localhost:8085/agent/update/"+agentId, agent);
		
		//updating client details
		this.restTemplate.put("http://localhost:8082/client/update/"+clientId, client);
		
		this.service.fundTransfer(t);
		return "Fund Transfer completed successfully";
	}
	}
