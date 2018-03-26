package com.skorobahatko.lectures.lecture6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

public class JSONUtils {

    public static <T extends Serializable> String createJSON(T obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    public static <T extends Serializable> T parseJSON(String json, Class<T> clazz) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, clazz);
    }
}
