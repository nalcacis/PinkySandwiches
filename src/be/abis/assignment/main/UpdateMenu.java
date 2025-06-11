package be.abis.assignment.main;

import be.abis.assignment.main.model.Sandwich;
import be.abis.assignment.main.repository.MemoryArraySandwichRepository;
import be.abis.assignment.main.repository.SandwichRepository;

import java.io.IOException;

import static be.abis.assignment.main.enumeration.TypeOfBread.BLANC;

public class UpdateMenu {
    public static void main(String[] args) {
        try {
            SandwichRepository sr = new MemoryArraySandwichRepository();
            //Sandwich s2 = new Sandwich(BLANC, false, "salmon", 13);
            //sr.addSandwichToMenu(s2);
            //Sandwich s1 = new Sandwich(BLANC, false, "salmon", 12);
            //sr.addSandwichToMenu(s1);
            //((MemoryArraySandwichRepository) sr).printMenu();
            //sr.deleteSandwichFromMenu(s1);
            ((MemoryArraySandwichRepository) sr).printMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
