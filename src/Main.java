import java.util.*;


public class Main {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> compPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        printBoard(board);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter (1-9) : ");

            int playerPos = scanner.nextInt();

            while (playerPositions.contains(playerPos) || compPositions.contains(playerPos)) {
                System.out.println("Position taken!");
                playerPos = scanner.nextInt();
            }
            System.out.println(playerPos);
            placePiece(board, playerPos, "player");
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            Random random = new Random();
            int compPos = random.nextInt(9) + 1;
            while (playerPositions.contains(compPos) || compPositions.contains(compPos)) {
                compPos = random.nextInt(9) + 1;
            }


            placePiece(board, compPos, "computer");
            printBoard(board);

            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }

    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println("---------");
            for (char c : row) {
                System.out.print("|");
                System.out.print(c);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] board, int pos, String user) {
        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("computer")) {
            symbol = 'O';
            compPositions.add(pos);
        }
        int row = (pos-1) / 3;
        int col = (pos-1) % 3;

        board[row][col] = symbol;
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3); //comment
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
            if (playerPositions.containsAll(l)) {
                return "Congratulations! you won";
            } else if (compPositions.containsAll(l)) {
                return "Computer wins!!!";
            } else if (playerPositions.size() + compPositions.size() == 9) {
                return "draw / tie";
            }
        }

        return "";

    }

}