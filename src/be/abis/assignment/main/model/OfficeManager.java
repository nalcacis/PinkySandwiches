package be.abis.assignment.main.model;

public class OfficeManager extends Person{
    public OfficeManager(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public void orderSandwich(String sandwichName, Enum TypeOfBread, boolean needVegetable){}

    public void addSandwich(){}
    public void deleteSandwich(){}
    public void addSession(){}
    public void deleteSession(){}
    public void printOutput(){}
}
