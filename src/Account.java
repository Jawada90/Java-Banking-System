/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 


public abstract class Account { // abstract class

    
    private int accountNumber;
    private Person accHolder;
    protected CreditCard creditCard;
    

    /** The current balance of the account */
    protected double balance = 0.0;



    public Account(int accNum, Person person) { // constructor

        
        accountNumber = accNum; // set account number
        
        accHolder = person; // set account holder

    }


    public abstract void transactionFee(); // abstract method



    public void printInfo() {
        
        if (creditCard == null) { // if credit card is null
            
            System.out.printf("%12d | %15s | %20s | %13d | %10.2f | \n", accountNumber, accHolder.getName(), accHolder.getEmail(), accHolder.getNumber(), balance); // print info
            
        } else {
            
            System.out.printf("%12d | %15s | %20s | %13d | %12.2f | %24s \n", accountNumber, accHolder.getName(), accHolder.getEmail(), accHolder.getNumber(), balance, creditCard.getCardNumber()); // print info
        }

    }


    public int getAccNum() { // get account number
        return accountNumber; // return account number
    }

    void setAccNum(int accNum) { // set account number
        accountNumber = accNum; // set account number
    }


    public double getBalance() { // get balance
        return balance; // return balance
    }


    public void setBalance(double balance) { // set balance
        this.balance = balance; // set balance
    }
}
