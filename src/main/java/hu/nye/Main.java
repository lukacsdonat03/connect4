package hu.nye;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Type the name of the player: ");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
        System.out.println();

        // get the number of rows and columns from user
        int rows = Game.getValidDimension(sc, "rows", 4, 12);
        int cols = Game.getValidDimension(sc, "columns", 4, rows);

        System.out.println();
        Game game = new Game(rows, cols, playerName);
        game.start();
    }
}