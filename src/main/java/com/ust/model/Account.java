package com.ust.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountId;
	
	private String aTitle;
	
	private String aCreator;
	
	private int yearOfCreation;

	public Account(int accountId, String aTitle, String aCreator, int yearOfCreation) {
		super();
		this.accountId = accountId;
		this.aTitle = aTitle;
		this.aCreator = aCreator;
		this.yearOfCreation = yearOfCreation;
	}

	public Account() {
		super();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getaTitle() {
		return aTitle;
	}

	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}

	public String getaCreator() {
		return aCreator;
	}

	public void setaCreator(String aCreator) {
		this.aCreator = aCreator;
	}

	public int getYearOfCreation() {
		return yearOfCreation;
	}

	public void setYearOfCreation(int yearOfCreation) {
		this.yearOfCreation = yearOfCreation;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", aTitle=" + aTitle + ", aCreator=" + aCreator + ", yearOfCreation="
				+ yearOfCreation + "]";
	}
	
	
}
