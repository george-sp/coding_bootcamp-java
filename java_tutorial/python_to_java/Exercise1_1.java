/**
 * Write a program that produces the following output:
 * 000000001
 * 000000022
 * 000000333
 * 000004444
 * 000055555
 * 000666666
 * 007777777
 * 088888888
 * 999999999
 */

public class Exercise1_1 {
    public static void main(String[] args) {
        int range = 9;
        // Iterate through each line.
        for (int i = 1; i <= range; i++) {
            // Iterate through each column.
            for (int j = 0; j < range - i; j++) {
                // Print the 0s.
                System.out.print(0);
            }
            for (int j = 0; j < i; j++) {
                // Print the 'i'.
                System.out.print(i);
            }
            System.out.print("\n");
        }
    }
}