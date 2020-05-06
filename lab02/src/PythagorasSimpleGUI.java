/**
 * CS180 - Lab 02
 * Pythagoras GUI
 *
 * @author Liu Dayu, liu1589@purdue.edu, lab 02
 */

import javax.swing.JOptionPane;

public class PythagorasSimpleGUI {
    static Pythagoras p = new Pythagoras();
    static String input1 = JOptionPane.showInputDialog("Enter the length of side 'a'");
    static String input2 = JOptionPane.showInputDialog("Enter the length of side 'b'");
    static int side1 = Integer.parseInt(input1);
    static int side2 = Integer.parseInt(input2);
    static double hypotenuse = p.getHypotenuse(side1, side2);

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "The hypotenuse is: " + hypotenuse);
    }
}


