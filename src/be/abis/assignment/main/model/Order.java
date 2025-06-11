package be.abis.assignment.main.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    LocalDate orderDate ;
    Person person;
    Sandwich sandwich;

    public Order(Sandwich sandwich, Person person) {
        this.orderDate = LocalDate.now();
        this.sandwich = sandwich;
        this.person = person;
    }

    public Order(LocalDate orderDate, Sandwich sandwich, Person person) {
        this.orderDate = orderDate;
        this.sandwich = sandwich;
        this.person = person;
    }


    public LocalDate getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public Sandwich getSandwich() {
        return sandwich;
    }
    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String toString() {
        return "Order Details: " + person + " ordered " + sandwich;
    }
}