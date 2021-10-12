package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An Woodward library with the unique information in it
public class Woodward extends AbstractLibrary {
    public static final String NAME = "Woodward Library";
    public static final String LOCATION = " 2198 Health Sciences Mall";
    public static final String INTRODUCTION = "The Woodward Library’s collection covers a broad range of disciplines "
            + "in support of learning and research in the Faculties of Applied Science, Dentistry, Forestry, Land & "
            + "Food Systems, Medicine, Pharmaceutical Sciences and Science.";
    public static final Integer BOOKS = 195991;
    public static final Double SCORE = 3.8;

    public Woodward() {
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
    //EFFECT: get the amount of books in the Woodward library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the Woodward library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Woodward Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the Woodward Library
    public Double getScore() {
        return SCORE;
    }
}

