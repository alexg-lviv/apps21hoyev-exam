package domain;

import json.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private JsonObject exams[];
    private String name;
    private String surname;
    private Integer year;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = new JsonObject[exams.length];
        for (int i=0; i < exams.length; i++) {
            JsonBoolean bool;
            if(exams[i].value >= 3){
                bool = new JsonBoolean(true);
            }
            else{
                bool = new JsonBoolean(false);
            }
            JsonObject tempObj = new JsonObject(new JsonPair("course", new JsonString(exams[i].key)),
                    new JsonPair("mark", new JsonNumber(exams[i].value)),
                    new JsonPair("passed", bool));
            this.exams[i] = tempObj;
        }
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject(new JsonPair("name", new JsonString(name)),
                new JsonPair("surname", new JsonString(surname)),
                new JsonPair("year", new JsonNumber(year)),
                new JsonPair("exams", new JsonArray(exams))
        );
        return jsonObject;
    }
}