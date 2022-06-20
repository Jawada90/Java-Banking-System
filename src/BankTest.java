/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // create a scanner object

        System.out.print("Enter name of the Bank: "); // ask user to enter name of the bank

        String name = sc.nextLine(); // store the name of the bank in a string variable

        Bank bank = new Bank(name); // create a bank object with the name entered by the user

        int option = 0; // create a variable to store the option selected by the user

        do { // loop until the user selects option 5

            try { // try block to catch the exception if the user enters an invalid option

                System.out.print(
                    "1. Create Account \n2. Transactions \n3. Print all Accounts \n4. Apply for Credit Card \n5. Exit \nEnter your option: ");
                option = sc.nextInt(); // store the option selected by the user in the variable option

            } catch (InputMismatchException inputMismatch) { // catch the exception if the user enters an invalid option
                sc.nextLine(); // clear the buffer
            }

            switch (option) {

                case 1: // if the user selects option 1
                    bank.readAccountDetails(sc); // call the method to read the account details from the user
                    break;

                case 2: // if the user selects option 2
                    bank.Transactions(sc); // call the method to perform the transactions
                    break;

                case 3: // if the user selects option 3
                    bank.printTitle(); // call the method to print the title of the accounts
                    bank.printAccountDetails(); // call the method to print the account details
                    break;

                case 4:
                    bank.ApplyForCC(sc); // call the method to apply for credit card
                    break;

                case 5: // if the user selects option 5
                    System.out.println("Goodbye... Have a nice day \nProgram developed by Jawad Awada."); // print the
                    // message
                    System.exit(0); // exit the program
                    break;

                default:
                    System.out.println("Invalid menu option. Please try again..."); // print the message if the user
                    // enters an invalid option
            }

        } while (option != 5); // loop until the user selects option 5
        sc.close(); // close the scanner object
    }

}
