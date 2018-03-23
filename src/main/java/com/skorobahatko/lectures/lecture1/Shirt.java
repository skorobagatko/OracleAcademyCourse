package com.skorobahatko.lectures.lecture1;

public class Shirt extends Clothing {

    public Shirt(String name, int price) {
        super(name, price);
    }

    @Override
    public void wash() {
        System.out.println("Shirt is washed");
    }
}
