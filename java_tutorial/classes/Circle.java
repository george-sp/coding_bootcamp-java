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

    /**
     * Constructors
     */
    public Circle() {}

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
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

    /**
     * Prints the details of the Circle.
     */
    public void print() {
        System.out.println(
            "* I'm a circle at point (" + this.x + ", " + this.y + ")"
            + " with radius " + this.r);
    }
}