/**
 * https://codeandwork.github.io/courses/java/objects.html
 * Exercise2:
 *
 * Create a program that simulates the roll of two dices.
 * The program must execute till both dices return 1 as a result.
 * You can create a class name Dice which has a void roll method.
 * Roll method is rolling the dices till the needed results is aquired
 * and prints the number of rolls needed in order to have two 1s.
 */
public class Dice {
    public static void main(String[] args) {
        roll();
    }

    /**
     * Roll method is rolling the dices till the needed results is aquired
     * and prints the number of rolls needed in order to have two 1s.
     */
    private static void roll() {
        int dice1, dice2;
        for (int i = 1; i != 0; i++) {
            // Get two int from [1,6].
            dice1 = (int) (Math.random() * 6) + 1;
            dice2 = (int) (Math.random() * 6) + 1;
            System.out.println("Rolls " + i + ": " + dice1 + ", " + dice2);
            // Check if we have to 1s.
            if (dice1 == dice2 && dice1 == 1) {
                System.out.println("In order to have two 1s, " + i + " rolls needed.");
                break;
            }
        }
    }
}