/**
 * A tester for the Circle class.
 */
public class TestCircles {
    public static void main(String[] args) {
        // Create circle objects using all constructors.
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        Circle c3 = new Circle(1,2);
        Circle c4 = new Circle(5,6,7);
        // Assign values.
        c1.setX(3);
        c1.setY(4);
        c1.setR(5);
        // Print the details of circles.
        c1.print();
        c2.print();
        c3.print();
        c4.print();
        // Print the perimeter and the area of the c4.
        System.out.println(c4.calculatePerimeter());
        System.out.println(c4.calculateArea());
        // Create a copy of c3.
        System.out.println("Create a copy of the third circle.");
        Circle c5 = c3.copy();
        c3.print();
        c5.print();
        c3.setX(100);
        c3.setY(100);
        c3.setR(100);
        c3.print();
        c5.print();
    }
}