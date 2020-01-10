package com.synechron.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.entities.Account;
import com.synechron.entities.Statement;
import com.synechron.exceptions.AccountNotFoundException;
import com.synechron.exceptions.InsufficientBalanceException;
import com.synechron.repositories.AccountRepository;
import com.synechron.repositories.StatementRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private StatementRepository statementRepository;

	public void deposit(int accountNumber, int amount, String type) {
		Account account = getAccount(accountNumber, amount);
		account.setBalance(account.getBalance() + amount);
		accountRepository.save(account);
		createStatement(accountNumber, amount, type);
	}

	public void withdraw(int accountNumber, int amount, String type) {
		Account account = getAccount(accountNumber, amount);
		if(account.getBalance() < amount) {
			throw new InsufficientBalanceException(amount + "");
		}
		account.setBalance(account.getBalance() - amount);
		accountRepository.save(account);
		createStatement(accountNumber, amount, type);
		
	}
	
	private void createStatement(int accountNumber, int amount, String type) {
		Statement statement = new Statement();
		statement.setAccountNumber(accountNumber);
		statement.setAmount(amount);
		statement.setType(type);
		statementRepository.save(statement);
	}

	private Account getAccount(int accountNumber, int amount) {
		Account account = accountRepository
				.findById(accountNumber)
				.orElseThrow(() -> new AccountNotFoundException(accountNumber+""));
		
		return account;
	}



}
