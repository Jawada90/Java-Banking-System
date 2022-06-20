/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 

import java.text.DecimalFormat;


public class MasterCard implements CreditCard { // implements CreditCard interface

    //declaring variables
    private static final String CARD_PREFIX = "5522123456781";
    private DecimalFormat df = new DecimalFormat("000");
    private String currentNum;


    public MasterCard(int num) { // constructor
        currentNum = df.format(num); // formats the number
    }


    @Override
    public String getCardNumber() { // returns the card number
        String mc = CARD_PREFIX + currentNum + "(MC)"; // concatenates the card number
        return mc; // returns the card number
    }
}
