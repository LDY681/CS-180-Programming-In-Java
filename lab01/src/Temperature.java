/**
 * CS180 - Lab 01
 * F degree to C degree
 *
 * @author Liu Dayu, liu1589@purdue.edu, lab 01
 */

import java.util.Scanner;

public class Temperature {
    public static void main(String[] args) {
        double fahrenheit;
        double celsius;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the temperature in Fahrenheit: ");
        fahrenheit = s.nextDouble();
        celsius = ((fahrenheit - 32) * 5) / 9;
        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Celcius: " + celsius);
    }
}
