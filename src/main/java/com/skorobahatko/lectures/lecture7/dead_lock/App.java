package com.skorobahatko.lectures.lecture7.dead_lock;

public class App {

    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human();

        human1.setPhone(new Phone(12345));
        human1.setFriend(human2);

        human2.setPhone(new Phone(67890));
        human2.setFriend(human1);

        human1.start();
        human2.start();
    }
}
