package be.abis.assignment.main;

import be.abis.assignment.main.model.Accountant;

import static be.abis.assignment.main.enumeration.TypeOfBread.GRIS;

public class TestMain {
    public static void main(String[] args) {
        Accountant a1 = new Accountant("hello" , "kitty");
        a1.orderSandwich("chicken", GRIS, true, "1000");
    }
}
