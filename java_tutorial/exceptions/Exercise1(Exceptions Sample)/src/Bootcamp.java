
public class Bootcamp {
	
	public static void welcome(double doubleArgument) throws DigitException, AnotherDigitException{
		if (doubleArgument > 25) {
			throw new DigitException();
		} else {
			throw new AnotherDigitException();
		}
	}
}
