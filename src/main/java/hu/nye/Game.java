package hu.nye;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final GameBoard board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public Game(int row, int col, String name) {
        this.board = new GameBoard(row,col);
        this.player1 = new Player(name , 'X');
        this.player2 = new Player("Opponent", 'O');
        this.currentPlayer = this.player1;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("The game started!");

        this.board.printBoard();

        while(true){
            System.out.println(this.currentPlayer.getName() + "'s turn (" + this.currentPlayer.getDisc() + ")");
            int column;

            if(this.currentPlayer == this.player1){
                System.out.print("Enter column (1-" + (this.board.getColumns()) + "): ");
                column = scanner.nextInt();
            } else {
                column = new Random().nextInt(this.board.getColumns());
                System.out.println("Opponent chooses column " + (column + 1));
            }

            if (this.board.placeDisc(column, this.currentPlayer.getDisc())) {
                this.board.printBoard();
                if (this.board.checkWin(this.currentPlayer.getDisc())) {
                    System.out.println(this.currentPlayer.getName() + " wins!");
                    break;
                }
                switchPlayer();
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
        scanner.close();
    }

    private void switchPlayer(){
        this.currentPlayer = (this.currentPlayer == this.player1) ? this.player2 : this.player1;
    }

    public static int getValidDimension(Scanner sc, String dimensionName, int min, int max) {
        int dimension;
        StringBuilder messageBuilder = new StringBuilder();

        messageBuilder.append("Number of ")
                .append(dimensionName)
                .append(" (")
                .append(min)
                .append(" <= ")
                .append(dimensionName)
                .append(" <= ")
                .append(max)
                .append("): ");

        String promptMessage = messageBuilder.toString();

        while (true) {
            System.out.print(promptMessage);
            dimension = sc.nextInt();

            if (dimension >= min && dimension <= max) {
                break;
            } else {
                System.out.println("Invalid input. " + dimensionName + " must be between " + min + " and " + max + ".");
            }
        }
        return dimension;
    }



}
