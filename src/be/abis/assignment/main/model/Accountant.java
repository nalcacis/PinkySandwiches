package be.abis.assignment.main.model;

public class Accountant extends Person {
    public Accountant(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void orderSandwich(String sandwichName, Enum TypeOfBread, boolean needVegetable){
        Sandwich s1 = new Sandwich();
        Order o1 = new Order(s1,this);
    }

    public double calculatePrice(){
        return 0.0;
    }
}
