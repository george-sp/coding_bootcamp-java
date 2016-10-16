/**
 * Each generated Life object should be stored in an array (length=10).
 */
public class Life extends Insurance {
    /* Fields */
    // the amount the customer decides to invest.
    private int investmentAmount;

    /* Constructors */
    public Life() {
        super();
    }

    public Life(int customerCode, int duration, int investmentAmount) {
        super(customerCode, duration);
        this.investmentAmount = investmentAmount;
    }

    /* Setters & Getters */
    public void setInvestmentAmount(int investmentAmount) {
        this.investmentAmount = investmentAmount;
    }

    public int getInvestmentAmount() {
        return this.investmentAmount;
    }

    /**
     * Calculates the insurance cost and returns it.
     * The cost calculation is 100 euro plus 5 for every Customer’s year
     */
    public int calculateInsuranceCost(Customer[] customersArray) {
        int insuranceCost = 0;
        for (int i = 0; i < 10; i++) {
            if (customersArray[i] != null && customersArray[i].getCustomerCode() == this.customerCode) {
                insuranceCost = super.calculateInsuranceCost() + (5 * (customersArray[i].getAge()));
            }
        }
        return insuranceCost;
    }

    @Override
    public String toString() {
        String lifeStr = super.toString() + "\n(LIFE)\ninvestment amount: " + this.investmentAmount;
        return lifeStr;
    }
}