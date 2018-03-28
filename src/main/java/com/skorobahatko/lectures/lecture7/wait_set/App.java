package com.skorobahatko.lectures.lecture7.wait_set;

public class App {

    public static void main(String[] args) {

        Clock clock = new Clock();

        ChessMan chessMan1 = new ChessMan("John", Color.WHITE, clock);
        ChessMan chessMan2 = new ChessMan("Bob", Color.BLACK, clock);
        new Thread(chessMan1).start();
        new Thread(chessMan2).start();


    }

}
