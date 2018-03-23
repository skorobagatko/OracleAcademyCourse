package com.skorobahatko.lectures.lecture1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Clothing clothing = new Shirt("Shirt", 100);
        clothing.wash();

        Shape.Color color = new Shape.Color(230, 230,120);
        System.out.println(color);

        Circle.Point point = new Circle(10, 20).new Point();
        System.out.println(point.getSuperSecretCode());

        List<String> list = new ArrayList<>();
        list.add("Vasay");
        list.add("Pedro");
        list.add("Huan");
        list.add("Estebal");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list);

        Day myDay = Day.MONDAY;
        System.out.println(myDay.name() + " is " + myDay.getDayNumber() + " day in week");

        myDay = Day.valueOf("TUESDAY");
        System.out.println(myDay.name() + " is " + myDay.getDayNumber() + " day in week");

        System.out.println(Day.getDayByNumberMap(2));
    }
}
