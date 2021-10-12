package ui;

import studyplace.library.AbstractLibrary;
import studyplace.persistence.JsonReader;
import studyplace.persistence.JsonWriter;
import studyplace.store.Booking;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BookingApp {
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static Booking booking;
    private static final String JSON_STORE = "./data/booking.json";

    // MODIFIES: this
    // EFFECTS: constructs workroom and runs application
    public BookingApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        booking = new Booking("My booking");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // MODIFIES: this
    // EFFECTS: adding a new booked library
    public void addBookedLibrary(AbstractLibrary library) {
        booking.addLibrary(library);
    }

    // EFFECTS: processes user input
    public void runBooking() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nThanks for using UBC study place helpdesk! :D");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tsave -> save booking to file");
        System.out.println("\tload -> load booking from file");
        System.out.println("\tprint -> print booking status");
        System.out.println("\tquit -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    public void processCommand(String command) {
        if (command.equals("save")) {
            saveBooking();
        } else if (command.equals("print")) {
            printBooking();
        } else if (command.equals("load")) {
            loadBooking();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // EFFECTS: saves the booking to file
    private void saveBooking() {
        try {
            jsonWriter.open();
            jsonWriter.write(booking);
            jsonWriter.close();
            System.out.println("Saved " + booking.getBookingName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // EFFECTS: prints all the Library and timeslots in booking to the console
    private void printBooking() {
        List<AbstractLibrary> libraries = booking.getLibraries();

        for (AbstractLibrary lib : libraries) {
            System.out.println(lib);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads booking from file
    private void loadBooking() {
        try {
            booking = jsonReader.read();
            System.out.println("Loaded " + booking.getBookingName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
