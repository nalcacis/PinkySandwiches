package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Student extends Person{

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable, String price ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, price);
        Order o1 = new Order(s1,this);
        System.out.println("sandwich: " + s1.getSandwichName() + " " );
        System.out.println("order: " + o1.getSandwich() + " " + o1.getPerson());
    }
}
