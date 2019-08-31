import game.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        TicTacToe game = new TicTacToe(reader);
        game.start();
    }
}
