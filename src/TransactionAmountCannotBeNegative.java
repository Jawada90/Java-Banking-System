/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 


public class TransactionAmountCannotBeNegative extends Exception { // Exception class for negative transaction amount

	public TransactionAmountCannotBeNegative(String message) { // constructor
		super(message); // call super class constructor
	}
}
