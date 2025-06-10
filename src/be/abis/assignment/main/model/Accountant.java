package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Accountant extends Person {
    public Accountant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable, String price ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, price);
        Order o1 = new Order(s1,this);
        System.out.println(" " + s1);
        System.out.println(" " + o1);
    }

    public double calculatePrice(){
        return 0.0;
    }
}
