/**
 * CS180 - Lab 02
 * Pythagoras Client
 * @author Liu Dayu, liu1589@purdue.edu, lab 02
 */

import java.util.Scanner;

public class PythagorasClient {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of side 'a': ");
        int side1 = s.nextInt();
        System.out.println("Enter the length of side 'b': ");
        int side2 = s.nextInt();
        double hypotenuse = p.getHypotenuse(side1, side2);
        System.out.println("Side 'a': " + side1);
        System.out.println("Side 'b': " + side2);
        System.out.println("Hypotenuse: " + hypotenuse);
    }
}
