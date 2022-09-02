package com.hexa.sbi_atm.controller;

import java.util.Scanner;


import com.hexa.sbi_atm.exception.InvalidBalanceWithdraw;
import com.hexa.sbi_atm.exception.OutOfDepositAmountLimit;
import com.hexa.sbi_atm.serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args) throws InvalidBalanceWithdraw {
		AccountServiceImpl b = new AccountServiceImpl();

		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("1) Account open");
			System.out.println("2) Balance check");
			System.out.println("3) withdrawal");
			System.out.println("4) deposit");
			System.out.println("5) Account Details");
			System.out.println();
			System.out.println("enter choice");
			int choice = s.nextInt();

			switch (choice) {

			case 1:
				b.accountOpen();
				break;
			case 2:
				b.balanceCheck();
				break;
			case 3:
				try {
					b.withdraw();
				} catch (InvalidBalanceWithdraw t) {
					System.out.println(t.getMessage());

				}

				break;
			case 4:
				try {
					b.deposit();
				} catch (OutOfDepositAmountLimit e5) {
					System.out.println(e5.getMessage());
				}
				break;
			case 5:
				b.accountshow();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.out.println("please enter correct choice");

			}
		}

	}
}