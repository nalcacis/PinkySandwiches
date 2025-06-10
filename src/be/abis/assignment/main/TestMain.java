package be.abis.assignment.main;

import be.abis.assignment.main.model.Accountant;
import be.abis.assignment.main.model.Instructor;
import be.abis.assignment.main.model.Session;
import be.abis.assignment.main.repository.MemoryArraySandwichRepository;
import be.abis.assignment.main.repository.SandwichRepository;

import java.io.IOException;

import static be.abis.assignment.main.enumeration.TypeOfBread.GRIS;
import static be.abis.assignment.main.enumeration.TypeOfBread.WIT;

public class TestMain {
    public static void main(String[] args) {
        Accountant a1 = new Accountant("hello" , "kitty");
        a1.orderSandwich("chicken", GRIS, true, 1000.0);
        //System.out.println(a1.getClass().getSimpleName());

        Session session = new Session("JAVA");
        Instructor instructor = new Instructor("Sandy", "Scchillebeeckx", session);

        instructor.orderSandwich("club" , WIT, false , 200);
        //System.out.println(instructor.getClass().getSimpleName());

        try {
            SandwichRepository sr = new MemoryArraySandwichRepository();
            Accountant a1 = new Accountant("hello" , "kitty");
            a1.orderSandwich("chicken", GRIS, true, 11);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
