package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String firstName;
    private String lastName;
    private Session session;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Person(String firstName, String lastName, Session session) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.session = session;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void orderSandwich(TypeOfSandwich typeOfSandwich, String sandwichName, TypeOfBread typeOfBread, boolean vegetable) {
        Sandwich s1 = new Sandwich(typeOfSandwich, typeOfBread, vegetable, sandwichName);
        Order o1 = new Order(s1,this);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Person, " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'';
    }
}
