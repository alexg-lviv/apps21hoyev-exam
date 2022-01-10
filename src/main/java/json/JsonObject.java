package json;


import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    HashMap<String, Json> contents;
    HashMap<String, String> contentsStr;

    public JsonObject(JsonPair... jsonPairs) {
        contents = new HashMap<>();
        contentsStr = new HashMap<>();
        for (JsonPair pair :
                jsonPairs) {
            contents.put(pair.key, pair.value);
            contentsStr.put(pair.key, pair.value.toJson());
        }
    }

    @Override
    public String toJson() {
        return contentsStr.toString();
    }

    public void add(JsonPair jsonPair) {
        contents.put(jsonPair.key, jsonPair.value);
        contentsStr.put(jsonPair.key, jsonPair.value.toJson());
    }

    public Json find(String name) {
        return contents.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject projection = new JsonObject();
        for (String name :
                names) {
            if (contents.get(name) != null) {
                projection.add(new JsonPair(name, contents.get(name)));
            }
        }
        return projection;
    }
}
