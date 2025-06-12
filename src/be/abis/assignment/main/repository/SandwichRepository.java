package be.abis.assignment.main.repository;

import be.abis.assignment.main.model.Sandwich;

public interface SandwichRepository {
    public void addSandwichToMenu(Sandwich sandwich);
    public void deleteSandwichFromMenu(Sandwich sandwich);
    public void printTodaysOrder();
    public void printMenu();

    public static String formatSandwich(Sandwich s){
        StringBuilder sb = new StringBuilder("");
        sb.append(s.getTypeOfSandwich()).append(";")
                .append(s.getSandwichName()).append(";")
                .append(";")
                .append(";")
                .append(s.sandwichPrice);
        return sb.toString();
    }
}