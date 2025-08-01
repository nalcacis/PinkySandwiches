package be.abis.assignment.main.repository;

import be.abis.assignment.main.exceptions.MaxSandwitchPerDayException;
import be.abis.assignment.main.model.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface OrderRepository {
    public void saveOrder(Order o) throws MaxSandwitchPerDayException;
    public void statistics();
    public void printOrders();

    static String formatOrder(Order o) {
        StringBuilder sb = new StringBuilder("");
        LocalDate today = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        sb.append(today.format(dtf)).append(";")
                .append(o.getPerson().getFirstName()).append(";")
                .append(o.getPerson().getLastName()).append(";")
                .append(o.getSandwich().getTypeOfBread()).append(";")
                .append(o.getSandwich().isVegetables()).append(";")
                .append(o.getSandwich().getSandwichName()).append(";");
        return sb.toString();
    }

    static String formatTodaysOrder(Order o) {
        StringBuilder sb = new StringBuilder("");
        sb.append(o.getPerson().getFirstName()).append(" ordered ")
                .append(o.getSandwich().getSandwichName()).append(" sandwich ")
        .append((o.getSandwich().vegetables?"with salad and ":"without salad and ")).append(o.getSandwich().getTypeOfBread().toString().toLowerCase()).append(" brood.");
        return sb.toString();
    }
}
