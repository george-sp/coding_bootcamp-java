import java.util.Scanner;

/**
 * Exercise5 - https://codeandwork.github.io/courses/java/objects.html
 * Implement a tic tac toe (triliza) game which is played by two players.
 */
public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe!");
        TicTacToe ticTacToe = new TicTacToe();
        TicTacToeGame game = ticTacToe.new TicTacToeGame();
    }

    private class TicTacToeGame {
        // Use a two dimensions array to store the results ('X', 'O').
        private char[][] board;

        public TicTacToeGame() {
            generateBoard(3);
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
    }
}