package studyplace.library;

import studyplace.persistence.Writable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

// An Abstract Library have listed abstract method

public abstract class AbstractLibrary implements Writable {
    private String libraryName;
    private List<String> bookedTimeSlots;

    // EFFECTS: constructs an AbstractLibrary with a name and booked time
    public AbstractLibrary(String name) {
        this.libraryName = name;
        this.bookedTimeSlots = new ArrayList<>();
    }

    // EFFECTS: add the booked time slots into the library
    public void addBookedTimeSlots(String timeSlot) {
        this.bookedTimeSlots.add(timeSlot);
    }

    // EFFECTS: return the booked time slots of the library
    public List<String> getBookedTimeSlots() {
        return this.bookedTimeSlots;
    }


    //EFFECT: available time for the group study place
    public abstract List<String> availableTimeForStudy();

    //EFFECT: get the introduction of the Asian
    public abstract String getIntroduction();

    //EFFECT: get the location of the Asian Library
    public abstract String getLocation();

    //EFFECT: get the score of the Asian Library
    public abstract Double getScore();

    //EFFECT: get the name of books in the Asian
    public abstract String getName();

    //EFFECT: get the amount of books in the Asian
    public abstract Integer getBooks();

    @Override

    // EFFECTS: returns the Json object contain this library name and this library timeslots
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", libraryName);
        JSONArray jsonArray = new JSONArray();
        for (String timeSlot : bookedTimeSlots) {
            jsonArray.put(timeSlot);
        }
        json.put("Booked Time", jsonArray);
        return json;
    }

    // EFFECTS: returns string representation of this library
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(libraryName);
        sb.append("\n");
        sb.append("Book time: ");
        for (String timeSlot : bookedTimeSlots) {
            sb.append(timeSlot);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
