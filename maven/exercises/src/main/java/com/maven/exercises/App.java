package com.maven.exercises;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Triangle!" );
        
        // Check if the given three sides can form a triangle
        System.out.print("(3, 4, 5) isTriangle(): " + Triangle.isTriangle(3, 4, 5));
        Triangle t1 = new Triangle(3, 4, 5);
        System.out.println(", isRight(): " + t1.isRight() + ", perimeter: " + t1.getPerimeter());
        
        System.out.println("(3, 4, 0) isTriangle(): " + Triangle.isTriangle(3, 4, 0));
        Triangle t2 = new Triangle(3, 4, 0);
        
        System.out.println("(0, 3, 3) isTriangle(): " + Triangle.isTriangle(0, 3, 3));
        Triangle t3 = new Triangle(0, 3, 3);
        
        System.out.print("(3, 3, 3) isTriangle(): " + Triangle.isTriangle(3, 3, 3));
        Triangle t4 = new Triangle(3, 3, 3);
        System.out.println(", isRight(): " + t4.isRight() + ", perimeter: " + t4.getPerimeter());
    }
}
