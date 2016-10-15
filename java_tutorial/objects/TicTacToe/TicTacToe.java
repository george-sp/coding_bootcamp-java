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
                do {
                    System.out.print("\nPlace your mark (input format: row,col)\n> ");
                    input = scanner.nextLine();
                } while (! isValidInput(input));
                row = Integer.parseInt(input.split(",")[0]);
                col = Integer.parseInt(input.split(",")[1]);
            } while (!game.isPlayable(row, col));
            game.play(row, col);
            game.drawBoard();
            game.togglePlayer();
        } while(!game.isBoardFull() && !game.hasWinner());

        System.out.println("Game is over");
        // Close the scanner.
        scanner.close();
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
        // Mark to be set ('X', 'O').
        private char currentMark;
        // Helper strings for the draw function.
        private String newLine;
        private String lineEdge;
        private String lineSeperator;

        public TicTacToeGame(int size) {
            this.boardSize = size;
            this.board = new char[size][size];
            this.currentMark = 'X';
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
         */
        public void play(int x, int y) {
            board[x -1][y -1] = currentMark;
        }

        /**
         * Changes the current mark from 'X' to 'O' and vice versa.
         */
        public void togglePlayer() {
            if (currentMark == 'X') {
                currentMark = 'O';
            }
            else {
                currentMark = 'X';
            }
        }

        /**
         * Checks if the given coordinates are in the board.
         * If they are returns true, otherwise false.
         */
        private boolean isInBounds(int x, int y) {
            if ((x >= 1) && (x <= this.boardSize)) {
                if ((y >= 1) && (y <= this.boardSize)) {
                    return true;
                }
            }
            System.out.println(">>> Missed the board!");
            return false;
        }

        /**
         * Checks if the position targeted by the given coordinates is occupied.
         * If it is return true, otherwise false.
         */
        private boolean isOccupied(int x, int y) {
            if (this.board[x -1][y -1] == '-') return false;
            System.out.println(">>> This cell is occupied!");
            return true;
        }

        /**
         * Combines all the appropriate checks.
         * Returns true if they are passed, otherwise false.
         */
        public boolean isPlayable(int x, int y) {
            if (!isInBounds(x,y) || this.isOccupied(x,y)) return false;
            return true;
        }

        /**
         * Checks if the board is full.
         * Returns true if it is, otherwise false.
         */
        public boolean isBoardFull() {
            for (int i = 0; i < this.boardSize; i++) {
                for (int j = 0; j < this.boardSize; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            System.out.println("The board is full! It is a DRAW!");
            return true;
        }

        /**
         * Checks if the given (three) marks are the same (and not '-').
         *
         */
        private boolean checkRowCol(char c1, char c2, char c3) {
            return ((c1 != '-') && (c1 == c2) && (c2 == c3));
        }

        /**
         * Iterates through rows checking for three in a row.
         * Returns true if either player wins.
         */
        private boolean checkRowsForWin() {
            for (int i = 0; i < this.boardSize; i++) {
                if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Iterates through columns checking for three in a row.
         * Returns true if either player wins.
         */
        private boolean checkColumnsForWin() {
            for (int i = 0; i < 3; i++) {
                if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Checks the two diagonals for three in a row.
         * Returns true if either player wins.
         */
        private boolean checkDiagonalsForWin() {
            return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
        }

        /**
         * Checks if there is a winner.
         * Returns true if there is, else false.
         */
        public boolean hasWinner() {
            if ((checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()) == false) {
                return false;
            }
            System.out.println("The WINNER is: " + currentMark);
            return true;
        }
    }
}