package hu.nye;

import java.util.Scanner;

public class GameInitializer {

    private final Scanner sc;

    public GameInitializer(Scanner sc) {
        this.sc = sc;
    }

    public Game initializeGame() {
        String playerName = promptForPlayerName();
        Game game = loadGameOrSetupNewGame(playerName);
        return game;
    }

    private String promptForPlayerName() {
        System.out.print("Type the name of the player: ");
        return sc.nextLine();
    }

    private Game loadGameOrSetupNewGame(String playerName) {
        System.out.print("Do you want to load a game from a file? (yes/no): ");
        String loadResponse = sc.nextLine().trim().toLowerCase();

        if (loadResponse.equals("yes")) {
            System.out.print("Enter the filename: ");
            String filename = sc.nextLine();
            Game loadedGame = new Game(playerName, filename);

            if (loadedGame.getBoard() != null) {
                return loadedGame;
            } else {
                System.out.println("The given file was not found or could not be loaded.");
            }
        }

        int rows = Game.getValidDimension(sc, "rows", 4, 12);
        int cols = Game.getValidDimension(sc, "columns", 4, rows);
        return new Game(rows, cols, playerName);
    }

}
