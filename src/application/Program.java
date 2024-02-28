package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Account account = new Account();
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.next();
		String holder = sc.nextLine();		
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw Limit: ");
		double withdrawLimit = sc.nextDouble();
		System.out.println();
		account = new Account(number, holder, balance, withdrawLimit);
		System.out.println(account.toString());
		
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();		
		
		try {
			account.withdraw(amount);
			System.out.println(account.toString());
		} catch (DomainException e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		System.out.println(account.toString());
		
		sc.close();
	}
}
