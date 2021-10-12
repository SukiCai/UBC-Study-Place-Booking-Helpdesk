package ui;

import studyplace.library.*;
import studyplace.residencestudyroom.OrchardCommons;
import studyplace.residencestudyroom.PlaceVanier;
import studyplace.residencestudyroom.TotemPark;
import studyplace.store.Booking;

import java.io.FileNotFoundException;
import java.util.*;

//Manage all the user information

public class InformationManager {

    private static final String FIND_A_STUDY_PLACE = "find";
    private static final String BOOK_A_SEAT_IN_STUDY_PLACE = "book";

    private static final String Orchard_Commons = "oc";
    private static final String Place_Vanier = "pv";
    private static final String TOTEM_PARK = "tp";
    private static final String QUIT_COMMAND = "quit";
    private static final String VIEW = "view";

    private static final String CLOSEST = "distance";
    private static final String HIGHEST_SCORE = "score";
    private static final String RICHEST_BOOK = "books";
    private Booking booking;

    private Scanner input;
    private boolean runProgram;

    //Make new objects for each library
    Asian asian = new Asian();
    BiomedicalBranch biomedicalBranch = new BiomedicalBranch();
    DavidLam davidLam = new DavidLam();
    Education education = new Education();
    IrvingKBarberLearning irvingKBarberLearning = new IrvingKBarberLearning();
    Koerner koerner = new Koerner();
    Law law = new Law();
    Woodward woodWard = new Woodward();
    Xwi7xwa xwi7xwa = new Xwi7xwa();
    List<AbstractLibrary> libs = new ArrayList<>();
    static Set<AbstractLibrary> bookedLibs = new HashSet<>();
    OrchardCommons orchardCommons = new OrchardCommons();
    PlaceVanier placeVanier = new PlaceVanier();
    TotemPark totemPark = new TotemPark();

    static Map<String, AbstractLibrary> nameLibrary = new HashMap<>();

    Map<String, List<String>> nameAndTime = new HashMap<>();

    String typedString;
    public static String chosenLibraryName;
    String chosenTimeSlot;

    public static BookingApp bookingApp;

    // EFFECTS: set the chosen library in the field
    // MODIFIES: this
    public static void setChosenLibraryName(String libraryName) {
        chosenLibraryName = libraryName;
    }

    // EFFECTS: initialize a new InformationManager (Constructor)
    // MODIFIES: this
    public InformationManager(String typedString) throws FileNotFoundException {
        bookingApp = new BookingApp();
        runProgram = true;
        buildLib();
        makeANameMap();
        makeANameAndTimeMap();
        handleUserInputStudyOrBook(typedString);
    }

    // EFFECTS: Make a map with the library name with its timeslot
    // MODIFIES: this
    public void makeANameAndTimeMap() {
        nameAndTime.put(makePrettyString(asian.getName()), asian.availableTimeForStudy());
        nameAndTime.put(makePrettyString(biomedicalBranch.getName()), biomedicalBranch.availableTimeForStudy());
        nameAndTime.put(makePrettyString(davidLam.getName()), davidLam.availableTimeForStudy());
        nameAndTime.put(makePrettyString(education.getName()), education.availableTimeForStudy());
        nameAndTime.put(makePrettyString(irvingKBarberLearning.getName()),
                irvingKBarberLearning.availableTimeForStudy());
        nameAndTime.put(makePrettyString(koerner.getName()), koerner.availableTimeForStudy());
        nameAndTime.put(makePrettyString(law.getName()), law.availableTimeForStudy());
        nameAndTime.put(makePrettyString(woodWard.getName()), woodWard.availableTimeForStudy());
        nameAndTime.put(makePrettyString(xwi7xwa.getName()), xwi7xwa.availableTimeForStudy());
    }

    // EFFECTS: build a list of libraries
    // MODIFIES: this
    public void buildLib() {
        libs.add(asian);
        libs.add(biomedicalBranch);
        libs.add(davidLam);
        libs.add(education);
        libs.add(irvingKBarberLearning);
        libs.add(koerner);
        libs.add(law);
        libs.add(woodWard);
        libs.add(xwi7xwa);
    }

    // EFFECTS: build a map with the libraries names and related Name in the class field
    // MODIFIES: this
    public void makeANameMap() {
        nameLibrary.put(makePrettyString(asian.getName()), asian);
        nameLibrary.put(makePrettyString(biomedicalBranch.getName()), biomedicalBranch);
        nameLibrary.put(makePrettyString(davidLam.getName()), davidLam);
        nameLibrary.put(makePrettyString(education.getName()), education);
        nameLibrary.put(makePrettyString(irvingKBarberLearning.getName()), irvingKBarberLearning);
        nameLibrary.put(makePrettyString(law.getName()), law);
        nameLibrary.put(makePrettyString(koerner.getName()), koerner);
        nameLibrary.put(makePrettyString(woodWard.getName()), woodWard);
        nameLibrary.put(makePrettyString(xwi7xwa.getName()), xwi7xwa);
    }

    // EFFECTS: parses user input until user quits
    // MODIFIES: this
    public void handleUserInputStudyOrBook(String typedString) {
        printInstructionsFindOrBook();
        if (typedString.equals("score") || typedString.equals("books") || typedString.equals("distance")) {
            // Choose between score books and distance
            parseInputDistanceBookOrScore(typedString);
        } else if (typedString.equals("oc") || typedString.equals("pv") || typedString.equals("tp")) {
            // Choose between oc pv or tp
            parseInputDistance(typedString);
        } else if (nameAndTime.containsKey(typedString)) { // Choose a library to book
            chosenLibraryName = typedString;
            parseInputBook(typedString);
        } else if (typedString.equals("view") || typedString.equals("s") || typedString.equals("l")) {
            parseInputView();
        } else if (typedString.equals("find") || typedString.equals("book")) {
            // Choose between find or book and print the selected instructions
            parseInputStudyOrBook(typedString);
        } else if (typedString.equals(QUIT_COMMAND)) {
            parseInputQuit();
        } else if (Integer.parseInt(typedString) >= 0) {
            // Choose timeSlot and type in an 8 digits student numbers
            parseInputNumber(typedString);
        } else {
            System.out.println("Sorry, I didn't understand that command. Please try again.");
        }
    }

    // EFFECTS: parse the quit input to end the program
    // MODIFIES: this
    public void parseInputQuit() {
        runProgram = false;
        endProgram();
    }

    // EFFECTS: print the booked library's/libraries' name(s) and the booked timeslot(s)
    // MODIFIES: this
    public void parseInputView() {
        for (AbstractLibrary  lib : bookedLibs) {
            bookingApp.addBookedLibrary(lib);

            // print booked library's name.
            System.out.println(lib.getName());
            List<String> bookedTimeSlots = lib.getBookedTimeSlots();
            // print booked timeslots.
            for (String timeSlot : bookedTimeSlots) {
                System.out.println(timeSlot);
            }
        }
    }

    //EFFECTS: prints menu options and info depending on input str
    // MODIFIES: this
    public void parseInputNumber(String typedString) {
        if (Integer.parseInt(typedString) >= nameAndTime.get(chosenLibraryName).size()
                && Integer.parseInt(typedString) <= 12) { // The number is not a student number, 24/2=12
            System.out.println("Selected time already been booked");
        } else if (Integer.parseInt(typedString) <= nameAndTime.get(chosenLibraryName).size()) {
            chosenTimeSlot = nameAndTime.get(chosenLibraryName).get(Integer.parseInt(typedString));
            parseInputTimeSlot(typedString, chosenLibraryName);
        } else if (Integer.parseInt(typedString) > 9999999 && Integer.parseInt(typedString) <= 99999999) {
            // Type in an 8 digit student number
            parseInputStudentNumber(typedString, chosenLibraryName, chosenTimeSlot);
        } else {
            System.out.println("Sorry, I didn't understand that command. Please try again.");
            printInstructionsForBook();
        }
    }


    //EFFECTS: prints menu options and info depending on input str
    // MODIFIES: this
    private void parseInputStudyOrBook(String typedString) {
        if (typedString.length() > 0) {
            switch (typedString) {
                case FIND_A_STUDY_PLACE:
                    printInstructionsForChosenDistanceBookOrScore();
                    break;
                case BOOK_A_SEAT_IN_STUDY_PLACE:
                    printInstructionsForBook();
                    break;
                case QUIT_COMMAND:
                    runProgram = false;
                    endProgram();
                    break;
                default:
                    System.out.println("Sorry, I didn't understand that command. Please try again.");
                    printInstructionsFindOrBook();
                    break;
            }
        }
    }

    // EFFECTS: prints menu options for booking
    // MODIFIES: this
    private void parseInputBook(String typedString) {
        System.out.println("Which time slot do you want to book?");
        System.out.println("\nBelow are available time listed:\n");
        for (int i = 0; i < nameAndTime.get(typedString).size(); i++) {
            System.out.println("Enter '" + Integer.toString(i) + "' to book a time at "
                    + nameAndTime.get(typedString).get(i));
        }

    }

    // EFFECTS: prints menu options and info depending on input str
    // MODIFIES: this
    private void parseInputDistanceBookOrScore(String typedString) {
        if (typedString.length() > 0) {
            switch (typedString) {
                case CLOSEST:
                    printInstructionsGiveLocation();
                    break;
                case HIGHEST_SCORE:
                    printHighestScoreRanking();
                    break;
                case RICHEST_BOOK:
                    printRichestBooksRanking();
                    break;
                case QUIT_COMMAND:
                    runProgram = false;
                    endProgram();
                    break;
                default:
                    System.out.println("Sorry, I didn't understand that command. Please try again.");
                    printInstructionsForChosenDistanceBookOrScore();
                    break;
            }
        }
    }

    // EFFECTS: prints menu options and info depending on input str
    // MODIFIES: this
    private void parseInputDistance(String typedString) {
        if (typedString.length() > 0) {
            switch (typedString) {
                case Place_Vanier:
                    printPrecalculatedClosestRankingPV();
                    break;
                case Orchard_Commons:
                    printPrecalculatedClosestRankingOC();
                    break;
                case TOTEM_PARK:
                    printPrecalculatedClosestRankingTP();
                    break;
                case QUIT_COMMAND:
                    runProgram = false;
                    endProgram();
                    break;
                default:
                    System.out.println("Sorry, I didn't understand that command. Please try again.");
                    printInstructionsGiveLocation();
                    break;
            }
        }
    }

    // EFFECTS: get the student number, booked library and booked time printed, give option to book
    // MODIFIES: this
    private void parseInputStudentNumber(String str, String libraryName, String timeSlot) {
        System.out.println("You have successfully booked! Below is your status");
        System.out.println("Student number: " + str);
        System.out.println("Library booked: " + libraryName);
        System.out.println("Time booked: " + timeSlot);
        System.out.println("Ps: You should have your student ID checked before you get into the room :)");
        System.out.println("\nEnter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "' to book another study place");
        System.out.println("Enter '" + VIEW + "' to view your booking status");
    }

    // EFFECTS: remove selected time slot and get the student number
    // MODIFIES: this，library
    private void parseInputTimeSlot(String str, String libraryName) {
        String removeTimeSlot = nameAndTime.get(libraryName).get(Integer.parseInt(str));
        nameAndTime.get(libraryName).remove(removeTimeSlot);
        AbstractLibrary lib = nameLibrary.get(libraryName);
        lib.addBookedTimeSlots(removeTimeSlot);
        if (!bookedLibs.contains(lib)) {
            bookedLibs.add(lib);
        }
        System.out.println("You are successfully booking");
    }

    // EFFECTS: stops receiving user input (end the program)
    public void endProgram() {
        System.out.println("Quitting...");
        System.out.println("Thanks for using UBC study place helpdesk :D");
        input.close();
    }

    // EFFECTS: prints the instructions for find a study place
    private void printInstructionsForChosenDistanceBookOrScore() {
        System.out.println("Chose your preference");
        System.out.println("\nYou can request the following information:\n");
        System.out.println("Enter '" + CLOSEST + "' to find a study place that is the closest.");
        System.out.println("Enter '" + HIGHEST_SCORE + "' to find a study place which has the highest score.");
        System.out.println("Enter '" + RICHEST_BOOK + "' to find a study place which has the richest books.");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // EFFECTS: prints the instructions for booking a study place
    private void printInstructionsForBook() {
        System.out.println("Which study place do you want to book?");
        System.out.println("\nYou can request the following information:\n");
        System.out.println("Enter '" + asian.getName() + "' to book a study place in " + asian.getName());
        System.out.println("Enter '" + biomedicalBranch.getName() + "' to book a study place in "
                + biomedicalBranch.getName());
        System.out.println("Enter '" + davidLam.getName() + "' to book a study place in " + davidLam.getName());
        System.out.println("Enter '" + education.getName() + "' to book a study place in " + education.getName());
        System.out.println("Enter '" + irvingKBarberLearning.getName() + "' to book a study place in "
                + irvingKBarberLearning.getName());
        System.out.println("Enter '" + koerner.getName() + "' to book a study place in " + koerner.getName());
        System.out.println("Enter '" + law.getName() + "' to book a study place in " + law.getName());
        System.out.println("Enter '" + woodWard.getName() + "' to book a study place in " + woodWard.getName());
        System.out.println("Enter '" + xwi7xwa.getName() + "' to book a study place in " + xwi7xwa.getName());
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // EFFECTS: print the instructions for giving location
    private void printInstructionsGiveLocation() {
        System.out.println("Please select your current location");
        System.out.println("\nYou can request the following information:\n");
        System.out.println("Enter '" + Orchard_Commons + "' if you are now in Orchard Common");
        System.out.println("Enter '" + Place_Vanier + "' if you are now in Place Vanier");
        System.out.println("Enter '" + TOTEM_PARK + "' if you are now in Totem Park");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // EFFECTS: prints instructions to use kiosk
    private void printInstructionsFindOrBook() {
        System.out.println("Welcome to the UBC study place helpdesk!");
        System.out.println("\nYou can request the following information:\n");
        System.out.println("Enter '" + FIND_A_STUDY_PLACE + "' for finding a study place.");
        System.out.println("Enter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "' for book a study place ");
        System.out.println("Enter '" + VIEW + "' to view your booking status before ");
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
    }

    // EFFECTS: prints a ranking with the top 5 highest score library
    private void printHighestScoreRanking() {
        List<String> namesAndScores = madeALibraryMapWithScore();
        for (String str : namesAndScores) {
            System.out.println(str);
        }
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
        System.out.println("To book a seat in your the library, enter '"
                + BOOK_A_SEAT_IN_STUDY_PLACE + "'.");
    }

    // EFFECTS: print the books ranking from richest to lowest
    public void printRichestBooksRanking() {
        List<String> namesAndBooks = madeALibraryMapWithBooks();
        for (String str : namesAndBooks) {
            System.out.println(str);
        }

        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
        System.out.println("To book a seat in your the library, enter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "'.");
    }

    // EFFECTS: To ensure that the project runs properly although the score of the library changed.
    // MODIFIES: this
    private List<String> madeALibraryMapWithScore() {
        // Construct a tree map whose key is score and value is a list of library name, reverseOrder base on the key.
        TreeMap<Double, List<String>> scoreLibraryNameSameScore = new TreeMap<>(Collections.reverseOrder());
        // Combine the library that has the same score and add the name into
        for (AbstractLibrary lib : this.libs) {
            double score = lib.getScore();
            String name = lib.getName();
            scoreLibraryNameSameScore.putIfAbsent(score, new ArrayList<>());
            scoreLibraryNameSameScore.get(score).add(name);
        }
        // Construct a list of Generated String based on the sorted scores and the names
        List<String> generatedListOfString = new ArrayList<>();
        for (double score : scoreLibraryNameSameScore.keySet()) {
            List<String> names = scoreLibraryNameSameScore.get(score);
            generatedListOfString.add(stringGeneratorScore(names, score));
        }

        return generatedListOfString;
    }

    // EFFECTS: To ensure that the project runs properly although the books amount of the library changed.
    // MODIFIES: this
    private List<String> madeALibraryMapWithBooks() {
        // Construct a tree map whose key is Books and value is a list of library name, reverseOrder base on the key.
        TreeMap<Integer, List<String>> scoreLibraryNameSameScore = new TreeMap<>(Collections.reverseOrder());
        // Combine the library that has the same score and add the name into
        for (AbstractLibrary lib : this.libs) {
            int books = lib.getBooks();
            String name = lib.getName();
            scoreLibraryNameSameScore.putIfAbsent(books, new ArrayList<>());
            scoreLibraryNameSameScore.get(books).add(name);
        }
        // Construct a list of Generated String based on the sorted scores and the names
        List<String> generatedListOfString = new ArrayList<>();
        for (int books : scoreLibraryNameSameScore.keySet()) {
            List<String> names = scoreLibraryNameSameScore.get(books);
            generatedListOfString.add(stringGeneratorBooks(names, books));
        }

        return generatedListOfString;
    }

    // EFFECTS: Generate the String to print a whole sentence which contains the library name and the score of it.
    // MODIFIES: this
    private String stringGeneratorScore(List<String> names, Double score) {
        String string = "";
        for (String name : names) {
            string += name + ", ";
        }
        return string + " Score: " + score;
    }

    // EFFECTS: Generate the String to print a whole sentence which contains the library name and the amount of books.
    // MODIFIES: this
    private String stringGeneratorBooks(List<String> names, Integer books) {
        String string = "";
        for (String name : names) {
            string += name + ", ";
        }
        return string + " Books Amount: " + books;
    }

    // EFFECTS: print out the pre-calculated top 5 closest library for Place Vanier
    public void printPrecalculatedClosestRankingPV() {
        System.out.println(placeVanier.getStudyRoomName() + " distance < 100m, " + "location:"
                + placeVanier.getLocation());
        System.out.println(xwi7xwa.getName() + " distance = 230m, " + "location:" + xwi7xwa.getLocation());
        System.out.println(asian.getName() + " distance = 350m, " + "location:" + asian.getLocation());
        System.out.println(davidLam.getName() + " distance = 450m, " + "location:" + davidLam.getLocation());
        System.out.println(koerner.getName() + " distance = 500m, " + "location:" + koerner.getLocation());
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
        System.out.println("To book a seat in your the library, enter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "'.");
    }

    // EFFECTS: print out the pre-calculated top 5 closest library for Orchard Commons
    public void printPrecalculatedClosestRankingOC() {
        System.out.println(orchardCommons.getStudyRoomName() + " distance < 100m, " + "location:"
                + orchardCommons.getLocation());
        System.out.println(education.getName() + " distance = 650m, " + "location:" + education.getLocation());
        System.out.println(woodWard.getName() + " distance = 700m, " + "location:" + woodWard.getLocation());
        System.out.println(davidLam.getName() + " distance = 850m, " + "location:" + davidLam.getLocation());
        System.out.println(koerner.getName() + " distance = 900m, " + "location:" + koerner.getLocation());
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
        System.out.println("To book a seat in your the library, enter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "'.");
    }

    // EFFECTS: print out the pre-calculated top 5 closest library for Totem Park
    public void printPrecalculatedClosestRankingTP() {
        System.out.println(totemPark.getStudyRoomName() + " distance < 100m, " + "location:"
                + totemPark.getLocation());
        System.out.println(education.getName() + " distance = 850m, " + "location:" + education.getLocation());
        System.out.println(woodWard.getName() + " distance = 1000m, " + "location:" + woodWard.getLocation());
        System.out.println(davidLam.getName() + " distance = 1050m, " + "location:" + davidLam.getLocation());
        System.out.println(koerner.getName() + " distance = 1100m, " + "location:" + koerner.getLocation());
        System.out.println("To quit at any time, enter '" + QUIT_COMMAND + "'.");
        System.out.println("To book a seat in your the library, enter '" + BOOK_A_SEAT_IN_STUDY_PLACE + "'.");
    }

    // EFFECTS: removes white space and quotation marks around s
    // MODIFIES: this
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|\'", "");
        return s;
    }

    // EFFECTS: get user input and make it pretty
    // MODIFIES: this
    private String getUserInputString() {
        String str = "";
        if (input.hasNext()) {
            str = input.nextLine();
            str = makePrettyString(str);
        }
        return str;
    }
}
