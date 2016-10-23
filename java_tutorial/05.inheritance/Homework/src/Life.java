
public class Life extends Insurance {
    /* Fields */
    // the amount the customer decides to invest.
    private int investmentAmount;

    /* Constructors */
    public Life() {
        super();
    }

    public Life(int investmentAmount) {
        super();
        this.investmentAmount = investmentAmount;
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
     * The cost calculation is:
     * + 100 euro
     * + 5 for every Customer’s year
     */
    @Override
    public int calculateInsuranceCost() {
        int insuranceCost = 0;
        for (Customer customer : InsuranceOffice.customers) {
            if (customer.getCustomerCode() == this.customerCode) {
                insuranceCost = super.calculateInsuranceCost() + (5 * (customer.getAge()));
            }
        }
        return insuranceCost;
    }

    @Override
    public String toString() {
        String lifeStr = "LIFE " + super.toString() + "\ninvestment amount: " + this.investmentAmount;
        return lifeStr;
    }
}