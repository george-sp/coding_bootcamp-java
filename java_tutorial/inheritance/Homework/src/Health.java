/**
 * Each generated Health object should be stored in an array (length = 10).
 */
public class Health extends Insurance {
    /* Fields */
    // the medical expense the customer wants
    private int medicalExpense;

    /* Constructors */
    // Default Constructors
    public Health() {
        super();
    }

    public Health(int medicalExpense) {
        super();
        this.medicalExpense = medicalExpense;
    }

    public Health(int customerCode, int duration, int medicalExpense) {
        super(customerCode, duration);
        this.medicalExpense = medicalExpense;
    }

    /* Setters & Getters */
    public void setMedicalExpense(int medicalExpense) {
        this.medicalExpense = medicalExpense;
    }

    public int getMedicalExpense() {
        return this.medicalExpense;
    }

    /**
     * Calculates the insurance cost and returns it.
     * The cost calculation is :
     * + 100 euro
     * + 7 for every Customer’s year
     * + 50 euro if he is a man.
     */
    @Override
    public int calculateInsuranceCost() {
        int insuranceCost = 0;
        for (Customer customer : InsuranceOffice.customers) {
            if (customer.getCustomerCode() == this.customerCode) {
                insuranceCost = super.calculateInsuranceCost() + (7 * (customer.getAge()));
                if (customer.getSex()) insuranceCost += 50;
            }
        }
        return insuranceCost;
    }

    @Override
    public String toString() {
        String healthStr = "HEALTH " + super.toString() + "\nmedical expense: " + this.medicalExpense;
        return healthStr;
    }
}