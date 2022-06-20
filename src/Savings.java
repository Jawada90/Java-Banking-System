/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 

public class Savings extends Account {


	
	public Savings(int accNum, Person person) { // constructor
		super(accNum, person); // calling the super class constructor
	}
	
	@Override
	public void transactionFee() { // method to calculate the transaction fee
		balance = balance - Policies.savingsFee;  // deducting the fee from the balance
	}
}
