package be.abis.assignment.main;

import be.abis.assignment.main.model.Accountant;
import be.abis.assignment.main.repository.MemoryArraySandwichRepository;
import be.abis.assignment.main.repository.SandwichRepository;

import java.io.IOException;

import static be.abis.assignment.main.enumeration.TypeOfBread.GRIS;

public class TestMain {
    public static void main(String[] args) {

        try {
            SandwichRepository sr = new MemoryArraySandwichRepository();
            Accountant a1 = new Accountant("hello" , "kitty");
            a1.orderSandwich("chicken", GRIS, true, 11);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
