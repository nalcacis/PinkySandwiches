package be.abis.assignment.main;

import be.abis.assignment.main.repository.MemoryArraySandwichRepository;
import be.abis.assignment.main.repository.SandwichRepository;

import java.io.IOException;

public class PrintMenu {
    public static void main(String[] args) throws IOException {
        SandwichRepository sr = new MemoryArraySandwichRepository();
        sr.printMenu();
    }
}