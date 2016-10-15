import java.util.Scanner;

/**
 * Exercise5 - https://codeandwork.github.io/courses/java/objects.html
 * Implement a tic tac toe (triliza) game which is played by two players.
 */
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToeGame game = ticTacToe.new TicTacToeGame(3);
        game.play(1,2);
        game.play(4,4);
        game.play(3,3);
        game.play(3,0);
        game.play(2,2);
        game.drawBoard();
    }

    private class TicTacToeGame {
        // Use a two dimensions array to store the results ('X', 'O').
        private char[][] board;
        //
        private int boardSize;
        //
        private String newLine = "\n";
        private String lineEdge = "-";
        private String lineSeperator = "-";

        public TicTacToeGame(int size) {
            this.boardSize = size;
            generateBoard(this.boardSize);
            generateLineFrames(this.boardSize);
            drawBoard();
        }

        /**
         * Instantiate a two dimensions array NxN
         * and genrates it with '-'.
         */
        private void generateBoard(int size) {
            this.board = new char[size][size];
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