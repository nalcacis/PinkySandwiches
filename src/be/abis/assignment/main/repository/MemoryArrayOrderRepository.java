package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
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
    String fileLocationWrite = "/temp/javacourses/PinkySandwichOrderHistory.csv";
    String fileLocationOrder = "/temp/javacourses/PinkySandwichOrderHistory.csv";

    public MemoryArrayOrderRepository() {
        //read the ordarOfThe file and fill it in orders list
        try {
            orders = Files.lines(Paths.get(fileLocationOrder))
                    .map(line -> this.parseOrder(line))
                    .filter(order -> order.getOrderDate().equals(LocalDate.now()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkSandwichOrderedToday() {

    }

    public void saveOrder(Order o) {
        //orders.stream().filter(order -> orders.equals(o))

        orders.add(o);
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocationWrite), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write(OrderRepository.formatOrder(o));
        } catch (IOException e) {
            System.out.println(e.getMessage());
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
        String firstname = vals[1];
        String sandwichName = vals[2];
        Order order1 = new Order(LocalDate.parse(date, dtf), new Sandwich(TypeOfBread.GRIS, true, sandwichName, 0.00), new Student(firstname, "test", new Session("JAVA")));
        return order1;
    }
}
