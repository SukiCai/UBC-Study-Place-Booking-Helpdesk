package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An IrvingKBarberLearning library with the unique information in it
public class IrvingKBarberLearning extends AbstractLibrary {
    public static final String NAME = "Irving K.Barber Learning Center";
    public static final String LOCATION = "1961 E Mall";
    public static final String INTRODUCTION = " The Learning Centre is built around the refurbished core of the "
            + "1925 UBC Main Library. The Centre is named for Irving. K. Barber, philanthropist and a graduate of UBC";
    public static final Integer BOOKS = 1622914;
    public static final Double SCORE = 4.6;

    public IrvingKBarberLearning() {
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
    //EFFECT: get the amount of books in the IKB
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the IKB
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the IKB
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the IKB
    public Double getScore() {
        return SCORE;
    }
}
