package studyplace.residencestudyroom;

// A Place Vanier residence with the unique information in it

public class PlaceVanier extends AbstractResidence {
    public static final String STUDY_ROOM_NAME = "Place Vanier Study Room";
    public static final String LOCATION = "1935 Lower Mall";


    @Override
    public String getStudyRoomName() {
        return STUDY_ROOM_NAME;
    }

    @Override
    public String getLocation() {
        return LOCATION;
    }
}
