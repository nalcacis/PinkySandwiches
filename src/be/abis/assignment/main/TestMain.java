package be.abis.assignment.main;

import be.abis.assignment.main.exceptions.MaxSandwitchPerDayException;
import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;
import be.abis.assignment.main.model.*;
import be.abis.assignment.main.repository.MemoryArrayOrderRepository;
import be.abis.assignment.main.repository.OrderRepository;

import java.io.IOException;

import static be.abis.assignment.main.enumeration.TypeOfBread.BLANC;
import static be.abis.assignment.main.enumeration.TypeOfBread.GRIS;

public class TestMain {
    public static void main(String[] args) {
        OrderRepository or = new MemoryArrayOrderRepository();
        Accountant a1 = new Accountant("hello", "kitty");
        //Sandwich s1 = new Sandwich(GRIS, true, "Chicken", 10);
        //Order o1 = new Order(s1,a1);
        //or.saveOrder(o1);

        //Person p1 = new Student("hello1", "kitty1", new Session("JAVA"));
        //Sandwich s2 = new Sandwich(BLANC, false, "salmon", 11);
        //read history and check todays order
        //Order o2 = new Order(s2,p1);
        //or.saveOrder(o2);

        //or.printOrders();

        //a1.orderSandwich("chicken", GRIS, true, 1000.0);
        //System.out.println(a1.getClass().getSimpleName());
        //System.out.println(instructor.getClass().getSimpleName());

        or.printOrders();

    }
}
