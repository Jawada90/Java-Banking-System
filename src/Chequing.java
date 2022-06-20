/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 
public class Chequing extends Account {  // extends Account class


    public Chequing(int accNum, Person person) {  // constructor
        
        super(accNum, person);  // calling super class constructor
    }

    /**
     * method updates the current balance of the account
     */
    @Override
    public void transactionFee() {  // method to update the balance of the account
        if (balance < 3000) {  // if balance is less than 3000
            
            balance = balance - Policies.chequingFee; // deduct the fee from the balance
        }
    }


}
