package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	protected Integer number;
	protected String holder;
	protected Double balance;
	protected Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(Double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		this.balance -= amount;
		this.withdrawLimit -= amount;
	}
	
	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("ERROR: The amount exceds withdraw limit.");
		}
		if (amount > getBalance()) {
			throw new DomainException("ERROR: Insuficient balance.");
		}
	}
	
	@Override
	public String toString() {
		return "Account data - Number: " + getNumber()
		       + ", Holder: " + getHolder()
		       + ", Balance: R$ " + getBalance()
		       + ", Withdraw Limit: R$ " + getWithdrawLimit();
	}
	
}
