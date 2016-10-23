import java.util.ArrayList;

public class BootCampAdministration {

	//Create a private ArrayList with object of BootCampCandidates with name anArrayListOfBootCamps
	private ArrayList<BootCampCandidates> anArrayListOfBootCamps;
	
	//Create a constructor which receives an array with BootCampCandidates objects and 
	//initializes the anArrayListOfBootCamps ArrayList by adding all BootCampCandidate array's
	//elements in the the anArrayListOfBootCamps
	public BootCampAdministration(BootCampCandidates[] anArrayOfBootCamps) {
		this.anArrayListOfBootCamps = new ArrayList<>();
		for (int i = 0, n = anArrayOfBootCamps.length; i < n; i++) {
			this.anArrayListOfBootCamps.add(anArrayOfBootCamps[i]);
		}
	}
	
	//Create setters and getters for BootCampAdministration
	public void setAnArrayListOfBootCamps(ArrayList<BootCampCandidates> anArrayListOfBootCamps) {
		this.anArrayListOfBootCamps = anArrayListOfBootCamps;
	}

	public ArrayList<BootCampCandidates> getAnArrayListOfBootCamps() {
		return this.anArrayListOfBootCamps;
	}

	//create an int method that returns the size of anArrayListOfBootCamps
	public int getSizeOfAnArrayListOfBootCamps() {
		return this.anArrayListOfBootCamps.size();
	}
	
	//Create a method that adds a new BootCampCandidate inside the ArrayList
	public void addNewBootCampCandidate(BootCampCandidates bootCampCandidate) {
		this.anArrayListOfBootCamps.add(bootCampCandidate);
	}
	
	//Create a method that removes a candidate by name and returns true if found or false if not
	//HINT: you have to use get() to get the object and equals to compare it
	public boolean removeBootCampCandidateByName(String name) {
		for (int i = 0, n = this.anArrayListOfBootCamps.size(); i < n; i++) {
			if (this.anArrayListOfBootCamps.get(i).getName().equals(name)) {
				this.anArrayListOfBootCamps.remove(i);
				return true;
			}
		}
		return false;
	}
	
	//Create a method to search for a boot camp member by surname and returns a string with its information
	// if it's found and null if it's not found
	public String getBootCampCandidateBySurname(String surname) {
		String currentSurname;
		for (int i = 0, n = this.anArrayListOfBootCamps.size(); i < n; i++) {
			currentSurname = this.anArrayListOfBootCamps.get(i).getSurname();
			if (currentSurname.equals(surname)) {
				return currentSurname;
			}
		}
		return null;	
	}
	
	//Create a method that can change a bootcampers age by having as input its name and surname
	public void setAgeOfBootCampCandidate(String name, String surname, int age) {
		for (int i = 0, n = this.anArrayListOfBootCamps.size(); i < n; i++) {
			if (this.anArrayListOfBootCamps.get(i).getName().equals(name)
				&& this.anArrayListOfBootCamps.get(i).getSurname().equals(surname)) {
				this.anArrayListOfBootCamps.get(i).setAge(age);
				return;
			}
		}
	}
	
}
