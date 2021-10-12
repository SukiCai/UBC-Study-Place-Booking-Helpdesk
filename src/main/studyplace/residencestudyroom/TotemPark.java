package studyplace.residencestudyroom;

// A Totem Park residence with the unique information in it

public class TotemPark extends AbstractResidence {
    public static final String STUDY_ROOM_NAME = "Totem Park Study Room";
    public static final String LOCATION = "2525 West Mall";

    @Override
    public String getStudyRoomName() {
        return STUDY_ROOM_NAME;
    }

    @Override
    public String getLocation() {
        return LOCATION;
    }
}
