package com.prodyna.dataprotection.navigator.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private JsonUtils() {
    }

    public static String toJson(Object object) throws IOException {
        return OBJECT_MAPPER.writeValueAsString(object);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) throws IOException {
        return OBJECT_MAPPER.readValue(json, classOfT);
    }
}
