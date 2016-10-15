import java.util.Scanner;

/**
 * Exercise5 - https://codeandwork.github.io/courses/java/objects.html
 * Implement a tic tac toe (triliza) game which is played by two players.
 */
public class TicTacToe {
    public static void main(String[] args) {
        // Welcome message.
        System.out.println("Welcome to TicTacToe!");
        // Declare and initialize a simple text scanner.
        Scanner scanner = new Scanner(System.in);

        TicTacToe ticTacToe = new TicTacToe();
        TicTacToeGame game = ticTacToe.new TicTacToeGame(3);

        game.setUp();
        game.drawBoard();
        String input;
        int row, col;
        do {
            do {
                System.out.print("Place your mark\n(input format: row,col)\n> ");
                input = scanner.nextLine();
            } while (! isValidInput(input));
            row = Integer.parseInt(input.split(",")[0]);
            col = Integer.parseInt(input.split(",")[1]);
            game.play(row, col);
            game.drawBoard();
        }while (true);

        // Close the scanner.
        // scanner.close();
    }

    /**
     * Checks if the given string input is of format x,y.
     * Returns true if it is, else false.
     */
    private static boolean isValidInput(String input) {
        String[] inputSplit = input.split(",");
        if (inputSplit.length != 2) {
            return false;
        }
        if (! (isNumeric(inputSplit[0]) && isNumeric(inputSplit[1]))) return false;
        return true;
    }

    /**
     * Checks if string input is a numeric value.
     * Returns true if it is, else returns false.
     */
    private static boolean isNumeric(String input) {
        if (! input.matches("[0-9]+")) return false;
        return true;
    }

    /**
     * The actual tic tac toe game.
     */
    private class TicTacToeGame {
        // Use a two dimensions array to store the results ('X', 'O').
        private char[][] board;
        // The size of board's dimensions.
        private int boardSize;
        // Helper strings for the draw function.
        private String newLine;
        private String lineEdge;
        private String lineSeperator;

        public TicTacToeGame(int size) {
            this.boardSize = size;
            this.board = new char[size][size];
        }

        /**
         * Sets up the game.
         */
        public void setUp() {
            generateBoard(this.boardSize);
            generateLineFrames(this.boardSize);
        }

        /**
         * Genrates a two dimensions array with '-'.
         */
        private void generateBoard(int size) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.board[i][j] = '-';
                }
            }
        }

        /**
         * Generate the line seperators, based on the size of the board.
         */
        private void generateLineFrames(int size) {
            this.newLine = "\n";
            this.lineEdge = "-";
            this.lineSeperator = "-";
            // Generate the lineSeperator.
            for (int j = 0; j < size; j++) {
                this.lineEdge += "----";
                if (j == size - 1) this.lineSeperator += "----";
                else this.lineSeperator += "---+";
            }
        }

        /**
         * Prints the current tic tac toe's status.
         */
        public void drawBoard() {
            System.out.println(this.lineEdge);
            for (int i = 0; i < this.boardSize; i++) {
                System.out.print("| ");
                for (int j = 0; j < this.boardSize; j++) {
                    System.out.print(board[i][j] + " | ");
                }
                System.out.print(newLine);
                if (i == this.boardSize - 1) System.out.println(this.lineEdge);
                else System.out.println(this.lineSeperator);
            }
        }

        /**
         * Places the appropriate mark at the specified x,y coordinates.
         * Returns true if a mark is placed, else false;
         */
        public boolean play(int x, int y) {
            if (areInBounds(x, y)) {
                board[x -1][y -1] = 'X';
                return true;
            }
            return false;
        }

        /**
         * Checks if the given coordinates are in the board.
         * If they are returns true, otherwise false.
         */
        public boolean areInBounds(int x, int y) {
            if ((x >= 1) && (x <= this.boardSize)) {
                if ((y >= 1) && (y <= this.boardSize)) {
                    return true;
                }
            }
            return false;
        }
    }
}