import java.util.Arrays;

public class Reception {
	
	static final String LIBRARY_SYSTEM_MENU = "=====> LIBRARY_MENU <=====";
	
	
	public static void main(String[] args) {
		Librarian admin = new Librarian(Tester.initLibrary());
		
		System.out.println(LIBRARY_SYSTEM_MENU);
	}
	
}
