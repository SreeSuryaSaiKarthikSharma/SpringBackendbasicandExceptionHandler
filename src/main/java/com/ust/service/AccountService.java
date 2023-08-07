package com.ust.service;

import java.util.List;

import com.ust.exception.AccountAlreadyExistsException;
import com.ust.exception.AccountNotFoundException;
import com.ust.exception.NoSuchAccountExistsException;
import com.ust.model.Account;

public interface AccountService {

	Account saveAccount(Account account) throws AccountAlreadyExistsException;
	
	List getAllAccounts() throws AccountNotFoundException;
	
	Account getAccountById(int id) throws AccountNotFoundException;
	
	Account updateAccount(Account account) throws NoSuchAccountExistsException;
	
}
