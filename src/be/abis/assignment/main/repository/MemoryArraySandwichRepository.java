package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.model.Sandwich;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MemoryArraySandwichRepository implements SandwichRepository {
    String fileLocation = "/temp/javacourses/PinkySandwichMenu.csv";
    private List<Sandwich> sanwiches = new ArrayList<>();

    public MemoryArraySandwichRepository() throws IOException {
        this.readFile();
    }

    public void readFile() throws IOException {
        System.out.println("heres the menu: ");
        System.out.println("/////formatting to do here/////");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Sandwich s = this.parseSandwich(line);
            this.sanwiches.add(s);
        }
        bufferedReader.close();
    }

    public void addSandwichToMenu() {

    }

    public void deleteSandwichToMenu() {

    }

    public void printOutputToMenu() {

    }

    public Sandwich parseSandwich(String s) {
        String[] vals = s.split(";");
        String title = vals[0];
        String vegetables = vals[1];
        TypeOfBread typeOfBread = TypeOfBread.valueOf(vals[2]);
        Double price = Double.parseDouble(vals[3]);
        System.out.println(title + "          " + vegetables + "           " + typeOfBread + "             " + price);
        Sandwich s1 = new Sandwich(typeOfBread,("yes".equals(vegetables)?true:false),title,price);
        return s1;
    }
}
