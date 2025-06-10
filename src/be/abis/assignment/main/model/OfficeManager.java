package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;

public class OfficeManager extends Person{
    public OfficeManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void orderSandwich(String sandwichName, TypeOfBread typeOfBread, boolean vegetable, String price ){
        Sandwich s1 = new Sandwich(typeOfBread,  vegetable, sandwichName, price);
        Order o1 = new Order(s1,this);
        System.out.println("sandwich: " + s1.getSandwichName() + " " );
        System.out.println("order: " + o1.getSandwich() + " " + o1.getPerson());
    }

    public void addSandwich(){}
    public void deleteSandwich(){}
    public void addSession(){}
    public void deleteSession(){}
    public void printOutput(){}
}
