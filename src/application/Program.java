package application;

import java.util.Locale;
import java.util.Scanner;

import models.entities.Account;
import models.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: : ");
			double limit = sc.nextDouble();
			Account acc = new Account(number, name, balance, limit);

			System.out.print("\nEnter amount for withdraw: ");
			acc.withdraw(sc.nextDouble());
			System.out.printf("New balance: %.2f", acc.getBalance());
		} catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}
