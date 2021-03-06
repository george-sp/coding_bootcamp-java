import java.util.ArrayList;

public class Insurance {
    /* Fields */
    // customer's code
    protected int customerCode;
    // insurance's code (auto-increment)
    protected final int INSURANCE_CODE;
    private static int counter;
    // duration
    protected int duration;
    // a fixed price of 100 euro
    private static final int INSURANCE_COST = 100;
    // the cost of the insurance
    private int cost;

    /* Constructors */
    // Default Constructor
    public Insurance() {
        counter++;
        this.INSURANCE_CODE = counter;
    }

    public Insurance(int customerCode, int duration) {
        this();
        this.customerCode = customerCode;
        this.duration = duration;
        this.cost = this.calculateInsuranceCost();
    }

    /* Setters & Getters */
    public void setCustomerCode(int customerCode) {
        this.customerCode = customerCode;
    }

    public int getCustomerCode() {
        return this.customerCode;
    }

    public int getInsuranceCode() {
        return this.INSURANCE_CODE;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }
    
    /**
     * Calculates the insurance cost and returns it.
     */
    public int calculateInsuranceCost() {
        return INSURANCE_COST;
    }

    /**
     * Prints all stored insurances.
     */
    public static void printAllInsurances(ArrayList<Insurance> insurances) {
        if (!insurances.isEmpty()) {
            for (Insurance insurance : insurances) {
                System.out.println(insurance.toString() + "\n");
            }
        } else {
            System.out.println("No Insurances found!");
        }
    }

    /**
     * Print a particular insurance defined by insurance code.
     */
    public static void printInsuranceByInsuranceCode(ArrayList<Insurance> insurances, int insuranceCode) {
        if (!insurances.isEmpty()) {
            int counter = 0;
            for (Insurance insurance : insurances) {
                if (insurance.getInsuranceCode() == insuranceCode){
                    System.out.println(insurance.toString() + "\n");
                    counter++;
                }
            }
            if (counter == 0) {
                System.out.println("Insurance not found!");
            }
        } else {
            System.out.println("Insurances not found!");
        }
    }

    /**
     * Print a particular insurance defined by customer code.
     */
    public static void printInsuranceByCustomerCode(ArrayList<Insurance> insurances, int customerCode) {
        int counter = 0;
        for (Insurance insurance : insurances) {
            if (insurance.getCustomerCode() == customerCode){
                System.out.println(insurance.toString() + "\n");
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("Insurance not found!");
        }
    }

    @Override
    public String toString() {
        String insuranceStr = "Insurance:\n---------"
                        + "\ncustomer code: " + this.customerCode
                        + "\ninurance code: " + this.INSURANCE_CODE
                        + "\nduration: " + this.duration
        				+ "\ncost: " + this.cost;
        return insuranceStr;
    }
}