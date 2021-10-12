package studyplace.persistence;

import studyplace.library.AbstractLibrary;
import studyplace.library.LibraryMapper;
import studyplace.store.Booking;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// cite from JsonSerializationDemo

public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads booking from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Booking read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseBooking(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses Booking from JSON object and returns it
    private Booking parseBooking(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Booking booking = new Booking(name);
        addLibraries(booking, jsonObject);
        return booking;
    }

    // MODIFIES: booking
    // EFFECTS: parses libraries from JSON object and adds them to Booking
    private void addLibraries(Booking booking, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("libraries");
        for (Object json : jsonArray) {
            JSONObject nextLibrary = (JSONObject) json;
            addLibrary(booking, nextLibrary);
        }
    }

//     MODIFIES: booking
//     EFFECTS: parses library from JSON object and adds it to Booking
    private void addLibrary(Booking booking, JSONObject jsonObject) {
        String libName = jsonObject.getString("name");
        JSONArray jsonArray = jsonObject.getJSONArray("Booked Time");

        AbstractLibrary library = LibraryMapper.createLib(libName);
        for (Object json : jsonArray) {
            library.addBookedTimeSlots(json.toString());
        }
        booking.addLibrary(library);
    }
}
