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

    public int getAge() {
        return (2016 - this.birthYear);
    }

    @Override
    public String toString() {
        String customerStr = "Customer:\n---------"
                        + "\ncustomer code: " + this.CUSTOMER_CODE
                        + "\nname: " + this.name
                        + "\nbirtyYear: " + this.birthYear;
        if (this.sex) {
            customerStr += "\nsex: male";
        } else {
            customerStr += "\nsex: female";
        }
        return customerStr;
    }
}