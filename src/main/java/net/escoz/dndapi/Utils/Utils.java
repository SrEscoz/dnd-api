package net.escoz.dndapi.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class Utils {

    public static String objectToJson(Object object) {
        try {
            ObjectWriter objectWriter = new ObjectMapper().writer();
            return objectWriter.writeValueAsString(object);

        } catch (JsonProcessingException exception) {
            return "Error en (objectToJson)";
        }
    }

}
