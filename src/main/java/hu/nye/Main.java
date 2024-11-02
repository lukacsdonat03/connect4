package hu.nye;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Adja meg a nevét");
        Scanner sc = new Scanner(System.in);
        String playerName = sc.nextLine();
       Game game = new Game(6,7,playerName);
       game.start();
    }
}