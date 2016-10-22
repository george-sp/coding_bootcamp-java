
public class AnotherDigitException extends Exception {

private String anotherDigitExceptionMessage = "Number is smaller than 25";
	
	public AnotherDigitException() {}
	
	public String getDigitExceptionMessage() {
		return this.anotherDigitExceptionMessage;
	}
	
}
