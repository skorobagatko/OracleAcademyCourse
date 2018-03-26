package com.skorobahatko.lectures.lecture6;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String src = "./src/main/resources/text.txt";
        String dst = "./src/main/resources/textCopy.txt";
        copyText(src, dst, "UTF-8", "windows-1251");
        copyTextBuffered(src, dst);
        copyFileByBytes(src, dst);

        try (DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("./src/main/resources/data.txt"));
        DataInputStream dataIn = new DataInputStream(new FileInputStream("./src/main/resources/data.txt"))) {
            dataOut.writeDouble(25.38);
            dataOut.writeLong(14578975646466456L);
            dataOut.writeUTF("Some string");

            System.out.println(dataIn.readDouble());
            System.out.println(dataIn.readLong());
            System.out.println(dataIn.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Human human1 = new Human("John", "qwerty", 25);
        Human human2 = new Human("Bob", "i'm_from_texas", 30);
        saveObjectToFile("./src/main/resources/objects", human1, human2);
        loadObjectFromFile("./src/main/resources/objects").forEach(System.out::println);

        Map<String, String> propertiesMap = new HashMap<>();
        propertiesMap.put("domain", "www.mydomain.com");
        propertiesMap.put("login", "Donald");
        propertiesMap.put("password", "Trump");
        PropertyUtils.saveProperty("./src/main/resources/properties", propertiesMap);
        System.out.println(PropertyUtils.loadProperties("./src/main/resources/properties"));

        // JSON Test
        String json = JSONUtils.createJSON(human1);
        System.out.println(json);
        Human copy = JSONUtils.parseJSON(json, Human.class);
        System.out.println(copy);
    }

    public static void copyText(String src, String dst, String srcCharset, String dstCharset) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(src), srcCharset);
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(dst), dstCharset)) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyTextBuffered(String src, String dst) {
        try (BufferedReader reader = new BufferedReader(new FileReader(src));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dst))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFileByBytes(String src, String dst) {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dst)) {
            byte[] buff = new byte[1024];
            int byteCounter = 0;
            while((byteCounter = in.read(buff)) != -1 ) {
                out.write(buff, 0, byteCounter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends Serializable> void saveObjectToFile(String file, T... objects) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            for (T object : objects) {
                oos.writeObject(object);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Serializable> List<T> loadObjectFromFile(String file) {
        List<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            T object = null;
            while ((object = (T) ois.readObject()) != null) {
                list.add(object);
            }
        } catch (EOFException e) {
            // NOP
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
