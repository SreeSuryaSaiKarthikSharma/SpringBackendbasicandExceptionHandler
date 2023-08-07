package com.ust.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.exception.AccountAlreadyExistsException;
import com.ust.exception.AccountNotFoundException;
import com.ust.exception.NoSuchAccountExistsException;
import com.ust.model.Account;
import com.ust.service.AccountService;

@RestController
@RequestMapping("/ac/exh")
public class AccountController {
	
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
	@PostMapping("/saveaccount")
	public ResponseEntity saveAccount(@RequestBody Account account) throws AccountAlreadyExistsException {
		Account savedAccount = accountService.saveAccount(account);
		return new ResponseEntity(savedAccount,HttpStatus.CREATED);
	}
	
	@GetMapping("/getaccounts")
	public ResponseEntity<List> getAllAccounts() throws AccountNotFoundException {
		return new ResponseEntity<List>((List) accountService.getAllAccounts(),HttpStatus.OK);
	}
	
	@GetMapping("getaccount/{id}")
	public ResponseEntity getAccountById(@PathVariable("id") int id) throws AccountNotFoundException {
		return new ResponseEntity(accountService.getAccountById(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateaccount")
	public ResponseEntity updateAccount(@RequestBody Account account) throws NoSuchAccountExistsException {
		return new ResponseEntity(accountService.updateAccount(account),HttpStatus.OK);
	}
	
	@ExceptionHandler(value = AccountAlreadyExistsException.class)
	public ResponseEntity handleAccountAlreadyExistsException(AccountAlreadyExistsException aa) {
		return new ResponseEntity("Account already exists!",HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ResponseEntity handleAccountNotFoundException(AccountNotFoundException af) {
		return new ResponseEntity("Account not found!",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoSuchAccountExistsException.class)
	public ResponseEntity handleNoSuchAccountExistsException(NoSuchAccountExistsException nsa) {
		return new ResponseEntity("No such account exists!",HttpStatus.NOT_FOUND);
	}
}
