package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {
    private final boolean state;
    public JsonBoolean(Boolean bool) {
        state = bool;
    }

    @Override
    public String toJson() {
        if(state){
            return "true";
        }
        else{
            return "false";
        }
    }
}
