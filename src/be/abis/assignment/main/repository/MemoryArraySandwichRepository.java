package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.model.Person;
import be.abis.assignment.main.model.Sandwich;

import java.io.*;
import java.lang.reflect.Array;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MemoryArraySandwichRepository implements SandwichRepository {
    private String fileLocation = "/temp/javacourses/PinkySandwichMenu.csv";
    private List<Sandwich> sandwiches = new ArrayList<>();

    public MemoryArraySandwichRepository() throws IOException {
        this.readFile();
    }

    public void readFile() throws IOException {
        //System.out.println("heres the menu: ");
        //System.out.println("/////formatting to do here/////");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Sandwich s = this.parseSandwich(line);
           this.sandwiches.add(s);
        }
        bufferedReader.close();
    }

    public Sandwich parseSandwich(String s) {
        System.out.println(s);
        String[] vals = s.split(";");
        System.out.println(vals[0]);
        System.out.println(vals[1]);
        System.out.println(vals[2]);
        System.out.println(vals[3]);
        String title = vals[0];
        String vegetables = vals[1];
        //TypeOfBread typeOfBread = TypeOfBread.valueOf(vals[2]);
        Double price = Double.parseDouble(vals[3]);
        //System.out.println(title + "          " + vegetables + "           " + " " + "             " + price);

        Sandwich s1 = new Sandwich(TypeOfBread.GRIS, ("yes".equals(vegetables) ? true : false), title, price);
        return s1;
    }

    public void printMenu() {
        StringBuilder sb = new StringBuilder("");
        sb.append(String.format("Sandwiche Naam", "Groenten Ja/Nee", "Bruin/Wit"));
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%s\n","Broodjes (Pinky)");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%s\n","Naam: ");
        System.out.printf("%s\n","Training: ");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-30s%-25s%-25s%-25s\n", "Vlees", "Groenten Ja/Nee", "Bruin/Wit", "Price");
        System.out.println("-------------------------------------------------------------------------------------------");
               for (Sandwich s : sandwiches) {
                   NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl", "BE"));
                   nf.setGroupingUsed(false);
                   System.out.printf("%-30s%-25s%-25s%-25s\n", s.sandwichName, "", "", nf.format(s.sandwichPrice).replaceAll("\\u00A0", ""));
               }
           }

    public void addSandwichToMenu(Sandwich sandwich) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write(SandwichRepository.formatSandwich(sandwich));
            sandwiches.add(sandwich);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSandwichFromMenu(Sandwich sandwich) {
        try (BufferedWriter bwNew = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8)) {
            Iterator<Sandwich> iter = sandwiches.iterator();
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

    public String[] parseSandwichNew(String s) {
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
