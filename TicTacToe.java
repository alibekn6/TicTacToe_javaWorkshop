// Created by Alibekn.INC;

import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToe {
    static ArrayList<Integer> PlayerPosition = new ArrayList<Integer>();

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
            int AIpos = random.nxtInt(9)+1;

            place(gameBoard, PlayerPos, "user");
            place(gameBoard, AIpos, "AI");

            printBoard(gameBoard);
            checkWinner();
            scanner.close();
        }


    }

    public static void printBoard(char[][] geameBoard) {
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

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9); 

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (PlayerPosition.containsAll(l)) {
                return "Congratulations you won!";
            } else if (AIPositions.contains(l)) {
                return "AI wins!";
            } else if (playerPosition.size() + AIPositions.size() == 9) {
                return "CAT";
            }
        }


        return "";        
    }
}
