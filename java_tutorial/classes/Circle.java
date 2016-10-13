/**
 * Exercise1:
 * https://codeandwork.github.io/courses/java/classes-p.html#/38
 */
/*
 * A class that represents a circle shape
 */
public class Circle {
    // the x coordinate
    private int x;
    // the y coordinate
    private int y;
    // the radius
    private int r;
    // the pi
    public static final double PI = 3.14;
    // Counts the number of the created circles.
    private static int number_of_circles;


    /**
     * Constructors
     */
    // Takes no arguments Default Constructor.
    public Circle() {
        this.r = 1;
        number_of_circles ++;
    }

    // Takes two arguments x,y.
    public Circle(int x, int y) {
        this();
        this.x = x;
        this.y = y;
    }

    // Takes arguments to initialize all field members.
    public Circle(int x, int y, int r) {
        this(x, y);
        this.r = r;
    }

    // Copy constructor.
    public Circle copy() {
        Circle newCircle = new Circle();
        newCircle.x = this.x;
        newCircle.y = this.y;
        newCircle.r = this.r;
        return newCircle;
    }

    /*
     * Setters & Getters
     */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getR() {
        return this.r;
    }

    public static int getNumberOfCircles() {
        return number_of_circles;
    }

    /**
     * Prints the details of the Circle.
     */
    public void print() {
        System.out.println(
            "* I'm a circle at point (" + this.x + ", " + this.y + ")"
            + " with radius " + this.r);
    }

    /**
     * Calculates and returns the area:
     * (π*radius*radius, π=3.14)
     */
    public double calculateArea() {
        return PI * Math.pow(r, 2);
    }

    /**
     * Calculates and returns the perimeter:
     * (2*π*radius, π=3.14)
     */
    public double calculatePerimeter() {
        return 2*PI*r;
    }

    /**
     * Checks if two circles share the same centre (co-centric circles).
     * The method should return true if circles are co-centric,
     * or false if circles have different centres.
     */
    public static boolean cocentric (int x1, int x2, int y1, int y2) {
        if (x1 == x2 && y1 == y2) return true;
        return false;
    }
}