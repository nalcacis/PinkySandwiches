package be.abis.assignment.main;

import be.abis.assignment.main.enumeration.*;
import be.abis.assignment.main.exceptions.SandwichNotFoundException;
import be.abis.assignment.main.model.Sandwich;
import be.abis.assignment.main.repository.MemoryArraySandwichRepository;
import be.abis.assignment.main.repository.SandwichRepository;

import java.io.IOException;
import java.util.Scanner;


public class UpdateMenu {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        System.out.println("Do you want to Add or remove the sandwich from the Menu : ");
        Boolean toAdd = (scanInput.nextLine().toLowerCase().equals("add") ? true : false);
        System.out.println("In which category of the sandwich you want to " + (toAdd ? "add " : "remove "));
        for (int i = 0; i < TypeOfSandwich.values().length; i++) {
            System.out.println(TypeOfSandwich.values()[i]);
        }
        String sandwichCategory = scanInput.nextLine().toUpperCase();
        System.out.println("Enter the Name of Sandwich : ");
        String sandwichName = scanInput.nextLine().toLowerCase();
        if (toAdd) {
            System.out.println("Enter the price of Sandwich : ");
            double sandwichPrice = Double.parseDouble(scanInput.nextLine());
            try {
                SandwichRepository sr = new MemoryArraySandwichRepository();
                Sandwich s2 = new Sandwich(TypeOfSandwich.valueOf(sandwichCategory), sandwichName, sandwichPrice);
                sr.addSandwichToMenu(s2);
                System.out.println("\n\n sandwich added successfully to the Menu !!!\n\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                SandwichRepository sr = new MemoryArraySandwichRepository();
                Sandwich s2 = new Sandwich(TypeOfSandwich.valueOf(sandwichCategory), sandwichName);
                try {
                    sr.deleteSandwichFromMenu(s2);
                    System.out.println("\n\n sandwich removed successfully from the Menu !!!\n\n");
                } catch (SandwichNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}