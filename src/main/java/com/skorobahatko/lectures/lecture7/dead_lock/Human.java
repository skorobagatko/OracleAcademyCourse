package com.skorobahatko.lectures.lecture7.dead_lock;

public class Human extends Thread {

    private Phone phone;
    private Human friend;

    public Human() {
    }

    public Human(Phone phone, Human friend) {
        this.phone = phone;
        this.friend = friend;
    }

    @Override
    public void run() {
        callFriend();
    }

    public void callFriend() {
        phone.call(friend.phone);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Human getFriend() {
        return friend;
    }

    public void setFriend(Human friend) {
        this.friend = friend;
    }
}
