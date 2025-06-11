package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.model.Person;
import be.abis.assignment.main.model.Sandwich;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemoryArraySandwichRepository implements SandwichRepository {
    private String fileLocation = "/temp/javacourses/PinkySandwichMenu.csv";
    private List<Sandwich> sanwiches = new ArrayList<>();

    public MemoryArraySandwichRepository() throws IOException {
        this.readFile();
    }

    public void readFile() throws IOException {
        //System.out.println("heres the menu: ");
        //System.out.println("/////formatting to do here/////");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            //Sandwich s = this.parseSandwich(line);
            //this.sanwiches.add(s);
            String[] sandwiches = this.parseSandwich(line);
            System.out.println(sandwiches[0]);
            System.out.println(sandwiches[1]);
        }
        bufferedReader.close();
    }

    public void printMenu() {
        for (Sandwich s : sanwiches) {
            System.out.println(s.sandwichName + " " + s.sandwichPrice);
        }
    }

    public void addSandwichToMenu(Sandwich sandwich) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write(SandwichRepository.formatSandwich(sandwich));
            sanwiches.add(sandwich);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSandwichFromMenu(Sandwich sandwich) {
        try (BufferedWriter bwNew = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8)) {
            Iterator<Sandwich> iter = sanwiches.iterator();
            while (iter.hasNext()) {
                Sandwich s = iter.next();
                if (s.equals(sandwich)) {
                    iter.remove();
                } else {
                    bwNew.write(SandwichRepository.formatSandwich(s));
                    bwNew.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printTodaysOrder() {


    }

    public String[] parseSandwich(String s) {
        String[] vals = s.split(";");
        String title = vals[0];
        String vegetables = vals[1];
        //TypeOfBread typeOfBread = TypeOfBread.valueOf(vals[2]);
        Double price = Double.parseDouble(vals[3]);
        //System.out.println(title + "          " + vegetables + "           " + " " + "             " + price);
        //Sandwich s1 = new Sandwich(TypeOfBread.GRIS, ("yes".equals(vegetables) ? true : false), title, price);
        //return s1;
        return vals;
    }
}
