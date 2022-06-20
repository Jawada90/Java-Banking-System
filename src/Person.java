/*
=========================================================================================================================
Object Oriented Programming			
		
Task: Java-Bank-System
Submission: Jawad Awada
=========================================================================================================================
*/ 
public class Person {

    //declaring variables 
    private String firstName, lastName, email;
    private long phoneNumber;



    public Person(String firstName, String lastName, String email, long number) { //constructor
        this.firstName = firstName; //assigning values to variables
        this.lastName = lastName; //assigning values to variables
        this.email = email; //assigning values to variables
        this.phoneNumber = number; //assigning values to variables
    }





    public void setName(String fName, String lName) { //setting name
        firstName = fName; //assigning values to variables
        lastName = lName; //assigning values to variables
    }


    public String getName() { //getting name
        return firstName + " " + lastName; //returning values
    }


    public void setEmail(String email) { //setting email
        this.email = email; //assigning values to variables
    }


    public String getEmail() { //getting email
        return email; //returning values
    }

    void setNumber(long number) { //setting number
        phoneNumber = number; //assigning values to variables
    }


    public long getNumber() { //getting number
        return phoneNumber; //returning values
    }
}
