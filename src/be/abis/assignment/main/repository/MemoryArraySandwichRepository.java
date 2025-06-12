package be.abis.assignment.main.repository;

import be.abis.assignment.main.enumeration.TypeOfBread;
import be.abis.assignment.main.enumeration.TypeOfSandwich;
import be.abis.assignment.main.exceptions.SandwichNotFoundException;
import be.abis.assignment.main.model.Sandwich;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MemoryArraySandwichRepository implements SandwichRepository {
    private final String fileLocation = "PinkySandwichMenu.csv";
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
        sandwiches.sort(Comparator.comparing(Sandwich::getTypeOfSandwich));
        bufferedReader.close();
    }

    public Sandwich parseSandwich(String s) {
        String[] vals = s.split(";");
        String sandwichType = vals[0].toUpperCase();
        String title = vals[1];
        //TypeOfBread typeOfBread = TypeOfBread.valueOf(vals[2]);
        //Double price = Double.parseDouble(vals[3]);

        Sandwich s1 = new Sandwich(TypeOfSandwich.valueOf(sandwichType), TypeOfBread.WIT, false, title);
        return s1;
    }

    public void printMenu() {
        StringBuilder sb = new StringBuilder("");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%s\n", "Broodjes (Pinky)");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-30s%-30s%-25s%-25s\n", "Sandwich Type", "Sandwich Name", "Groenten Ja/Nee", "Bruin/Wit");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        //sandwiches.stream().collect(Collectors.groupingBy());
        for (Sandwich s : sandwiches) {
                NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl", "BE"));
                System.out.printf("%-30s%-25s%-25s%-25s\n",s.getTypeOfSandwich(), s.sandwichName, "", "");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
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
        sandwiches.stream().filter(sandwich1 -> sandwich1.equals(sandwich))
                .findFirst()
                .orElseThrow(()->new SandwichNotFoundException("\n\nSandwich not found in the Menu"));

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

}
