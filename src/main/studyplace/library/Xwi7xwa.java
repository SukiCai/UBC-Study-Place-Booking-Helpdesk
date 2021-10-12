package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An Xwi7xwa library with the unique information in it

public class Xwi7xwa extends AbstractLibrary {
    public static final String NAME = "Xwi7xwa Library";
    public static final String LOCATION = "2775 Laurel St";
    public static final String INTRODUCTION = "The BMB Library has 12 public computers that are directly connected to "
            + "the UBC Network, and the DHCC building offers public wifi";
    public static final Integer BOOKS = 15271;
    public static final Double SCORE = 3.3;

    public Xwi7xwa() {
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

    //EFFECTS: get the name of the library.
    public String getName() {
        return NAME;
    }

    @Override
    //EFFECT: get the amount of books in the Xwi7xwa library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the Xwi7xwa library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Xwi7xwa Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the Xwi7xwaLibrary
    public Double getScore() {
        return SCORE;
    }
}

