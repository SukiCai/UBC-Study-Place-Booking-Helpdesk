package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An Koerner library with the unique information in it
public class Koerner extends AbstractLibrary {
    public static final String NAME = "Koerner Library";
    public static final String LOCATION = "1958 Main Mall";
    public static final String INTRODUCTION = "The library is named after Walter C. Koerner, a Canadian businessman "
            + "and philanthropist Walter C. Koerner Library forms the main academic and "
            + "general resource library collection at UBC";
    public static final Integer BOOKS = 1216322;
    public static final Double SCORE = 4.5;

    public Koerner() {
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
    //EFFECT: get the amount of books in the Koerner library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the koerner library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Koerner Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the BKoerner Library
    public Double getScore() {
        return SCORE;
    }
}
