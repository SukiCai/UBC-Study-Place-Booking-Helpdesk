package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An Law library with the unique information in it

public class Law extends AbstractLibrary {
    public static final String NAME = "Law Library";
    public static final String LOCATION = "Allard Hall, 1822 E Mall";
    public static final String INTRODUCTION = "The Law Library is part of the UBC Library System, and is located on "
            + "three floors in the Peter A. Allard School of Law complex. It supports the study, reference, and "
            + "research needs of the students and faculty of the Allard School of Law, and other members of the "
            + "University community. ";
    public static final Integer BOOKS = 57926;
    public static final Double SCORE = 4.6;

    public Law() {
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
    //EFFECT: get the amount of books in the Law library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the Law library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Law Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the Law Library
    public Double getScore() {
        return SCORE;
    }
}
