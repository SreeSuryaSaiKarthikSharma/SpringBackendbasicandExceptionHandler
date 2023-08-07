package com.ust.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.exception.AccountAlreadyExistsException;
import com.ust.exception.AccountNotFoundException;
import com.ust.exception.NoSuchAccountExistsException;
import com.ust.model.Account;
import com.ust.repository.AccountRepository;

@Service
public class AccountServiceImplementation implements AccountService {
	
	private AccountRepository accountRepo;
	
	@Autowired
	public AccountServiceImplementation(AccountRepository accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public Account saveAccount(Account account) throws AccountAlreadyExistsException {
		
		if (accountRepo.existsById(account.getAccountId())) {
			throw new AccountAlreadyExistsException();
			
		}
		Account saveAccount = accountRepo.save(account);
		return saveAccount;
	}

	@Override
	public List getAllAccounts() throws AccountNotFoundException {
		return (List) accountRepo.findAll();
	}

	@Override
	public Account getAccountById(int id) throws AccountNotFoundException {
		Account account;
		if (accountRepo.findById(id).isEmpty()) {
			throw new AccountNotFoundException();
		}else {
			account = accountRepo.findById(id).get();
		}
		return account;
	}

	@Override
	public Account updateAccount(Account account) throws NoSuchAccountExistsException {
		Account existingAccount = accountRepo.findById(account.getAccountId())
				.orElse(null);
		
		if (existingAccount == null)  {
			throw new NoSuchAccountExistsException();
		} else {
			existingAccount.setaCreator(account.getaCreator());
			existingAccount.setaTitle(account.getaTitle());
			existingAccount.setYearOfCreation(account.getYearOfCreation());
			return accountRepo.save(existingAccount);
			
		}
	}

	

	

}
