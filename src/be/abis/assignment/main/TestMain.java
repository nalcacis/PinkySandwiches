package be.abis.assignment.main;

import be.abis.assignment.main.exceptions.MaxSandwitchPerDayException;
import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;
import be.abis.assignment.main.model.*;
import be.abis.assignment.main.repository.MemoryArrayOrderRepository;
import be.abis.assignment.main.repository.OrderRepository;

import java.io.IOException;
import java.util.Scanner;

import static be.abis.assignment.main.enumeration.TypeOfBread.BLANC;
import static be.abis.assignment.main.enumeration.TypeOfBread.GRIS;
import static be.abis.assignment.main.enumeration.TypeOfSandwich.VIS;

public class TestMain {
    public static void main(String[] args) {
        OrderRepository or = new MemoryArrayOrderRepository();

        Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter you First Name :");
        String firstNameInput = scanInput.nextLine().toLowerCase();
        System.out.println("Enter you Last Name :");
        String lastNameInput = scanInput.nextLine().toLowerCase();
        System.out.println("Enter the category of the sandwich you want to order from : ");
        for (int i = 0;i<TypeOfSandwich.values().length;i++){
            System.out.println(TypeOfSandwich.values()[i]);
        }
        String sandwichCategory = scanInput.nextLine().toUpperCase();
        System.out.println("Enter the Name of Sandwich : ");
        String sandwichName = scanInput.nextLine().toLowerCase();
        System.out.println("Type of Bread (BRUIN/WIT) : ");
        String breadType = scanInput.nextLine().toUpperCase();
        System.out.println("Do you want salad? (Yes/No) : ");
        String salad = scanInput.nextLine().toLowerCase();
        boolean needSalad = (salad.equals("yes")?true:false);


        Accountant a1 = new Accountant(firstNameInput, lastNameInput);
        Sandwich s1 = new Sandwich(TypeOfSandwich.valueOf(sandwichCategory), TypeOfBread.valueOf(breadType), needSalad, sandwichName, 0);
        Order o1 = new Order(s1, a1);
        try {
            or.saveOrder(o1);
        } catch (MaxSandwitchPerDayException e) {
            System.out.println(e.getMessage());
        }

        //Person p1 = new Student("hello1", "kitty1", new Session("JAVA"));
        //Sandwich s2 = new Sandwich(BLANC, false, "salmon", 11);
        //read history and check todays order
        //Order o2 = new Order(s2,p1);
        //or.saveOrder(o2);

        //or.printOrders();

        //a1.orderSandwich("chicken", GRIS, true, 1000.0);
        //System.out.println(a1.getClass().getSimpleName());
        //System.out.println(instructor.getClass().getSimpleName());
        //or.printOrders();

    }
}
