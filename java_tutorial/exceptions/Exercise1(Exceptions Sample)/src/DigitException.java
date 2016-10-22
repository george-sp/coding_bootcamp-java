
public class DigitException extends Exception {
	
	private String digitExceptionMessage = "Number is greater than 25";
	
	public DigitException() {}
	
	public String getDigitExceptionMessage() {
		return this.digitExceptionMessage;
	}
	
}
