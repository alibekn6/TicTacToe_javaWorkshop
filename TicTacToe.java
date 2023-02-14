// Created by Alibekn.INC;
import java.util.Random;
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
        while (true) {
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter your placement (1-9)");
            int PlayerPos = scanner.nextInt();
            int AIpos = random.nextInt(9)+1;

            place(gameBoard, PlayerPos, "user");
            place(gameBoard, AIpos, "AI");

            printBoard(gameBoard);
        }
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

        if (user.equals("user")) {
            symbol = 'X';
        } else if (user.equals("AI")) {
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
