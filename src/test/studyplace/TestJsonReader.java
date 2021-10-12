package studyplace;

import org.junit.jupiter.api.Test;
import studyplace.library.AbstractLibrary;
import studyplace.persistence.JsonReader;
import studyplace.store.Booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// cite from JsonSerializationDemo

public class TestJsonReader extends TestJson {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Booking booking = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyBooking() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyBooking.json");
        try {
            Booking booking = reader.read();
            assertEquals("My booking", booking.getBookingName());
            assertEquals(0, booking.numLibraries());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralBooking() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralBooking.json");
        try {
            Booking booking = reader.read();
            assertEquals("My booking", booking.getBookingName());
            List<AbstractLibrary> libraries = booking.getLibraries();
            assertEquals(4, libraries.size());
            List<String> timeSlot16_18 = new ArrayList<>();
            timeSlot16_18.add("16:00 - 18:00");
            List<String> timeSlot09_12 = new ArrayList<>();
            timeSlot09_12.add("9:00 - 12:00");
            checkBooking("Woodward Library",timeSlot16_18, libraries.get(0));
            checkBooking("Biomedical Branch Library",timeSlot16_18, libraries.get(1));
            checkBooking("David Lam Library",timeSlot16_18, libraries.get(2));
            checkBooking("Asian Library",timeSlot09_12, libraries.get(3));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
