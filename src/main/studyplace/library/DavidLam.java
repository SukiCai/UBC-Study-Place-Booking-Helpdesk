package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An David Lam library with the unique information in it
public class DavidLam extends AbstractLibrary {
    public static final String NAME = "David Lam Library";
    public static final String LOCATION = "2033 Main Mall";
    public static final String INTRODUCTION = "The David Lam Management Research Library provides collections and "
            + "research support in the areas of commerce and business administration.";
    public static final Integer BOOKS = 22025;
    public static final Double SCORE = 3.3;

    public DavidLam() {
        super(NAME);
    }

    @Override
    //EFFECTS: constructs a list of available time for study
    public List<String> availableTimeForStudy() {
        List<String> available = new ArrayList<>();
        available.add("9:00 - 12:00");
        available.add("12:00 - 14:00");
        available.add("14:00 - 16:00");
        available.add("16:00 - 18:00");
        available.add("18:00 - 20:00");
        return available;
    }

    @Override
    //EFFECTS: get the name of the library.
    public String getName() {
        return NAME;
    }

    @Override
    //EFFECT: get the amount of books in the DavidLam library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the DavidLam library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the DavidLam Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the DavidLam Library
    public Double getScore() {
        return SCORE;
    }
}

