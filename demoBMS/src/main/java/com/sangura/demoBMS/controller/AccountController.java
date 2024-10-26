package com.sangura.demoBMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangura.demoBMS.entities.Account;
import com.sangura.demoBMS.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//create account
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account){
		
		Account newAccount = accountService.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
		
	}
	
	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable long accountNumber ){
		Account account = accountService.getAccountDetailsByAccountNumber(accountNumber);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(account);
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAllAccountsDetails(){
		List<Account> allAccounts = accountService.getAllAccountDetails();
		return ResponseEntity.ok(allAccounts);
	}
	
	@PutMapping("/Deposit/{accountNumber}")
	public ResponseEntity<Account> depositAmount(@PathVariable long accountNumber, @RequestBody double amount){
		if(amount == 0.0 || amount < 0.0) {
			return ResponseEntity.badRequest().body(null);
		}
		Account myAccount = accountService.getAccountDetailsByAccountNumber(accountNumber);
		if (myAccount == null) {
			ResponseEntity.notFound().build();
		}
		myAccount = accountService.depositAmount(accountNumber, amount);
		return ResponseEntity.ok(myAccount);
	}
	
	@PutMapping("/Withdraw/{accountNumber}")
	public ResponseEntity<Account> withdrawAmount(@PathVariable long accountNumber, @RequestBody double amount){
		if (amount == 0.0 || amount < 0.0) {
			return ResponseEntity.badRequest().body(null);
		}
		Account myAccount = accountService.getAccountDetailsByAccountNumber(accountNumber);
		if (myAccount == null) {
			return ResponseEntity.notFound().build();
		}
		myAccount = accountService.withdrawAmount(accountNumber, amount);
		return ResponseEntity.ok(myAccount);
	}
	@DeleteMapping("/{accountNumber}")
	public ResponseEntity<Void> deleteAccount(@PathVariable long accountNumber){
		Account myAccount = accountService.getAccountDetailsByAccountNumber(accountNumber);
		if (myAccount == null) {
			return ResponseEntity.notFound().build();
		}
		accountService.closeAccount(accountNumber);
		return ResponseEntity.noContent().build();
	}
	
}
