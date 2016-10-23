
public class Bootcamp {

	public static void main(String[] main) {
		System.out.println(bye(26));
		System.out.println(bye(24));
		System.out.println(bye(25));
	}
	
	public static int bye(double number) {
		try {
			System.out.println("\n" + number + "\n----");
			welcome(number);
		} catch (DigitException de) {
			System.out.println("DigitException: " + de.getDigitExceptionMessage());
			return 605;
		} catch (AnotherDigitException ade) {
			System.out.println("AnotherDigitException: " + ade.getDigitExceptionMessage());
			return 230;
		} finally {
			System.out.println("FINALLY ALWAYS GET EXECUTED!!");
		}
		return 0;
	}

	public static void welcome(double doubleArgument) throws DigitException, AnotherDigitException {
		if (doubleArgument > 25) {
			throw new DigitException();
		} else if (doubleArgument < 25){
			throw new AnotherDigitException();
		}
	}
}
