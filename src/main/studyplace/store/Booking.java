package studyplace.store;

import studyplace.library.AbstractLibrary;
import studyplace.persistence.Writable;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Booking implements Writable {
    private String bookingName;
    private List<AbstractLibrary> libraries;

    // EFFECTS: constructs booking with a name and empty list of libraries
    public Booking(String bookingName) {
        this.bookingName = bookingName;
        libraries = new ArrayList<>();
    }


    // EFFECTS: return the booking Name in this booking
    public String getBookingName() {
        return bookingName;
    }

    // EFFECTS: add a new abstract library to the list of libraries in this booking
    public void addLibrary(AbstractLibrary library) {
        this.libraries.add(library);
    }

    // EFFECTS: returns number of libraries in this booking
    public int numLibraries() {
        return libraries.size();
    }

    // EFFECTS: returns the libraries in this booking
    public List<AbstractLibrary> getLibraries() {
        return this.libraries;
    }

    //EFFECTS: returns bookingName and the JsonArray in this booking as a json object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", bookingName);
        json.put("libraries", librariesToJson());
        return json;
    }

    // EFFECTS: returns libraries in this booking as a JSON array
    private JSONArray librariesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (AbstractLibrary library : libraries) {
            jsonArray.put(library.toJson());
        }

        return jsonArray;
    }
}
