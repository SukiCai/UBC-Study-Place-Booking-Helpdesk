package studyplace;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import studyplace.library.*;
import studyplace.residencestudyroom.OrchardCommons;
import studyplace.residencestudyroom.PlaceVanier;
import studyplace.residencestudyroom.TotemPark;

import javax.print.attribute.standard.JobSheets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestLibrary {
    Asian asian;
    BiomedicalBranch biomedicalBranch = new BiomedicalBranch();
    DavidLam davidLam = new DavidLam();
    Education education = new Education();
    IrvingKBarberLearning irvingKBarberLearning = new IrvingKBarberLearning();
    Koerner koerner = new Koerner();
    Law law = new Law();
    Woodward woodWard = new Woodward();
    Xwi7xwa xwi7xwa = new Xwi7xwa();
    List<AbstractLibrary> libs = new ArrayList<>();

    OrchardCommons orchardCommons;
    PlaceVanier placeVanier;
    TotemPark totemPark;

    @BeforeEach
    public void runBefore() {
    asian = new Asian();
    biomedicalBranch = new BiomedicalBranch();
    davidLam = new DavidLam();
    education = new Education();
    irvingKBarberLearning = new IrvingKBarberLearning();
    koerner = new Koerner();
    law = new Law();
    woodWard = new Woodward();
    xwi7xwa = new Xwi7xwa();
    libs = new ArrayList<>();

    orchardCommons = new OrchardCommons();
    placeVanier = new PlaceVanier();
    totemPark = new TotemPark();
    }

    @Test
    public void testAvailableTimeForStudyInAsianLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, asian.availableTimeForStudy());
    }

    @Test
    public void testGetNameInAsianLibrary() {
        assertEquals(Asian.NAME, asian.getName());
    }

    @Test
    public void testGetScoreInAsianLibrary() {
        assertEquals(Asian.SCORE, asian.getScore());
    }

    @Test
    public void testGetBooksInAsianLibrary() {
        assertEquals(Asian.BOOKS, asian.getBooks());
    }

    @Test
    public void testGetLocationInAsianLibrary() {
        assertEquals(Asian.LOCATION, asian.getLocation());
    }

    @Test
    public void testGetIntroductionInAsianLibrary() {
        assertEquals(Asian.INTRODUCTION, asian.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInBiomedicalBranchLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, biomedicalBranch.availableTimeForStudy());
    }

    @Test
    public void testGetNameInBiomedicalBranchLibrary() {
        assertEquals(BiomedicalBranch.NAME, biomedicalBranch.getName());
    }

    @Test
    public void testGetScoreInBiomedicalBranchLibrary() {
        assertEquals(BiomedicalBranch.SCORE, biomedicalBranch.getScore());
    }

    @Test
    public void testGetBooksInBiomedicalBranchLibrary() {
        assertEquals(BiomedicalBranch.BOOKS, biomedicalBranch.getBooks());
    }

    @Test
    public void testGetLocationInBiomedicalBranchLibrary() {
        assertEquals(BiomedicalBranch.LOCATION, biomedicalBranch.getLocation());
    }

    @Test
    public void testGetIntroductionInBiomedicalBranchLibrary() {
        assertEquals(BiomedicalBranch.INTRODUCTION, biomedicalBranch.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInDavidLamLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, davidLam.availableTimeForStudy());
    }
    @Test
    public void testGetNameInDavidLamLibrary() {
        assertEquals(DavidLam.NAME, davidLam.getName());
    }

    @Test
    public void testGetScoreInDavidLamLibrary() {
        assertEquals(DavidLam.SCORE, davidLam.getScore());
    }

    @Test
    public void testGetBooksInDavidLamLibrary() {
        assertEquals(DavidLam.BOOKS, davidLam.getBooks());
    }

    @Test
    public void testGetLocationInDavidLamLibrary() {
        assertEquals(DavidLam.LOCATION, davidLam.getLocation());
    }

    @Test
    public void testGetIntroductionInDavidLamLibrary() {
        assertEquals(DavidLam.INTRODUCTION, davidLam.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInEducationLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, education.availableTimeForStudy());
    }

    @Test
    public void testGetNameInEducationLibrary() {
        assertEquals(Education.NAME, education.getName());
    }

    @Test
    public void testGetScoreInEducationLibrary() {
        assertEquals(Education.SCORE, education.getScore());
    }

    @Test
    public void testGetBooksInEducationLibrary() {
        assertEquals(Education.BOOKS, education.getBooks());
    }

    @Test
    public void testGetLocationEducationLibrary() {
        assertEquals(Education.LOCATION, education.getLocation());
    }

    @Test
    public void testGetIntroductionInEducationLibrary() {
        assertEquals(Education.INTRODUCTION, education.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInIKBLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, irvingKBarberLearning.availableTimeForStudy());
    }

    @Test
    public void testGetNameInIKBLibrary() {
        assertEquals(IrvingKBarberLearning.NAME, irvingKBarberLearning.getName());
    }

    @Test
    public void testGetScoreInIKBLibrary() {
        assertEquals(IrvingKBarberLearning.SCORE, irvingKBarberLearning.getScore());
    }

    @Test
    public void testGetBooksInIKBLibrary() {
        assertEquals(IrvingKBarberLearning.BOOKS, irvingKBarberLearning.getBooks());
    }

    @Test
    public void testGetLocationInIKBLibrary() {
        assertEquals(IrvingKBarberLearning.LOCATION, irvingKBarberLearning.getLocation());
    }

    @Test
    public void testGetIntroductionInIKBLibrary() {
        assertEquals(IrvingKBarberLearning.INTRODUCTION, irvingKBarberLearning.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInKoernerLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, koerner.availableTimeForStudy());
    }

    @Test
    public void testGetNameInKoernerLibrary() {
        assertEquals(Koerner.NAME, koerner.getName());
    }

    @Test
    public void testGetScoreInKoernerLibrary() {
        assertEquals(Koerner.SCORE, koerner.getScore());
    }

    @Test
    public void testGetBooksInKoernerLibrary() {
        assertEquals(Koerner.BOOKS, koerner.getBooks());
    }

    @Test
    public void testGetLocationInKoernerLibrary() {
        assertEquals(Koerner.LOCATION, koerner.getLocation());
    }

    @Test
    public void testGetIntroductionInKoernerLibrary() {
        assertEquals(Koerner.INTRODUCTION, koerner.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInLawLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, law.availableTimeForStudy());
    }

    @Test
    public void testGetNameInLawLibrary() {
        assertEquals(Law.NAME, law.getName());
    }

    @Test
    public void testGetScoreInLawLibrary() {
        assertEquals(Law.SCORE, law.getScore());
    }

    @Test
    public void testGetBooksInLawLibrary() {
        assertEquals(Law.BOOKS, law.getBooks());
    }

    @Test
    public void testGetLocationInLawLibrary() {
        assertEquals(Law.LOCATION, law.getLocation());
    }

    @Test
    public void testGetIntroductionInLawLibrary() {
        assertEquals(Law.INTRODUCTION, law.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInWoodwardLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, woodWard.availableTimeForStudy());
    }

    @Test
    public void testGetNameInWoodwardLibrary() {
        assertEquals(Woodward.NAME, woodWard.getName());
    }

    @Test
    public void testGetScoreInWoodwardLibrary() {
        assertEquals(Woodward.SCORE, woodWard.getScore());
    }

    @Test
    public void testGetBooksInWoodwardLibrary() {
        assertEquals(Woodward.BOOKS, woodWard.getBooks());
    }

    @Test
    public void testGetLocationInWoodwardLibrary() {
        assertEquals(Woodward.LOCATION, woodWard.getLocation());
    }

    @Test
    public void testGetIntroductionInWoodwardLibrary() {
        assertEquals(Woodward.INTRODUCTION, woodWard.getIntroduction());
    }

    @Test
    public void testAvailableTimeForStudyInXwi7xwaLibrary() {

        List<String> listAvailableTime = new ArrayList<>();
        listAvailableTime.add("9:00 - 12:00");
        listAvailableTime.add("12:00 - 14:00");
        listAvailableTime.add("14:00 - 16:00");
        listAvailableTime.add("16:00 - 18:00");
        listAvailableTime.add("18:00 - 20:00");

        assertEquals(listAvailableTime, xwi7xwa.availableTimeForStudy());
    }

    @Test
    public void testGetNameInXwi7xwaLibrary() {
        assertEquals(Xwi7xwa.NAME, xwi7xwa.getName());
    }

    @Test
    public void testGetScoreInXwi7xwaLibrary() {
        assertEquals(Xwi7xwa.SCORE, xwi7xwa.getScore());
    }

    @Test
    public void testGetBooksInXwi7xwaLibrary() {
        assertEquals(Xwi7xwa.BOOKS, xwi7xwa.getBooks());
    }

    @Test
    public void testGetLocationInXwi7xwaLibrary() {
        assertEquals(Xwi7xwa.LOCATION, xwi7xwa.getLocation());
    }

    @Test
    public void testGetIntroductionInXwi7xwaLibrary() {
        assertEquals(Xwi7xwa.INTRODUCTION, xwi7xwa.getIntroduction());
    }

    @Test
    public void testGetStudyRoomNameOC() {
        assertEquals(OrchardCommons.STUDY_ROOM_NAME,orchardCommons.getStudyRoomName());
    }

    @Test
    public void testGetStudyRoomNamePV() {
        assertEquals(PlaceVanier.STUDY_ROOM_NAME,placeVanier.getStudyRoomName());
    }

    @Test
    public void testGetStudyRoomNameTP() {
        assertEquals(TotemPark.STUDY_ROOM_NAME,totemPark.getStudyRoomName());
    }

    @Test
    public void testGetLocationTP() {
        assertEquals(TotemPark.LOCATION,totemPark.getLocation());
    }

    @Test
    public void testGetLocationPV() {
        assertEquals(PlaceVanier.LOCATION,placeVanier.getLocation());
    }

    @Test
    public void testGetLocationOC() {
        assertEquals(OrchardCommons.LOCATION,orchardCommons.getLocation());
    }

    @Test
    public void testToJson() {

        AbstractLibrary newLib = new Asian();
        String bookedTimeSlot = "9:00 - 12:00";


        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(bookedTimeSlot);
        newLib.addBookedTimeSlots("9:00 - 12:00");

        json.put("name", "Asian Library");
        json.put("Booked Time", jsonArray);

        assertEquals(json.get("name"),newLib.toJson().get("name"));
        assertEquals(json.get("Booked Time").toString(),newLib.toJson().get("Booked Time").toString());
    }

    @Test
    public void testToString() {

        AbstractLibrary newLib = new Asian();
        String bookedTimeSlot = "9:00 - 12:00";
        newLib.addBookedTimeSlots(bookedTimeSlot);

        String sb = "Asian Library" + "\n" +"Book time: " + bookedTimeSlot;
        assertEquals(sb, newLib.toString());
    }

    @Test
    public void testAddBookedTimeSlots() {
        AbstractLibrary newLib = new Asian();
        assertEquals(0,newLib.getBookedTimeSlots().size());
        newLib.addBookedTimeSlots("9:00 - 12:00");
        List<String> timeSlot = new ArrayList<>();
        timeSlot.add("9:00 - 12:00");
        assertEquals(timeSlot,newLib.getBookedTimeSlots());
    }

    @Test
    public void testGetBookedTimeSlots() {
        AbstractLibrary newLib = new Asian();
        newLib.addBookedTimeSlots("9:00 - 12:00");
        List<String> timeSlot = new ArrayList<>();
        timeSlot.add("9:00 - 12:00");
        assertEquals(timeSlot,newLib.getBookedTimeSlots());
    }

    @Test
    public void testLibraryMapper() {
        LibraryMapper libraryMapper = new LibraryMapper();
        AbstractLibrary library1 = libraryMapper.createLib("Asian Library");
        AbstractLibrary asianLib = new Asian();
        assertEquals(asianLib.getName(),library1.getName());
        assertEquals(asianLib.getIntroduction(),library1.getIntroduction());
        assertEquals(asianLib.getBookedTimeSlots(),library1.getBookedTimeSlots());
        assertEquals(asianLib.getBooks(),library1.getBooks());
        assertEquals(asianLib.getScore(),library1.getScore());
        assertEquals(asianLib.getLocation(),library1.getLocation());

        AbstractLibrary library2 = LibraryMapper.createLib("Biomedical Branch Library");
        AbstractLibrary BBLib = new BiomedicalBranch();
        assertEquals(BBLib.getName(),library2.getName());
        assertEquals(BBLib.getIntroduction(),library2.getIntroduction());
        assertEquals(BBLib.getBookedTimeSlots(),library2.getBookedTimeSlots());
        assertEquals(BBLib.getBooks(),library2.getBooks());
        assertEquals(BBLib.getScore(),library2.getScore());
        assertEquals(BBLib.getLocation(),library2.getLocation());

        AbstractLibrary library3 = LibraryMapper.createLib("David Lam Library");
        AbstractLibrary DavidLamLib = new DavidLam();
        assertEquals(DavidLamLib.getName(),library3.getName());
        assertEquals(DavidLamLib.getIntroduction(),library3.getIntroduction());
        assertEquals(DavidLamLib.getBookedTimeSlots(),library3.getBookedTimeSlots());
        assertEquals(DavidLamLib.getBooks(),library3.getBooks());
        assertEquals(DavidLamLib.getScore(),library3.getScore());
        assertEquals(DavidLamLib.getLocation(),library3.getLocation());

        AbstractLibrary library4 = LibraryMapper.createLib("Education Library");
        AbstractLibrary EducationLib = new Education();
        assertEquals(EducationLib.getName(),library4.getName());
        assertEquals(EducationLib.getIntroduction(),library4.getIntroduction());
        assertEquals(EducationLib.getBookedTimeSlots(),library4.getBookedTimeSlots());
        assertEquals(EducationLib.getBooks(),library4.getBooks());
        assertEquals(EducationLib.getScore(),library4.getScore());
        assertEquals(EducationLib.getLocation(),library4.getLocation());

        AbstractLibrary library5 = LibraryMapper.createLib("Irving K.Barber Learning Center");
        AbstractLibrary IKB = new IrvingKBarberLearning();
        assertEquals(IKB.getName(),library5.getName());
        assertEquals(IKB.getIntroduction(),library5.getIntroduction());
        assertEquals(IKB.getBookedTimeSlots(),library5.getBookedTimeSlots());
        assertEquals(IKB.getBooks(),library5.getBooks());
        assertEquals(IKB.getScore(),library5.getScore());
        assertEquals(IKB.getLocation(),library5.getLocation());

        AbstractLibrary library6 = LibraryMapper.createLib("Koerner Library");
        AbstractLibrary koernerLibrary = new Koerner();
        assertEquals(koernerLibrary.getName(),library6.getName());
        assertEquals(koernerLibrary.getIntroduction(),library6.getIntroduction());
        assertEquals(koernerLibrary.getBookedTimeSlots(),library6.getBookedTimeSlots());
        assertEquals(koernerLibrary.getBooks(),library6.getBooks());
        assertEquals(koernerLibrary.getScore(),library6.getScore());
        assertEquals(koernerLibrary.getLocation(),library6.getLocation());

        AbstractLibrary library7 = LibraryMapper.createLib("Law Library");
        AbstractLibrary lawLibrary = new Law();
        assertEquals(lawLibrary.getName(),library7.getName());
        assertEquals(lawLibrary.getIntroduction(),library7.getIntroduction());
        assertEquals(lawLibrary.getBookedTimeSlots(),library7.getBookedTimeSlots());
        assertEquals(lawLibrary.getBooks(),library7.getBooks());
        assertEquals(lawLibrary.getScore(),library7.getScore());
        assertEquals(lawLibrary.getLocation(),library7.getLocation());

        AbstractLibrary library8 = LibraryMapper.createLib("Woodward Library");
        AbstractLibrary WoodwardLib = new Woodward();
        assertEquals(WoodwardLib.getName(),library8.getName());
        assertEquals(WoodwardLib.getIntroduction(),library8.getIntroduction());
        assertEquals(WoodwardLib.getBookedTimeSlots(),library8.getBookedTimeSlots());
        assertEquals(WoodwardLib.getBooks(),library8.getBooks());
        assertEquals(WoodwardLib.getScore(),library8.getScore());
        assertEquals(WoodwardLib.getLocation(),library8.getLocation());

        AbstractLibrary library9 = LibraryMapper.createLib("Xwi7xwa Library");
        AbstractLibrary xwi7xwa = new Xwi7xwa();
        assertEquals(xwi7xwa.getName(),library9.getName());
        assertEquals(xwi7xwa.getIntroduction(),library9.getIntroduction());
        assertEquals(xwi7xwa.getBookedTimeSlots(),library9.getBookedTimeSlots());
        assertEquals(xwi7xwa.getBooks(),library9.getBooks());
        assertEquals(xwi7xwa.getScore(),library9.getScore());
        assertEquals(xwi7xwa.getLocation(),library9.getLocation());
    }


}
