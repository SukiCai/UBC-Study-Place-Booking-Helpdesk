package studyplace.library;

import java.util.ArrayList;
import java.util.List;

// An Education with the unique information in it
public class Education extends AbstractLibrary {
    public static final String NAME = "Education Library";
    public static final String LOCATION = "2125 Main Mall";
    public static final String INTRODUCTION = "The Education Library’s role is to advance the academic and research "
            + "mission of the UBC. Striving to provide outstanding access to the universe of recorded knowledge "
            + "and information in the field of education.";
    public static final Integer BOOKS = 141081;
    public static final Double SCORE = 3.4;

    public Education() {
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
    //EFFECT: get the amount of books in the Education library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the Education library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Education Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the Education Library
    public Double getScore() {
        return SCORE;
    }
}
