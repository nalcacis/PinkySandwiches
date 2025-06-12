package be.abis.assignment.main;

import be.abis.assignment.main.repository.MemoryArrayOrderRepository;
import be.abis.assignment.main.repository.OrderRepository;

public class Statistics {
    public static void main(String[] args) {
        OrderRepository or = new MemoryArrayOrderRepository();
        or.statistics();
    }
}