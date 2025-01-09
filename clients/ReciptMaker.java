package clients;

import catalogue.Basket;

import java.io.FileWriter;

public class ReciptMaker {
    public static void makeRecipt(Basket b) {
       try (FileWriter file = new FileWriter("recipt.txt")) {
           file.write(b.getDetails());
           file.write("Thank you for Shopping with us!");
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
