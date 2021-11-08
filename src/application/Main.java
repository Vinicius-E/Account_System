package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.DomainException;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		try {
			Account defaultAcc = new Account();
			Account newAcc = new Account();
			Boolean c = true;

			while (c == true) {
				Account auxAccount = newAcc;
				switch (introSystem()) {
				case 1: {
					try {
						newAcc = defaultAcc.openAcc();
					} catch (DomainException e) {
						System.out.println("Open Account error: " + e.getMessage());
					}
					break;
				}
				case 2: {
					try {
						auxAccount.closeAcc(newAcc);
						newAcc = auxAccount;
					} catch (DomainException e) {
						System.out.println("Close Account error: " + e.getMessage());
					}
					break;
				}
				case 3: {
					System.out.println("Your Current Balance is: $ " + String.format("%.2f", newAcc.getBalance()));
					break;
				}
				case 4: {
					try {
						newAcc.withdraw();
					} catch (DomainException e) {
						System.out.println("Withdraw Account error: " + e.getMessage());
					}
					break;
				}
				case 5: {
					try {
						newAcc.deposit();
					} catch (DomainException e) {
						System.out.println("Deposit Account error: " + e.getMessage());
					}
					break;
				}
				case 6: {
					try {
						newAcc.changeWithdrawLimit();
					} catch (DomainException e) {
						System.out.println("Change the Withdraw Limit Account error: " + e.getMessage());
					}
					break;
				}
				case 7: {
					try {
						newAcc.showInfo();
					} catch (DomainException e) {
						System.out.println("Show Info of Account error: " + e.getMessage());
					} 
					break;
				}
				default:
					System.out.println("Option Choosen is Invalid!");
					throw new IllegalArgumentException("Unexpected value: " + introSystem());
				}

				if (continueSystem(c) == false) {
					break;
				}
			}
			System.out.println("<<<<< ACCOUNT SYSTEM THANKS YOUR INTERACTION >>>>>");

		} catch (Exception e) {
			System.out.println("Unexpected Error in Default Try: " + e.getMessage());
		} 
		finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public static Scanner sc = new Scanner(System.in);

	public static Integer introSystem() {
		System.out.println("<<<<< ACCOUNT SYSTEM >>>>>");
		System.out.println("<<< Available Options >>>");
		System.out.println("<< (1) - Open Account >>");
		System.out.println("<< (2) - Close Account >>");
		System.out.println("<< (3) - Get Balance >>");
		System.out.println("<< (4) - Withdraw >>");
		System.out.println("<< (5) - Deposit >>");
		System.out.println("<< (6) - Change Withdraw Limit >>");
		System.out.println("<< (7) - Show Info >>");
		System.out.print("Digit a Number to Choose the Option: (1/2/3/4/5/6/7) ");
		Integer opt = sc.nextInt();
		sc.nextLine();

		return opt;
	}

	private static Boolean continueSystem(Boolean cont) {
		System.out.print("Would Your Like to Do More Some Option on the System? (Y-yes/N-no) ");
		String s1 = sc.nextLine();
		String s1Upper = s1.toUpperCase();
		Character resposta = s1Upper.charAt(0);
		if (resposta == 'N') {
			cont = false;
		}

		return cont;
	}
}
