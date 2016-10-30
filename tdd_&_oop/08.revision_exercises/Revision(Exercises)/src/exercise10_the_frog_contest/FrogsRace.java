package exercise10_the_frog_contest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FrogsRace {

	public static void main(String[] args) {

		// At first give 0 3 4 2 and after 0 2 5 3
		// expected out for first YES and for second is NO

		Scanner in = new Scanner(System.in);
		try {
			System.out.print("> ");
			int x1 = in.nextInt();
			System.out.print("> ");
			int v1 = in.nextInt();
			System.out.print("> ");
			int x2 = in.nextInt();
			System.out.print("> ");
			int v2 = in.nextInt();

			Frog frog1 = new Frog(x1, v1);
			Frog frog2 = new Frog(x2, v2);

			if (frog1.landAtTheSameLocation(frog2)) {
				System.out.println("YES");
				System.out.println(frog1.findSameLandingLocation(frog2));
			} else {
				System.out.println("NO");
			}
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			}
		}

	}
}