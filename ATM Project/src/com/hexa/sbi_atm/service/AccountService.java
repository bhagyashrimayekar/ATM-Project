package com.hexa.sbi_atm.service;


import com.hexa.sbi_atm.exception.InvalidBalanceWithdraw;
import com.hexa.sbi_atm.exception.OutOfDepositAmountLimit;

public interface AccountService {
	public abstract void accountOpen();

	public abstract void balanceCheck();

	public abstract void withdraw() throws InvalidBalanceWithdraw;

	public abstract void deposit() throws OutOfDepositAmountLimit;

	public abstract void accountshow();

}
