import java.util.ArrayList;
import java.util.List;

public class Tester {

	public static void main(String[] args) {

		// Non-generic parameter
		List list1 = new ArrayList();
		list1.add("BootCampers are the best!");
		String str1 = (String) list1.get(0);
		System.out.println(str1);
		
		// Generic parameter
		List<String> list2 = new ArrayList<String>();
	    list2.add("BootCampers are the best!");
	    // No casting is required.
	    String str2 = list2.get(0);
	    System.out.println(str2);
	    
	    Pairing<Male, Female> marryThem = new Pairing<>(new Male(), new Female());
		System.out.println(marryThem.toString());
	}

}
