package com.sangura.demoBMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangura.demoBMS.entities.Account;
import com.sangura.demoBMS.repo.AccountRepo;

@Service
public class AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	public Account createAccount(Account account) {
		return accountRepo.save(account);
	};
	
	public Account getAccountDetailsByAccountNumber(long accountNumber) {
		return accountRepo.findById(accountNumber).orElseThrow(() -> new RuntimeException ("Given account number is incorrect"));
	};
	
	public List<Account> getAllAccountDetails(){
		return accountRepo.findAll();
	};
	
	public Account depositAmount (Long accountNumber, double amount) {
		Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new RuntimeException ("Given account number is incorrect"));
		double newBalance = account.getAccountBalance() + amount;
		account.setAccountBalance(newBalance);
		return accountRepo.save(account);
		
	};
	
	public Account withdrawAmount(Long accountNumber, double amount) {
		if (amount < 50.0 ) {
			throw new IllegalArgumentException("Minimum withdrawable amount is 50");
		}
		Account account = accountRepo.findById(accountNumber).orElseThrow(() -> new RuntimeException ("Given account number is incorrect"));
		double availableBalance = account.getAccountBalance();
		
		if (availableBalance < amount) {
			throw new IllegalArgumentException("Insufficient balance in your account");
		}
		double newAmount = availableBalance - amount;
		account.setAccountBalance(newAmount);
		return accountRepo.save(account);
	};
	
	public void closeAccount(Long accountNumber) {
		accountRepo.findById(accountNumber).orElseThrow(() -> new RuntimeException ("Given account number is incorrect"));
		accountRepo.deleteById(accountNumber);
	};
}
