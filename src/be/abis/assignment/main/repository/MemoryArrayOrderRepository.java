package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;
import be.abis.assignment.main.exceptions.MaxSandwitchPerDayException;
import be.abis.assignment.main.model.*;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MemoryArrayOrderRepository implements OrderRepository {
    public List<Order> orders = new ArrayList<>();
    String fileLocation = "";
    String fileLocationWrite = "PinkySandwichOrderHistory.csv";
    String writeToday = "todaysOrder.txt";
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

    public void checkSandwichOrderedToday() throws IOException {
        List<Order> todaysOrders = Files.lines(Paths.get(fileLocationWrite))
                .map(line -> this.parseOrder(line))
                .filter(order -> order.getOrderDate().equals(LocalDate.now()))
                .collect(Collectors.toList());

        try (BufferedWriter bw2 = Files.newBufferedWriter(Paths.get(writeToday), StandardCharsets.UTF_8)) {
            for (Order o : todaysOrders) {
                bw2.newLine();
                bw2.write(OrderRepository.formatTodaysOrder(o));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

public void saveOrder(Order o) throws MaxSandwitchPerDayException {
    long count = orders.stream()
            .filter(order -> order.equals(o))
            //not a good idea to implement .equals here, its a misuse of equals
            //instead use filters
            .count();
    if (count < 2) {
        orders.add(o);
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocationWrite), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write(OrderRepository.formatOrder(o));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } else {
        throw new MaxSandwitchPerDayException("\n\n You cannot order more than 2 sandwiches per day");
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
    public void statistics() {
        try {
            Map<String, Long> sandwichCount = Files.lines(Paths.get(fileLocationWrite))
                    .map(this::parseOrder)
                    .collect(Collectors.groupingBy(
                            order -> String.valueOf(order.getSandwich().getSandwichName()),
                            Collectors.counting()));


            sandwichCount.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                    .forEach(entry ->
                            System.out.println(entry.getKey() + " was ordered " + entry.getValue() + " times.")
                    );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Order parseOrder(String s) {
        String[] vals = s.split(";");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        String date = vals[0];
        String firstName = vals[1];
        String lastName = vals[2];
        String typeOfBread = vals[3];
        boolean vegetable = Boolean.parseBoolean(vals[4]);
        String sandwichName = vals[5];
        Sandwich sandwich1 = new Sandwich(TypeOfBread.valueOf(typeOfBread),vegetable,sandwichName);
        Order order1 = new Order(LocalDate.parse(date, dtf), sandwich1, new Person(firstName, lastName));
        return order1;
    }
}