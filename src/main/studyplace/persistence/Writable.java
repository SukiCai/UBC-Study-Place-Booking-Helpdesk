package studyplace.persistence;

import org.json.JSONObject;

// cite from JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
