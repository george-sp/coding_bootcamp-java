/**
 * Each generated Insurance object should be stored in an array (length = 10).
 */
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
    public static void printAllInsurances(Insurance[] insurancesArray) {
        int insurancesArraySize = insurancesArray.length;
        for (int i = 0; i < insurancesArraySize; i++) {
            if (insurancesArray[i] != null){
                System.out.println(insurancesArray[i].toString());
            }
        }
    }

    /**
     * Print a particular insurance defined by insurance code.
     */
    public static void printInsuranceByCode(Insurance[] insurancesArray, int insuranceCode) {
        int insurancesArraySize = insurancesArray.length;
        int counter = 0;
        for (int i = 0; i < insurancesArraySize; i++) {
            if (insurancesArray[i] != null && insurancesArray[i].getInsuranceCode() == insuranceCode){
                System.out.println(insurancesArray[i].toString());
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
                        + "\nduration: " + this.duration;
        return insuranceStr;
    }
}