package be.abis.assignment.main;

import be.abis.assignment.main.repository.MemoryArrayOrderRepository;
import be.abis.assignment.main.repository.OrderRepository;

import java.io.IOException;

public class OrderOfTheDay {
    public static void main(String[] args) {
        OrderRepository or = new MemoryArrayOrderRepository();
        try {
            ((MemoryArrayOrderRepository) or).checkSandwichOrderedToday();
            System.out.println("\n\nTodays order is generated, please check the file\n\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
