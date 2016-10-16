/**
 * This class is used for testing.
 */
public class Tester {
    public static void main(String[] args) {
        System.out.println("\nThis is a tester class!\n");

        Customer[] customersArray = new Customer[10];
        Insurance[] insurancesArray = new Insurance[10];
        Life[] lifesArray = new Life[10];

        // Test Customer 1
        Customer c1 = new Customer();
        customersArray[0] = c1;
        System.out.println("c1) code: " + c1.getCustomerCode()
                           + ", name: " + c1.getName()
                           + ", birtyYear:" + c1.getBirthYear()
                           + ", sex:" + c1.getSex() + "\n");
        c1.setName("George");
        c1.setBirthYear(1991);
        c1.setSex(true);
        System.out.println(c1.toString() + "\n");

        // Test Customer 2
        Customer c2 = new Customer("Spyridakis", 2016, true);
        customersArray[1] = c2;
        System.out.println(c2.toString() + "\n");
        System.out.println(c1.toString() + "\n");

        // Test Customer 3
        Customer c3 = new Customer();
        customersArray[2] = c3;
        System.out.println(c3.toString() + "\n");

        // Test Insurance 1
        Insurance i1 = new Insurance();
        insurancesArray[0] = i1;
        System.out.println(i1.toString() + "\n");

        // Test Insurance 2
        Insurance i2 = new Insurance(c2.getCustomerCode(), 6);
        System.out.println(i2.toString() + "\n");
        insurancesArray[1] = i2;

        System.out.println("Cost of i1: " + i1.calculateInsuranceCost() + " euro."
                         + "\nCost of i2: " + i2.calculateInsuranceCost() + " euro." + "\n");

        Insurance.printAllInsurances(insurancesArray);
        Insurance.printAllInsurances(insurancesArray, 2);

        // Test Life 1
        Life l1 = new Life();
        lifesArray[0] = l1;
        l1.setCustomerCode(2);
        l1.setInvestmentAmount(1500);
        System.out.println("\n" + l1.toString() + "\n");

        // Test Life 2
        Life l2 = new Life(c1.getCustomerCode(), 2, 20000);
        lifesArray[1] = l2;
        System.out.println(l2.toString() + "\n");

        System.out.println("Cost of l1: " + l1.calculateInsuranceCost(customersArray) + " euro."
                         + "\nCost of l2: " + l2.calculateInsuranceCost(customersArray) + " euro." + "\n");

    }
}