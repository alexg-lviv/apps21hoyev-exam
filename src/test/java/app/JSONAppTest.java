package app;

import json.Json;
import json.Tuple;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import static org.junit.Assert.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class JSONAppTest {
    @Test
    public void testSessionResult() throws Exception {
        Json jsonObject = JSONApp.sessionResult();

        String expectedJSON =
                "{'name': 'Oleksiy', 'surname': 'Hoyev', 'year': 2, 'exams': [" +
                        "{'course': 'OOP', 'mark': 5, 'passed': true}," +
                        "{'course': 'English', 'mark': 4, 'passed': true}," +
                        "{'course': 'Math', 'mark': 0, 'passed': false}" +
                        "]}";

        JSONAssert.assertEquals(expectedJSON, jsonObject.toJson(), true);
    }
}