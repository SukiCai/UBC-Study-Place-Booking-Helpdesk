package studyplace;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import studyplace.library.AbstractLibrary;
import studyplace.library.BiomedicalBranch;
import studyplace.library.DavidLam;
import studyplace.store.Booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBooking {
    Booking booking;

    @BeforeEach
    void runBefore() {
        booking = new Booking("suki");
    }

    @Test
    void TestGetBookingName() {
        assertEquals("suki", booking.getBookingName());
    }

    @Test
    void TestAddLibrary() {
        assertEquals(0,booking.getLibraries().size());
        AbstractLibrary newLib1 = new DavidLam();
        AbstractLibrary newLib2 = new BiomedicalBranch();
        booking.addLibrary(newLib1);
        booking.addLibrary(newLib2);
        assertEquals(newLib1,booking.getLibraries().get(0));
        assertEquals(newLib2,booking.getLibraries().get(1));
    }

    @Test
    void TestNumLibraries() {
        assertEquals(0,booking.getLibraries().size());
        AbstractLibrary newLib1 = new DavidLam();
        AbstractLibrary newLib2 = new BiomedicalBranch();
        booking.addLibrary(newLib1);
        booking.addLibrary(newLib2);
        assertEquals(2,booking.numLibraries());
    }

    @Test
    void TestGetLibraries() {
        AbstractLibrary newLib1 = new DavidLam();
        booking.addLibrary(newLib1);
        assertEquals(newLib1,booking.getLibraries().get(0));
    }

    @Test
    void TestToJson() {
        JSONArray jsonArray = new JSONArray();
        AbstractLibrary newLib1 = new DavidLam();
        newLib1.addBookedTimeSlots("14:00 - 16:00");
        AbstractLibrary newLib2 = new BiomedicalBranch();
        newLib2.addBookedTimeSlots("12:00 - 14:00");
        booking.addLibrary(newLib1);
        booking.addLibrary(newLib2);
        jsonArray.put(newLib1.toJson());
        jsonArray.put(newLib2.toJson());

        JSONObject json = new JSONObject();
        json.put("name", "suki");
        json.put("libraries", jsonArray);

        JSONObject json2 = booking.toJson();

        System.out.println(json2);

        assertEquals("suki", json2.get("name"));
        assertEquals(jsonArray.get(0).toString(), json2.getJSONArray("libraries").get(0).toString());
        assertEquals(jsonArray.get(1).toString(), json2.getJSONArray("libraries").get(1).toString());

    }




    }

