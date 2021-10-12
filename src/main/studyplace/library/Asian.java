package studyplace.library;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// An Asian library with the unique information in it

public class Asian extends AbstractLibrary {
    public static final String NAME = "Asian Library";
    public static final String LOCATION = "1871 West Mall";
    public static final String INTRODUCTION = "UBC Asian Library provides support for scholars students and community "
            + "members who conduct research on, or are learning about Asia and Asian heritage.";
    public static final Integer BOOKS =  109304;
    public static final Double SCORE = 4.1;

    //EFFECT:build a new Asian Library
    public Asian() {
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
    //EFFECT: get the name of books in the Asian library
    public String getName() {
        return this.NAME;
    }

    @Override
    //EFFECT: get the amount of books in the Asian library
    public Integer getBooks() {
        return BOOKS;
    }

    @Override
    //EFFECT: get the introduction of the Asian library
    public String getIntroduction() {
        return INTRODUCTION;
    }

    @Override
    //EFFECT: get the location of the Asian Library
    public String getLocation() {
        return LOCATION;
    }

    @Override
    //EFFECT: get the score of the Asian Library
    public Double getScore() {
        return SCORE;
    }
}
