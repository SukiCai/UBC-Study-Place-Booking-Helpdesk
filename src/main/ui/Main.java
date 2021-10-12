package ui;

import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) {
        InformationManager info = null;
        try {
            info = new InformationManager("");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
