package com.skorobahatko.practices.practice5.serialization;

import java.io.*;

public class GroupSerializer {

    public static void serializeGroup(String path, Group group) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Group getGroup(String path) {
        Group group = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            group = (Group) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return group;
    }
}
