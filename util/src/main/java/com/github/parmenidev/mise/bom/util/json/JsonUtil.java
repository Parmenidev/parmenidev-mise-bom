package com.github.parmenidev.mise.bom.util.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public <T> String getJson(final T object){
        String json;
        try {
            json = objectMapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            throw new RuntimeException();
        }
        return json;
    }

    public static <T> T mapJsonToObject(final String json, Class<T> outputClass){
        T object;
        try{
            object = objectMapper.readValue(json, outputClass);
        }catch (JsonProcessingException e){
            throw new RuntimeException();
        }
        return object;
    }

    public static <T> T mapJsonToObject(final String json, TypeReference<T> typeReference){
        T object;
        try{
            object = objectMapper.readValue(json, typeReference);
        }catch (JsonProcessingException e){
            throw new RuntimeException();
        }
        return object;
    }

}
