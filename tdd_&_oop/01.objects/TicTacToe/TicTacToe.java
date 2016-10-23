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
        // Instantiate a TicTacToe class, to get access to its private TicTacToeGame class.
        TicTacToe ticTacToe = new TicTacToe();
        // Declare the actual game object.
        TicTacToeGame game;
        // User inputs.
        String input;
        int row, col;

        /*
         * Game Logic
         */
        do {
            do {
                System.out.print("\nSet the dimensions of tic tac toe board (suggested [3-12))\n> ");
                input = scanner.nextLine();
            } while (! (isNumeric(input) && isValidBoardSize(input)));
            game = ticTacToe.new TicTacToeGame(Integer.parseInt(input));
            game.setUp();
            game.drawBoard();
            do {
                game.togglePlayer();
                do {
                    do {
                        System.out.print("\n" + game.getCurrentMark() + " Place your mark (input format: row,col)\n> ");
                        input = scanner.nextLine();
                    } while (! isValidMark(input));
                    row = Integer.parseInt(input.split(",")[0]);
                    col = Integer.parseInt(input.split(",")[1]);
                } while (!game.isPlayable(row, col));
                game.play(row, col);
                game.drawBoard();
            } while(!game.isOver());
            System.out.println("Game is over");
            do {
                System.out.print("\nPlay Again? (y-N)\n> ");
                input = scanner.nextLine();
            } while (! isValidYesOrNo(input));
        } while (isYesAnswer(input));


        // Close the scanner.
        // scanner.close();
    }

    /**
     * Checks if the given string input is of format x,y.
     * Returns true if it is, else false.
     */
    private static boolean isValidMark(String input) {
        String[] inputSplit = input.split(",");
        if (inputSplit.length != 2) return false;
        if (! hasSingleComma(input)) return false;
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
     * Checks if the user input has one and only one comma symbol ','.
     * Returns true if it has only one, else false.
     */
    private static boolean hasSingleComma(String input) {
        int commaCounter = 0;
        for( int i = 0; i < input.length(); i++ ) {
            if(input.charAt(i) == ',' ) {
                commaCounter++;
            }
        }
        return true ? commaCounter == 1 : false;
    }

    /**
     * Checks if the given number is valid as a tic tac toe boarder dimension (bigger than 3).
     * Returns true if it is, else false.
     */
    private static boolean isValidBoardSize(String input) {
        if (Integer.parseInt(input) >= 3) return true;
        return false;
    }

    /**
     * Checks if users answered yes or no.
     * Returns true if the answer is "y" or "N", else false.
     */
    private static boolean isValidYesOrNo(String input) {
        if (input.length() != 1) return false;
        if (! (input.charAt(0) == 'y' || input.charAt(0) == 'N')) return false;
        return true;
    }

    /**
     * Returns true if answer is 'y' or
     * false if is 'N'.
     */
    private static boolean isYesAnswer(String input) {
        return true ? input.charAt(0) == 'y' : false;
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
        // Indicates the winner of the game.
        private char winner;
        // Helper strings for the draw function.
        private String newLine;
        private String lineEdge;
        private String lineSeperator;

        /* Constructor */
        public TicTacToeGame(int size) {
            this.boardSize = size;
            this.board = new char[size][size];
            this.currentMark = 'O';
        }

        /* Setters & Getters*/
        public void setBoardSize(int size) {
            this.boardSize = size;
        }

        public int getBoardSize() {
            return this.boardSize;
        }

        public void setCurrentMark(char mark) {
            this.currentMark = mark;
        }

        public char getCurrentMark() {
            return this.currentMark;
        }

        public void setWinner(char winnerMark) {
            this.winner = winnerMark;
        }

        public char getWinner() {
            return this.winner;
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
            if (this.currentMark == 'X') {
                this.setCurrentMark('O');
            }
            else {
                this.setCurrentMark('X');
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
            if (!this.isInBounds(x,y) || this.isOccupied(x,y)) return false;
            return true;
        }

        /**
         * Checks if the board is full.
         * Returns true if it is, otherwise false.
         */
        private boolean isBoardFull() {
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
                for (int j = 0; j < this.boardSize - 2; j++) {
                    if (this.checkRowCol(this.board[i][j], this.board[i][j + 1], this.board[i][j + 2]) == true) {
                        System.out.println((i) + "," + (j) + "-" + (i) + "," + (j+1) + "-" + (i) + "," + (j+2));
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Iterates through columns checking for three in a row.
         * Returns true if either player wins.
         */
        private boolean checkColumnsForWin() {
            for (int j = 0; j < this.boardSize; j++) {
                for (int i = 0; i < this.boardSize - 2; i++) {
                    if (this.checkRowCol(this.board[i][j], this.board[i + 1][j], this.board[i + 2][j]) == true) {
                        System.out.println((i) + "," + (j) + "-" + (i+1) + "," + (j) + "-" + (i+2) + "," + (j));
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Checks the two diagonals for three in a row.
         * Returns true if either player wins.
         */
        private boolean checkDiagonalsForWin() {
            for (int i = 0; i < this.boardSize - 2; i++) {
                for (int j = i; j < this.boardSize - 2; j++) {
                    if (this.checkRowCol(this.board[i][j], this.board[i+1][j+1], this.board[i+2][j+2]) == true) {
                        System.out.println((i+1) + "," + (j+1) + "-" + (i+1+1) + "," + (j+1+1) + "-" + (i+2+1) + "," + (j+2+1));
                        return true;
                    }
                }
                for (int j = i; j < this.boardSize - 3; j++) {
                    if (this.checkRowCol(this.board[j+1][i], this.board[j+2][i+1], this.board[j+3][i+2]) == true) {
                        System.out.println((j+1+1) + "," + (i+1) + "-" + (j+2+1) + "," + (i+1+1) + "-" + (j+3+1) + "," + (i+2+1));
                        return true;
                    }
                }
                for (int j = this.boardSize - 1; j > i + 1; j--) {
                    if (this.checkRowCol(this.board[i][j-i], this.board[i+1][j-i-1], this.board[i+2][j-i-2]) == true) {
                        System.out.println((i+1) + "," + (j-i+1) + "-" + (i+1+1) + "," + (j-i-1+1) + "-" + (i+2+1) + "," + (j-i-2+1));
                        return true;
                    }
                }
                for (int j = this.boardSize - 1; j > i + 2; j--) {
                    if (this.checkRowCol(this.board[j-2][this.boardSize-i-1], this.board[j-1][this.boardSize-i-2], this.board[j][this.boardSize-i-3]) == true) {
                        System.out.println((i+1) + "," + (j-i+1) + "-" + (i+1+1) + "," + (j-i-1+1) + "-" + (i+2+1) + "," + (j-i-2+1));
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * Checks if there is a winner.
         * Returns true if there is, else false.
         */
        private boolean hasWinner() {
            if ((checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin()) == false) {
                return false;
            }
            this.setWinner(this.currentMark);
            System.out.println("The WINNER is: " + this.getCurrentMark());
            return true;
        }

        public boolean isOver(){
            return (this.isBoardFull() || this.hasWinner());
        }
    }
}