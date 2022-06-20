/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 


import java.util.ArrayList; // Importing ArrayList class
import java.util.InputMismatchException; // for InputMismatchException
import java.util.Scanner; //importing the scanner class


public class Bank {

    
    private String name;
    private ArrayList < Account > accounts;
    private int count;
    private int currentAccNum = 1;
    private int currentCardNum = 1;

    /**
     * no-arg constructor for the bank class
     */
    public Bank() {

    }


    public Bank(String name) {
        this.name = name; // set the name of the bank
        accounts = new ArrayList < Account > (); // create an array list of accounts
    }


    public void printTitle() {
        
        if (accounts.size() > 0) { // if there are accounts in the bank
            
            printStars(); // print the stars
            
            System.out.println(" ".repeat(34) + name.toUpperCase() + " BANK"); // print the name of the bank
            
            printHeaders(); // print the headers
        }

    }


    public void printHeaders() {

        printStars(); // print the stars

        
        boolean boolFound = false; // boolean to check if the account is found

        
        for (Account a: accounts) { // for each account in the bank

            
            if (a.creditCard != null) { // if the account has a credit card

                
                boolFound = true; // set the boolean to true
                 
                break; // break the loop
            }

        }

        
        if (boolFound == false) { // if the account has no credit card
            
            System.out.printf("%12s | %15s | %20s | %13s | %10s |\n", "Acc Number", "Name", "Email", "Phone Number", "Balance");

        } else {
            
            System.out.printf("%12s | %15s | %20s | %13s | %12s | %24s \n", "Acc Number", "Name", "Email", "Phone Number", "Balance", "Credit Card");
        }

        printStars(); // print the stars

    }


    public void readAccountDetails(Scanner sc) { // read the account details from the user

        
        int type = 0; // type of the account


        System.out.println("Let's get to know our customer.");
        Person accHolder = readPerson(sc); // read the person details

        do { // do this until the user enters a valid type
            do { // do this until the user enters a valid type
                try { // try this

                    
                    System.out.print("1. Chequing \n2. Savings \nEnter the type of account you want to create: ");
                    
                    type = sc.nextInt(); // read the type of the account
                    
                    break;
                    
                } catch (InputMismatchException inputMismatch) { // catch the exception
                    
                    sc.nextLine();
                    
                    System.out.println("Invalid menu option. Please try again...");
                }
                
            } while (true); // do this until the user enters a valid type

            
            switch (type) { // switch the type of the account

                
                case 1: // if the user wants to create a chequing account
                    
                    accounts.add(new Chequing(currentAccNum, accHolder)); // create a new chequing account
                    
                    break; 

                    
                case 2: // if the user wants to create a savings account
                    
                    accounts.add(new Savings(currentAccNum, accHolder)); // create a new savings account
                    break;

                    
                default: // if the user enters an invalid type
                    
                    System.out.println("Invalid account type... please re-enter");

            }

            
        } while (type != 1 && type != 2); // do this until the user enters a valid type

        
        currentAccNum++; // increment the account number

        
        printHeaders(); // print the headers
        accounts.get(count).printInfo(); // print the account details
        count++; // increment the count
    }


    
    public void ApplyForCC(Scanner sc) { // apply for a credit card
        
        int search = 0;
        int type = 0;
        Account account = null; // account to apply for the credit card

        
        if (count > 0) { // if there are accounts in the bank

            
            printHeaders(); // print the headers
            printAccountDetails(); // print the account details

            do { // do this until the user enters a valid account number
                           try { // try this

                    System.out.print("Enter account number: ");
                    search = sc.nextInt(); // read the account number

                    try {
                        
                        account = findAccount(search); // find the account
                        
                        break; 

                    } catch (AccountNotFoundException accountNotFound) { // catch the exception
                        
                        System.out.println(accountNotFound.getMessage()); // print the message
                    }



                } catch (InputMismatchException inputMismatch) { // catch the exception
                    sc.nextLine(); // clear the buffer
                    System.out.println("Invalid menu option. Try again...");
                }
            } while (true);

            do {    // do this until the user enters a valid type
                do { // do this until the user enters a valid type
                    try { // try this
                        
                        System.out.print("1. MasterCard \n2. Visa \n");
                        type = sc.nextInt(); // read the type of the credit card
                        break;

                    } catch (InputMismatchException inputMismatch) { // catch the exception

                        sc.nextLine(); // clear the buffer
                        System.out.println("Invalid selection. Please try again...");
                    }

                } while (true);

                switch (type) {

                    
                    case 1:
                        
                        account.creditCard = new MasterCard(currentCardNum++); // create a new master card
                        printHeaders(); // print the headers
                        account.printInfo(); // print the account details
                        break;

                        
                    case 2:
                         
                        account.creditCard = new Visa(currentCardNum++); // create a new visa card
                        printHeaders(); // print the headers
                        account.printInfo(); // print the account details
                        break; 

                        
                    default:
                        System.out.println("Invalid input. Please try again...");
                }

                
            } while (type != 1 && type != 2); // do this until the user enters a valid type
 
            
        } else {
            
            System.out.println("You need to create an account first");
        }

    }

  
    public void Transactions(Scanner sc) { // transactions

        
        int search = 0;
        int type = 0;
        int deposit = 0;
        int withdraw = 0;
        Account account = null;

        
        if (count > 0) { // if there are accounts in the bank

            printHeaders(); // print the headers
            printAccountDetails(); // print the account details

            
            do { // do this until the user enters a valid account number 

        try {   // try this
                    System.out.print("Enter account number: ");     
                    search = sc.nextInt();

                    try {
                        account = findAccount(search); // find the account
                        break;
                    } catch (AccountNotFoundException accountNotFound) { // catch the exception
                        System.out.println(accountNotFound.getMessage()); // print the message
                    }



                } catch (InputMismatchException inputMismatch) { // catch the exception
                    sc.nextLine();
                    System.out.println("Invalid menu option. Try again..."); // print the message
                }

            } while (true);

            do {

                do {
                    try {
                        System.out.print("1. Deposit \n2. Withdraw \n3. Balance \n"); // print the menu
                        type = sc.nextInt(); // read the type of the transaction
                        break;
                    } catch (InputMismatchException inputMismatch) {    
                        sc.nextLine(); // clear the buffer
                        System.out.println("Invalid menu option. Try again..."); // print the message
                    }
                } while (true); // do this until the user enters a valid type

                
                if (type == 1) { // if the user wants to deposit

                    
                    do {
                        try {
                            System.out.print("Enter the amount to deposit: "); // read the amount to deposit
                            deposit = sc.nextInt(); // read the amount to deposit


                            
                            try {
                                deposit(deposit, account); // deposit the amount
                                break;
                            } catch (TransactionAmountCannotBeNegative cantBeNegative) { // catch the exception
                                System.out.println(cantBeNegative.getMessage()); // print the message
                            }



                        } catch (InputMismatchException inputMismatch) { // catch the exception
                            sc.nextLine(); // clear the buffer
                            System.out.println("Invalid menu option. Try again..."); // print the message

                        }

                    } while (true); // do this until the user enters a valid amount

                    printHeaders(); // print the headers
                    account.printInfo(); // print the account details

                } else if (type == 2) { // if the user wants to withdraw

                    do {
                        try {
                            System.out.print("Enter the amount to withdraw: "); // read the amount to withdraw
                            withdraw = sc.nextInt(); // read the amount to withdraw

                            try {
                                withdraw(withdraw, account); // withdraw the amount
                                break;

                                
                            } catch (InfsufficientFundException insufficientFunds) { // catch the exception
                                System.out.println(insufficientFunds.getMessage()); // print the message

                                
                            } catch (TransactionAmountCannotBeNegative cantBeNegative) { // catch the exception
                                System.out.println(cantBeNegative.getMessage()); // print the message
                            }



                        } catch (InputMismatchException inputMismatch) { // catch the exception
                            sc.nextLine();
                            System.out.println("Invalid menu option. Try again...");   // print the message
                        }

                    } while (true); // do this until the user enters a valid amount

                    printHeaders(); // print the headers
                    account.printInfo(); // print the account details

                    
                } else if (type == 3) { // if the user wants to check the balance
                    
                    System.out.print("Acount balance: " + account.getBalance() + "\n"); // print the account balance

                    
                } else {
                    
                    System.out.println("Invalid menu option. Try again..."); // print the message
                }
                
            } while (type != 1 && type != 2 && type != 3); // do this until the user enters a valid type
            
            
        } else { // if there are no accounts in the bank
            
            System.out.println("You need to create an account first"); // print the message
        }

    }

 
    public void deposit(int num, Account acc) throws TransactionAmountCannotBeNegative { // deposit money
        Account account = acc; // account to deposit to
        
        if (num > 0) { // if the amount is greater than 0
            
            account.setBalance(account.getBalance() + num); // add the amount to the balance
            account.transactionFee(); // apply the transaction fee

            
        } else {
            
            throw new TransactionAmountCannotBeNegative("Transaction amount cannot be negative"); // throw the exception
        }

    }

   
    public void withdraw(int num, Account acc) throws InfsufficientFundException, TransactionAmountCannotBeNegative { // withdraw
        Account account = acc; // create a new account
        
        if (num > 0) { // if the amount is positive
            
            if (account.getBalance() > num) { // if the balance is greater than the amount to withdraw
                
                account.setBalance(account.getBalance() - num); // subtract the amount from the balance
                account.transactionFee(); // charge the transaction fee

                
            } else {
                
                throw new InfsufficientFundException("Insufficient funds in account"); // throw the exception
            }
            
        } else {
            
            throw new TransactionAmountCannotBeNegative("Transaction amount cannot be negative"); // throw the exception
        }


    }

  
    public Account findAccount(int num) throws AccountNotFoundException { // find account

        
        for (Account a: accounts) { // for each account in the bank
            
            if (a.getAccNum() != 0 && a.getAccNum() == num) { // if the account number is not 0 and the account number is equal to the number entered   
                
                return a;
            }
        }

        
        throw new AccountNotFoundException("Account number entered " + num + " is not found. Try again...");
    }



    /**
     * method prints a line of stars
     */
    public void printStars() { // print a line of stars

        
        boolean boolFound = false; // boolean to check if the account number is found

        for (Account a: accounts) { // for each account in the bank
            
            if (a.creditCard != null) { // if the account has a credit card
                
                boolFound = true; // if the account has a credit card, set the boolean to true
            }
        }

        
        if (boolFound == true) {
            System.out.println("*".repeat(120)); // print a line of stars

            
        } else { 
            System.out.println("*".repeat(93)); // print a line of stars
        }

    }

    /**
     * prints out the accounts info
     */
    public void printAccountDetails() { // print the account details
        
        if (count > 0) {
            
            for (Account a: accounts) { // for each account in the bank
                
                a.printInfo(); // print the account details
            }
            
        } else {
            
            System.out.println("No accounts to display"); 
        }
    }

    
    public Person readPerson(Scanner sc) { // read person from scanner

        
        String firstName, lastName, email;
        long phoneNumber = 0;

        
        System.out.print("Enter first Name: "); // ask for the first name
        firstName = sc.next();
        System.out.print("Enter last Name : "); // get the last name
        lastName = sc.next();
        System.out.print("Enter email Id: ");  // get the email id
        email = sc.next(); // email id

        do {
            
            try {
                System.out.print("Enter phone number: "); // phone number must be 10 digits
                phoneNumber = sc.nextLong(); // read the phone number
                break;
            } catch (InputMismatchException inputMismatch) {
                sc.nextLine(); // clear the buffer
                System.out.print("Invalid data type. Try again... \n"); // print error message
            }

        } while (true); // do this until the user enters a valid phone number

        
        return new Person(firstName, lastName, email, phoneNumber); // return a new person object

    }

}
