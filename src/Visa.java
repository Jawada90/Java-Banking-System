/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 


import java.text.DecimalFormat;


public class Visa implements CreditCard { // implements CreditCard interface

    private static final String CARD_PREFIX = "4422123456781"; // constant variable
    DecimalFormat df = new DecimalFormat("000"); // decimal format
    private String currentNum;


    public Visa(int num) { // constructor
        currentNum = df.format(num); // format the number
    }

    @Override
    public String getCardNumber() { // get card number
        String v = CARD_PREFIX + currentNum + "(V)"; // concatenate the card number
        return v; // return the card number
    }

}
