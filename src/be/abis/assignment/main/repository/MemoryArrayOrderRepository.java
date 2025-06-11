package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.model.Order;
import be.abis.assignment.main.model.Sandwich;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemoryArrayOrderRepository implements OrderRepository{
    public List<Order> orders = new ArrayList<>();
    String fileLocation = "";
    String fileLocationWrite = "/temp/javacourses/PinkySandwichOrderHistory.csv";
    public MemoryArrayOrderRepository() {
        //read the ordarOfThe file and fill it in orders list
        //orders = Files.lines(Paths.get(fileLocation))
        //        .map(line->this.parseOrder(line))
        //        .collect(Collectors.toList());
    }

    public void saveOrder(Order o){
        orders.add(o);
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocationWrite), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write(OrderRepository.formatOrder(o));
            System.out.println("bw");
            System.out.println(bw);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Order> findAllOrders() {
        return orders;
    }

    public void printOrders(){
        for(Order o : orders){
            System.out.println(o.getPerson().getFirstName() + " ordered " + o.getSandwich().getSandwichName());
        }
    }

    /*public Sandwich parseOrder(String s) {
        String[] vals = s.split(";");
        String title = vals[0];
        String vegetables = vals[1];
        //TypeOfBread typeOfBread = TypeOfBread.valueOf(vals[2]);
        Double price = Double.parseDouble(vals[3]);
        //System.out.println(title + "          " + vegetables + "           " + " " + "             " + price);
        Sandwich s1 = new Sandwich(TypeOfBread.GRIS, ("yes".equals(vegetables) ? true : false), title, price);
        return s1;
    }*/
}
