package game;

import java.util.Scanner;

public class TicTacToe {

    // Private Variables
    private Scanner reader;
    private int row = 3;
    private int column = 3;
    private char[][] board = new char[row][column];
    private int player = 1;

    public TicTacToe(Scanner reader) {
        // Creating scanner from constructor
        this.reader = reader;
    }

    public void start() {
        // Using a try-catch statement for Thread.sleep()
        try {
            // Print opening messages with delays for the users to read
            System.out.println();
            System.out.println("           Welcome to Tic Tac Toe!");
            System.out.println();
            System.out.println("When it's your turn, enter where you want to go");
            System.out.println("using the format \"top-middle\", \"bottom-left\", etc.");
            System.out.println("Player 1 is X and player 2 is O");
            Thread.sleep(9000);
            System.out.println();
            System.out.println("Starting in 3");
            Thread.sleep(1000);
            System.out.println("Starting in 2");
            Thread.sleep(1000);
            System.out.println("Starting in 1");
            Thread.sleep(1000);
            System.out.println();
        } catch (Exception e) {
            System.out.println("Something bad happened... oops.");
        }

        int turn = 0;

        while (turn < 9) {
            printBoard();

            int r;
            int c;
            // Assign a position on the 2-D Grid, unless the position given was wrong
            do {
                System.out.print("Player " + player + ": ");
                String position = reader.nextLine();
                r = getPosition(position)[0];
                c = getPosition(position)[1];
                if (r == -1)
                    System.out.println("Command Not Recognized!");
            } while (r == -1);

            // Add the player's char
            if (player == 1)
                board[r][c] = 'X';
            else
                board[r][c] = 'O';

            // Check winning conditions
            if (whoWon() == 'X') {
                System.out.println();
                printBoard();
                System.out.println("Congratulations, player 1, YOU WON!");
                break;
            } else if (whoWon() == 'O') {
                System.out.println();
                printBoard();
                System.out.println("Congratulations, player 2, YOU WON!");
                break;
            } else {
                System.out.println();
            }

            switchTurns();

            turn++;
        }

        // If tie, print board again and say it's a tie
        if (whoWon() == ' ') {
            printBoard();
            System.out.println("The game is a tie!");
        }
    }

    private void printBoard() {
        // Go through each value in the 2-D grid and print it out
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < column; x++) {
                if (x != 2)
                    System.out.print(board[y][x] + "|");
                else
                    System.out.print(board[y][x]);
            }
            if (y != 2)
                System.out.println("\n-----");
            else
                System.out.println();
        }
        System.out.println();
    }

    private void switchTurns() {
        if (player == 1)
            player = 2;
        else
            player = 1;
    }

    private int[] getPosition(String position) {
        // I'm using an array to store the row and column values for the given command
        // because I need to return two numbers.
        int[] rowAndColumn = new int[2];

        // Checking all position commands and assigning the array the row and column number
        switch (position) {
            case "top-left":
                rowAndColumn[0] = 0;
                rowAndColumn[1] = 0;
                break;

            case "top-middle":
                rowAndColumn[0] = 0;
                rowAndColumn[1] = 1;
                break;

            case "top-right":
                rowAndColumn[0] = 0;
                rowAndColumn[1] = 2;
                break;

            case "middle-left":
                rowAndColumn[0] = 1;
                rowAndColumn[1] = 0;
                break;

            case "middle-middle":
                rowAndColumn[0] = 1;
                rowAndColumn[1] = 1;
                break;

            case "middle-right":
                rowAndColumn[0] = 1;
                rowAndColumn[1] = 2;
                break;

            case "bottom-left":
                rowAndColumn[0] = 2;
                rowAndColumn[1] = 0;
                break;

            case "bottom-middle":
                rowAndColumn[0] = 2;
                rowAndColumn[1] = 1;
                break;

            case "bottom-right":
                rowAndColumn[0] = 2;
                rowAndColumn[1] = 2;
                break;

            default:
                rowAndColumn[0] = -1;
                break;
        }
        return rowAndColumn;
    }

    private char whoWon() {
        char who = ' ';

        // Check all possible win scenarios for both X and O players
        if (board[0][0] == 'X' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            who = 'X';
        } else if (board[0][0] == 'O' && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            who = 'O';
        } else if (board[1][0] == 'X' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            who = 'X';
        } else if (board[1][0] == 'O' && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            who = 'O';
        } else if (board[2][0] == 'X' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            who = 'X';
        } else if (board[2][0] == 'O' && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            who = 'O';
        } else if (board[0][0] == 'X' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            who = 'X';
        } else if (board[0][0] == 'O' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            who = 'O';
        } else if (board[0][2] == 'X' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            who = 'X';
        } else if (board[0][2] == 'O' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            who = 'O';
        } else if (board[0][0] == 'X' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            who = 'X';
        } else if (board[0][0] == 'O' && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            who = 'O';
        } else if (board[0][1] == 'X' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            who = 'X';
        } else if (board[0][1] == 'O' && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            who = 'O';
        } else if (board[0][2] == 'X' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            who = 'X';
        } else if (board[0][2] == 'O' && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            who = 'O';
        }
        // This is probably not the most efficient way to find possible solutions, but at least it works...
        return who;
    }
}
