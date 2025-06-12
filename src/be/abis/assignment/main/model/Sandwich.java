package be.abis.assignment.main.model;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;

import java.util.Objects;

public class Sandwich {
    public TypeOfSandwich typeOfSandwich;
    public TypeOfBread typeOfBread;
    public boolean vegetables;
    public String sandwichName;
    public double sandwichPrice;

    public Sandwich(TypeOfSandwich typeOfSandwich, String sandwichName, double sandwichPrice) {
        this.typeOfSandwich = typeOfSandwich;
        this.sandwichName = sandwichName;
        this.sandwichPrice = sandwichPrice;
    }

    public Sandwich(TypeOfSandwich typeOfSandwich, String sandwichName) {
        this.typeOfSandwich = typeOfSandwich;
        this.sandwichName = sandwichName;
    }

    public Sandwich(TypeOfSandwich typeOfSandwich, TypeOfBread typeOfBread, boolean vegetables, String sandwichName) {
        this.typeOfSandwich = typeOfSandwich;
        this.typeOfBread = typeOfBread;
        this.vegetables = vegetables;
        this.sandwichName = sandwichName;
    }


    public TypeOfSandwich getTypeOfSandwich() {
        return typeOfSandwich;
    }

    public void setTypeOfSandwich(TypeOfSandwich typeOfSandwich) {
        this.typeOfSandwich = typeOfSandwich;
    }

    public TypeOfBread getTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(TypeOfBread typeOfBread) {
        this.typeOfBread = typeOfBread;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public String getSandwichName() {
        return sandwichName;
    }

    public void setSandwichName(String sandwichName) {
        this.sandwichName = sandwichName;
    }

    public double getSandwichPrice() {
        return sandwichPrice;
    }

    public void setSandwichPrice(double sandwichPrice) {
        this.sandwichPrice = sandwichPrice;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "typeOfSandwich=" + typeOfSandwich +
                ", typeOfBread=" + typeOfBread +
                ", vegetables=" + vegetables +
                ", sandwichName='" + sandwichName + '\'' +
                ", sandwichPrice=" + sandwichPrice +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        //if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sandwich sandwich = (Sandwich) o;
        return Double.compare(sandwichPrice, sandwich.sandwichPrice) == 0 && Objects.equals(sandwichName, sandwich.sandwichName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfBread, vegetables, sandwichName, sandwichPrice);
    }
}