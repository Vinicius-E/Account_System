package entities;

import java.util.Scanner;

public class Account {

	private Integer accountN;
	private Integer agencyNumber;
	private String agencyName;
	private String bankName;
	private Integer bankNumber;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	private Boolean active = false;

	protected static Scanner sc = new Scanner(System.in);

	public Account() {

	}

	public Account(Integer accountN, Integer agencyNumber, String agencyName, String bankName, Integer bankNumber,
			String holder, Double withdrawLimit, Boolean active) {
		this.accountN = accountN;
		this.agencyNumber = agencyNumber;
		this.agencyName = agencyName;
		this.bankName = bankName;
		this.bankNumber = bankNumber;
		this.holder = holder;
		this.withdrawLimit = withdrawLimit;
		this.balance = 0.0;
		this.active = active;
	}

	public Integer getNumber() {
		return accountN;
	}

	public void setNumber(Integer number) {
		this.accountN = number;
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

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(Integer agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Integer getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(Integer bankNumber) {
		this.bankNumber = bankNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account PK: ").append(accountN).append(" | Agency Number: ").append(agencyNumber)
				.append(" | Agency Name: ").append(agencyName).append("\rbankName: ").append(bankName)
				.append(" | Bank Number: ").append(bankNumber).append(" | Holder: ").append(holder)
				.append(" | Balance: $ ").append(balance).append("\rWithdraw Limit: $ ").append(withdrawLimit)
				.append(" |  Account Active: ").append(active);
		return builder.toString();
	}

	public Account openAcc() {
		System.out.println("<<<<< Enter Account Details >>>>>");
		// SEARCH FOR AUTOGENERATED KEY TO ACCOUNT NUMBER
		System.out.print("Account Number: ");
		Integer accountN = sc.nextInt();
		sc.nextLine();
		System.out.print("Agency Number: ");
		Integer agencyNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Agency Name: ");
		String agencyName = sc.nextLine();
		System.out.print("Bank Name: ");
		String bankName = sc.nextLine();
		System.out.print("Bank Number: ");
		Integer bankNumber = sc.nextInt();
		sc.nextLine();
		System.out.print("Holder: ");
		String holderU = sc.nextLine();
		System.out.print("Withdraw limit: $ ");
		Double withdrawLimitU = sc.nextDouble();
		setActive(true);
		Account account = new Account(accountN, agencyNumber, agencyName, bankName, bankNumber, holderU, withdrawLimitU,
				getActive());

		System.out.println("Account Opened!");

		return account;
	}

	public void closeAcc(Account accClose) {
		if (getActive() == false) {
			System.out.println("To Close and Account, You Must Already Have an Account");
		} else if (accClose.getBalance() != 0) {
			System.out.println("To Close an Account, Your Balance Must to Be $0.0");
			System.out.println("Your Current Balance is: $ " + getBalance());
			accClose = new Account();
		} else if (accClose.getBalance() == 0) {
			accountN = null;
			agencyName = null;
			agencyNumber = null;
			bankName = null;
			bankNumber = null;
			;
			holder = null;
			withdrawLimit = null;
			active = false;
			accClose = new Account(accountN, agencyNumber, agencyName, bankName, bankNumber, holder, withdrawLimit,
					getActive());
			System.out.println("Account Closed!");
		}
	}

	public void deposit() {
		if (getActive() == false) {
			System.out.println("First You Have to Open an Account!");
		} else {
			System.out.print("What Ammount to Deposit? $ ");
			Double value = sc.nextDouble();
			sc.nextLine();

			if (value <= 0) {
				System.out.println("The Deposit Value Must be Higher than Your Current Balance $ " + getBalance());
			} else {
				this.balance += value;
				System.out.println("New Account Balance is: $ " + String.format("%.2f", getBalance()));
			}
		}
	}

	public void withdraw() {
		if (getActive() == false) {
			System.out.println("First You Have to Open an Account!");
		} else {
			System.out.print("What Ammount to Withdraw? $ ");
			Double value = sc.nextDouble();
			sc.nextLine();

			if (value > getWithdrawLimit()) {
				System.out.println("You Can?t Withdraw More than Your Withdraw Limit!");
			} else if (getBalance() - value < 0) {
				System.out.println("You Can?t Withdraw More than Your Current Balance, Wich is: $ " + getBalance());
			} else if(value == 0) {
				System.out.println("The Withdraw Value Must be Higher than $0.0");
			}else if (value < getBalance()) {
				System.out.println("Insufficient Balance");
			} else {
				this.balance -= value;
				System.out.println("New Account Balance is: $ " + String.format("%.2f", getBalance()));
			}
		}
	}

	public void changeWithdrawLimit() {
		if (this.active == false) {
			System.out.println("First You Have to Open an Account!");
		} else {
			System.out.print("What Will be the new Withdraw Limit? $ ");
			Double newWL = sc.nextDouble();
			sc.nextLine();

			if (newWL == getWithdrawLimit()) {
				System.out.println("Your Current Withdraw Limit is the Same! Please Choose Another one...");
			} else if (newWL > 0) {
				setWithdrawLimit(newWL);
				System.out.println("The new Withdraw limit is: $ " + String.format("%.2f", newWL));
			}
		}
	}

	public void showInfo() {
		if (getActive() == false) {
			System.out.println("First You Have to Open an Account");
		} else {
			System.out.println(toString());
		}
	}
}
