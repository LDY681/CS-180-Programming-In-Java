/**
 * CS180 - Lab 03 - StringManipulator
 * <p>
 * Make email address
 *
 * @author Liu Dayu, liu1589@purdue.edu
 */

import java.util.Scanner;

public class StringManipulator {
    public static String makeUserName(String fullName) {
        if (fullName == null) {
            return null;
        }
        char char1 = fullName.charAt(0);
        String str1 = String.valueOf(char1);
        int space = fullName.indexOf(' ');
        String str2 = fullName.substring(space + 1);
        return str1.concat(str2).toLowerCase();
    }

    public static String makeEmail(String userName, String domain) {
        if (userName == null) {
            return null;
        }
        return userName.concat("@" + domain.toLowerCase());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please type your fullname in order of First name and then Family name");
        String fullName = s.nextLine();
        System.out.println("Please type your domain (E.g)purdue.edu");
        String domain = s.nextLine();
        System.out.println(makeEmail(makeUserName(fullName), domain));
    }

}
