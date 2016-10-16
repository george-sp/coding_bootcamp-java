/**
 * Each generated Customer object should be stored in an array (length=10).
 */
public class Customer {
    /* Fields */
    // customer's code (auto-increment)
    private static int code;
    // customer's name
    private String name;
    // year of birth
    private int birthYear;
    // sex (male/female): male = true / female = false
    private boolean sex;

    /* Constructors */
    // Default Constructor
    public Customer() {
        this.code++;
    }

    public Customer(String name, int birthYear, boolean sex) {
        this();
        this.name = name;
        this.birthYear = birthYear;
        this.sex = sex;
    }

    /* Setters & Getters */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setSex(boolean sex) {
        /*
         * Set true for male or false for female
         */
        this.sex = sex;
    }

    public boolean getSex() {
        return this.sex;
    }
}