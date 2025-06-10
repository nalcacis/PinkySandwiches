package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Accountant extends Person {
    public Accountant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public double calculatePrice(){
        return 0.0;
    }
}
