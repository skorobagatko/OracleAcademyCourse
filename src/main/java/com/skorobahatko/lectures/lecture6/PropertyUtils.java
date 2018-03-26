package com.skorobahatko.lectures.lecture6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertyUtils {

    public static void saveProperty(String path, Map<String, String> propertiesMap) {
        Properties properties = new Properties();
        propertiesMap.forEach((k, v) -> properties.setProperty(k, v));
        try {
            properties.store(new FileOutputStream(path), "properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> loadProperties(String path) {
        Map<String, String> propertiesMap = new HashMap<>();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Map.Entry<Object, Object> entry : properties.entrySet()) {
            propertiesMap.put((String) entry.getKey(), (String) entry.getValue());
        }
        return propertiesMap;
    }
}
