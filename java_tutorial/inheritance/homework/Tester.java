/**
 * This class is used for testing.
 */
public class Tester {
    public static void main(String[] args) {
        System.out.println("\nThis is a tester class!\n");

        // Test Customer 1
        Customer c1 = new Customer();
        System.out.println("c1) code: " + c1.getCustomerCode()
                           + ", name: " + c1.getName()
                           + ", birtyYear:" + c1.getBirthYear()
                           + ", sex:" + c1.getSex());
        c1.setName("George");
        c1.setBirthYear(1991);
        c1.setSex(true);
        System.out.println(c1.toString());

        // Test Customer 2
        Customer c2 = new Customer("Spyridakis", 2016, true);
        System.out.println(c2.toString());
        System.out.println(c1.toString());

        // Test Customer 3
        Customer c3 = new Customer();
        System.out.println(c3.toString());

    }
}