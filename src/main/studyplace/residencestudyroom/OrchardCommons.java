package studyplace.residencestudyroom;

// A Orchard Common residence with the unique information in it

public class OrchardCommons extends AbstractResidence {
    public static final String STUDY_ROOM_NAME = "Orchard Commons Study Room";
    public static final String LOCATION = "6363 Agronomy Rd";

    @Override
    public String getStudyRoomName() {
        return STUDY_ROOM_NAME;
    }

    @Override
    public String getLocation() {
        return LOCATION;
    }
}
