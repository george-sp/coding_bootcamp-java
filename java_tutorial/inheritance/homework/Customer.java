/**
 * Each generated Customer object should be stored in an array (length=10).
 */
public class Customer {
    /* Fields */
    // customer's code (auto-increment)
    private final int CUSTOMER_CODE;
    private static int counter;
    // customer's name
    private String name;
    // year of birth
    private int birthYear;
    // sex (male/female): male = true / female = false
    private boolean sex;

    /* Constructors */
    // Default Constructor
    public Customer() {
        counter++;
        this.CUSTOMER_CODE = counter;
    }

    public Customer(String name, int birthYear, boolean sex) {
        this();
        this.name = name;
        this.birthYear = birthYear;
        this.sex = sex;
    }

    /* Setters & Getters */
    public int getCustomerCode() {
        return this.CUSTOMER_CODE;
    }

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

    @Override
    public String toString() {
        String customer = "Customer:\n---------"
                        + "\ncustomer code: " + this.CUSTOMER_CODE
                        + "\nname: " + this.name
                        + "\nbirtyYear: " + this.birthYear;
        if (this.sex) {
            customer += "\nsex: male";
        } else {
            customer += "\nsex: female";
        }

        return customer;

    }
}