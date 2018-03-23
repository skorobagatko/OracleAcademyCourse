package com.skorobahatko.lectures.lecture4;

public class App {

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("1", 2);
        System.out.println(pair);

        Buyer<Pair<String, Integer>> buyer = new Buyer<>("Vasay", 20);
        buyer.addToBasket(new Pair<>("Milk", 20));

        String s = buyer.printArray(new String[]{"Pedro", "Huan"});
        System.out.println(s);

        String s1 = buyer.printArray(new Integer[]{1, 2});
        System.out.println(s1);


        Human<String> human = new Human<>("Vasay", String.class);
    }
}
