package practice;

import java.util.*;
class BankAccount {
	private String AccountHolderName;
	private String AccountNumber;
	private double Balance;
	
	public BankAccount(String AccountHolderName, String AccountNumber) {
		this.AccountHolderName=AccountHolderName;
		this.AccountNumber=AccountNumber;
		this.Balance=0.0;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void deposit(double amount) {
		if(amount>0) {
			Balance +=amount;
			System.out.println("deposit is successful");
		}else {
			System.out.println("deposit unsuccessful");
		}
	}
	public void withdrawl(double amount) {
		if(amount>0 && amount<=Balance) {
			Balance -=amount;
			System.out.println("withdrawl is successful");
		}else {
			System.out.println("withdrawl is unsuccessful");
		}
	}
}
public class BMS{
	public static HashMap<String,BankAccount> Storage =new HashMap<>();
	public static void createAccount(String AccountHolderName, String AccountNumber) {
		if(!Storage.containsKey(AccountNumber)) {
			BankAccount Ba = new BankAccount(AccountHolderName,AccountNumber);
			Storage.put(AccountNumber,Ba);
			System.out.println("ACCOUNT CREATED SUCCESSFULLY");
		}else {
			System.out.println("ACCOUNT NOT CREATED");
		}
		
	}
	public static  BankAccount findAccount(String AccountNumber) {
		return Storage.get(AccountNumber);
	}
	
    public static void main(String [] args) { 
    	Scanner in = new Scanner(System.in);
    	int option =0;
    	do {
    		System.out.println("WLECOME TO BANK");
    		System.out.println("PRESS 1 TO CREATE AN ACCOUNT");
    		System.out.println("PRESS 2 TO CHECK THE BALANCE");
    		System.out.println("PRESS 3 TO DEPOST AN AMOUNT");
    		System.out.println("PRESS 4 TO WITHDRAW AN AMOUNT");
    		System.out.println("PRESS 5 TO EXIT");
    		System.out.print("ENTER YOUR OPTION : ");
    		option = in.nextInt(); 
    		switch(option) {
    			case 1 :
    				System.out.print("ENTER YOUR NAME : ");
    				String AccountHolderName=in.next();
    				System.out.print("ENTER AN ACCOUNT NUMBER : ");
    				String AccountNumber=in.next();
    				createAccount(AccountHolderName,AccountNumber);
    				break;
    			
    			case 2 :
    				System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
    				AccountNumber=in.next();
    				BankAccount Details=findAccount(AccountNumber);
    				if(Details!=null) {
    					System.out.println("Account holder name is"+Details.getAccountHolderName());
    					System.out.println("Account NUMBER is"+Details.getAccountNumber());    					System.out.println("Account holder name is"+Details.getAccountHolderName());
    					System.out.println("Account BALANCE is"+Details.getBalance());
    				}else {
    					System.out.println("ACCOUNT NOT FOUND");
    				}
    				break;
    			
    			case 3 :
    				System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
    				AccountNumber=in.next();
    				Details=findAccount(AccountNumber);
    				if(Details!=null) {
    					System.out.print("PLEASE ENTER THE AMOUNT YOU WANT TO DEPOSIT : ");
    					double amount = in.nextDouble();
    					Details.deposit(amount);
    				}else {
    					System.out.println("ACCOUNT NOT FOUND");
    				}
    				break;
    				
    			case 4 :
    				System.out.print("ENTER YOUR ACCOUNT NUMBER : ");
    				AccountNumber=in.next();
    				Details=findAccount(AccountNumber);
    				if(Details!=null) {
    					System.out.print("PLEASE ENTER THE AMOUNT YOU WANT TO WITHDRAWL : ");
    					double amount = in.nextDouble();
    					Details.withdrawl(amount);
    				}else {
    					System.out.println("ACCOUNT NOT FOUND");
    				}
    				break;
    				
    			case 5 :
    				System.out.println("THANK YOU ");
    				break;
    				
    			default :
    				System.out.println("INVALID CHOICE PLEASE ENTER VAILD NUMBER");
    				
    		}
    		
    	}while(option !=5);
    		
    }
	
	
}
	

	

