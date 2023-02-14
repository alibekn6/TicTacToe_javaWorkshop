// Created by Alibekn.INC;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printBoard(gameBoard);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your placement (1-9)");
        int pos = scanner.nextInt();

        System.out.println(pos);

        place(gameBoard, pos, "player");
        printBoard(gameBoard);
    }

    public static void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void place(char[][] gameBoard, int pos, String user) {
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("CPU")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1 -> gameBoard[0][0] = symbol;
            case 2 -> gameBoard[0][2] = symbol;
            case 3 -> gameBoard[0][4] = symbol;
            case 4 -> gameBoard[2][0] = symbol;
            case 5 -> gameBoard[2][2] = symbol;
            case 6 -> gameBoard[2][4] = symbol;
            case 7 -> gameBoard[4][0] = symbol;
            case 8 -> gameBoard[4][2] = symbol;
            case 9 -> gameBoard[4][4] = symbol;
        }
    }
}
