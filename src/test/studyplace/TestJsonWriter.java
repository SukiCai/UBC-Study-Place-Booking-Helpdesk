package studyplace;

import org.junit.jupiter.api.Test;
import studyplace.library.*;
import studyplace.persistence.JsonReader;
import studyplace.persistence.JsonWriter;
import studyplace.store.Booking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// cite from JsonSerializationDemo

public class TestJsonWriter extends TestJson {
    @Test
    void testWriterInvalidFile() {
        try {
            Booking booking = new Booking("My booking");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyBooking() {
        try {
            Booking booking = new Booking("My booking");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyBooking.json");
            writer.open();
            writer.write(booking);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyBooking.json");
            booking = reader.read();
            assertEquals("My booking", booking.getBookingName());
            assertEquals(0, booking.numLibraries());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralBooking() {
        List<String> timeSlot16_18 = new ArrayList<>();
        timeSlot16_18.add("16:00 - 18:00");
        List<String> timeSlot09_12 = new ArrayList<>();
        timeSlot09_12.add("9:00 - 12:00");
        try {
            Booking booking = new Booking("My booking");
            AbstractLibrary newLib1 = new Woodward();
            newLib1.addBookedTimeSlots("16:00 - 18:00");
            AbstractLibrary newLib2 = new BiomedicalBranch();
            newLib2.addBookedTimeSlots("16:00 - 18:00");
            AbstractLibrary newLib3 = new DavidLam();
            newLib3.addBookedTimeSlots("16:00 - 18:00");
            AbstractLibrary newLib4 = new Asian();
            newLib4.addBookedTimeSlots("9:00 - 12:00");

            booking.addLibrary(newLib1);
            booking.addLibrary(newLib2);
            booking.addLibrary(newLib3);
            booking.addLibrary(newLib4);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralBooking.json");
            writer.open();
            writer.write(booking);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralBooking.json");
            booking = reader.read();
            assertEquals("My booking", booking.getBookingName());
            List<AbstractLibrary> libraries = booking.getLibraries();
            assertEquals(4, libraries.size());


            checkBooking("Woodward Library",timeSlot16_18, libraries.get(0));
            checkBooking("Biomedical Branch Library",timeSlot16_18, libraries.get(1));
            checkBooking("David Lam Library",timeSlot16_18, libraries.get(2));
            checkBooking("Asian Library",timeSlot09_12, libraries.get(3));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
