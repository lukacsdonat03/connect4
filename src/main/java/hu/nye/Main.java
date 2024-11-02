package hu.nye;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameInitializer initializer = new GameInitializer(sc);

        Game game = initializer.initializeGame();
        game.start();

        sc.close();
    }
}