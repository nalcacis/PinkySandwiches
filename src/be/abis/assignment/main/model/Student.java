package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class Student extends Person{

    public Student(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable, double price ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, price);
        Order o1 = new Order(s1,this);
        System.out.println(" " + s1);
        System.out.println(" " + o1);
    }
}
