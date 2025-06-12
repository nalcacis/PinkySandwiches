package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;
import be.abis.assignment.main.exceptions.MaxSandwitchPerDayException;
import be.abis.assignment.main.model.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryArrayOrderRepository implements OrderRepository {
    public List<Order> orders = new ArrayList<>();
    String fileLocation = "";
    String fileLocationWrite = "PinkySandwichOrderHistory.csv";
    //String fileLocationOrder = "/temp/javacourses/PinkySandwichOrderHistory.csv";

    public MemoryArrayOrderRepository() {
        //read the ordarOfThe file and fill it in orders list
        try {
            orders = Files.lines(Paths.get(fileLocationWrite))
                    .map(line -> this.parseOrder(line))
                    .filter(order -> order.getOrderDate().equals(LocalDate.now()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkSandwichOrderedToday() {

    }

    public void saveOrder(Order o) throws MaxSandwitchPerDayException{
        long count = orders.stream()
                .filter(order -> order.equals(o))
                .count();
        if (count < 2){
            orders.add(o);
            try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocationWrite), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
                bw.newLine();
                bw.write(OrderRepository.formatOrder(o));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }else {
            throw new MaxSandwitchPerDayException("Max sandwich per day");
        }
    }

    public List<Order> findAllOrders() {
        return orders;
    }

    public void printOrders() {
        for (Order o : orders) {
            System.out.println(o.getPerson().getFirstName() + " ordered " + o.getSandwich().getSandwichName());
        }
    }

    public Order parseOrder(String s) {
        String[] vals = s.split(";");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        String date = vals[0];
        String firstName = vals[1];
        String lastName = vals[2];
        String sandwichName = vals[3];
        Order order1 = new Order(LocalDate.parse(date, dtf), new Sandwich(TypeOfSandwich.FROMAGE, TypeOfBread.GRIS, true, sandwichName, 0.00), new Student(firstName, lastName, new Session("JAVA")));
        return order1;
    }
}
