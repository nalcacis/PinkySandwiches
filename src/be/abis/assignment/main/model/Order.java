package be.abis.assignment.main.model;

public class Order {
    Person person;
    Sandwich sandwich;

    public Order(Sandwich sandwich, Person person) {
        this.sandwich = sandwich;
        this.person = person;
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
        return "Order Details: "  + person + " ordered " + sandwich;
    }
}
