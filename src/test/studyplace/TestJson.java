package studyplace;

import studyplace.library.AbstractLibrary;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// cite from JsonSerializationDemo

public class TestJson {
    protected void checkBooking(String name, List<String> timeSlot, AbstractLibrary library) {
        assertEquals(name, library.getName());
        assertEquals(timeSlot, library.getBookedTimeSlots());
    }
}
