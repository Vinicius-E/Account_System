package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Account defaultAcc = new Account();
		Account newAcc = new Account();
		Boolean c = true;

		while (c == true) {
			Account auxAccount = newAcc;
			switch (introSystem()) {
			case 1: {
				newAcc = defaultAcc.openAcc();
				break;
			}
			case 2: {
				auxAccount.closeAcc(newAcc);
				newAcc = auxAccount;
				break;
			}
			case 3: {
				System.out.println("Your Current Balance is: $ " + String.format("%.2f", newAcc.getBalance()));
				break;
			}
			case 4: {
				newAcc.withdraw();
				break;
			}
			case 5: {
				newAcc.deposit();
				break;
			}
			case 6: {
				newAcc.changeWithdrawLimit();
				break;
			}
			case 7: {
				newAcc.showInfo();
				break;
			}
			default:
				System.out.println("Opção escolhida inválida!");
				throw new IllegalArgumentException("Unexpected value: " + introSystem());
			}
			
			if (continueSystem(c) == false) {
				break;
			}
		}
		System.out.println("<<<<< ACCOUNT SYSTEM THANKS YOUR INTERACTION >>>>>");
		sc.close();
		System.out.println();
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
		System.out.print("<<< Digit a Number to Choose the Option: (1/2/3/4/5/6/7) ");
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
