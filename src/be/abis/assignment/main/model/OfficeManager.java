package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class OfficeManager extends Person{
    public OfficeManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable, double price ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, price);
        Order o1 = new Order(s1,this);
        System.out.println(" " + s1);
        System.out.println(" " + o1);
    }

    public void addSandwich(String sandwichName, TypeOfBread typeOfBread, String price){

    }
    public void deleteSandwich(){}
    public void addSession(){}
    public void deleteSession(){}
    public void printOutput(){}
}
