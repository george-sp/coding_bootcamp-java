/**
 * Write a program that calculates the first five terms of the harmonic sequence,
 * that is, the numbers:
 *              1
 *           1 + 1/2
 *        1 + 1/2 + 1/3
 *     1 + 1/2 + 1/3 + 1/4
 *  1 + 1/2 + 1/3 + 1/4 + 1/5
 */
public class Exercise1_5 {
    public static void main(String[] args) {
        // Initialize a variable to store the sum.
        double sum = 0;

        for (int i = 1; i <= 5; i++) {
            sum += (double) 1/i;
            System.out.println(sum);
        }
    }
}