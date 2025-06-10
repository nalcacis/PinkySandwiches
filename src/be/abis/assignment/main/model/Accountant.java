package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Accountant extends Person {
    public Accountant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, "1000");
        Order o1 = new Order(s1,this);
    }

    public double calculatePrice(){
        return 0.0;
    }
}
