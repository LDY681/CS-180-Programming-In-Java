import java.util.Scanner;

public class MathToolsClient {

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            Scanner a = new Scanner(System.in);
            System.out.println("Select a number from the menu choices:");
            System.out.println("1 - Absolute Value");
            System.out.println("2 - Power");
            System.out.println("3 - Nth Root");
            System.out.println("4 - Scientific Notation");

            String b = a.next();
            if (b.equals("1")) {
                System.out.println("Enter the number");
                Double c = a.nextDouble();
                System.out.println(MathTools.absoluteValue(c));

                //Invalid response
                System.out.println("Return to the menu? (yes/no)");
                boolean ask = true;
                while (ask) {
                    String n = a.next();
                    if (n.equals("yes")) {
                        ask = false;
                    }
                    if (!n.equals("yes")) {
                        if (n.equals("no")) {
                            ask = false;
                            run = false;
                        }
                        if (!n.equals("no")) {
                            System.out.println("Invalid option.");
                            System.out.println("Return to the menu? (yes/no)");
                        }
                    }
                }
            }

            if (b.equals("2")) {
                System.out.println("Enter the base");
                Double c = a.nextDouble();
                System.out.println("Enter the exponent");
                int d = a.nextInt();
                System.out.println(MathTools.power(c, d));

                //Invalid response
                System.out.println("Return to the menu? (yes/no)");
                boolean ask = true;
                while (ask) {
                    String n = a.next();
                    if (n.equals("yes")) {
                        ask = false;
                    }
                    if (!n.equals("yes")) {
                        if (n.equals("no")) {
                            ask = false;
                            run = false;
                        }
                        if (!n.equals("no")) {
                            System.out.println("Invalid option.");
                            System.out.println("Return to the menu? (yes/no)");
                        }
                    }
                }
            }


            if (b.equals("3")) {
                System.out.println("Enter the base");
                Double c = a.nextDouble();
                System.out.println("Enter the root");
                int d = a.nextInt();
                System.out.println(MathTools.nthRoot(c, d));

                //Invalid response
                System.out.println("Return to the menu? (yes/no)");
                boolean ask = true;
                while (ask) {
                    String n = a.next();
                    if (n.equals("yes")) {
                        ask = false;
                    }
                    if (!n.equals("yes")) {
                        if (n.equals("no")) {
                            ask = false;
                            run = false;
                        }
                        if (!n.equals("no")) {
                            System.out.println("Invalid option.");
                            System.out.println("Return to the menu? (yes/no)");
                        }
                    }
                }

            }

            if (b.equals("4")) {
                System.out.println("Enter the number");
                Double c = a.nextDouble();
                System.out.println(MathTools.scientificNotation(c));

                //Invalid response
                System.out.println("Return to the menu? (yes/no)");
                boolean ask = true;
                while (ask) {
                    String n = a.next();
                    if (n.equals("yes")) {
                        ask = false;
                    }
                    if (!n.equals("yes")) {
                        if (n.equals("no")) {
                            ask = false;
                            run = false;
                        }
                        if (!n.equals("no")) {
                            System.out.println("Invalid option.");
                            System.out.println("Return to the menu? (yes/no)");
                        }
                    }
                }
            }

            if (!b.equals("1") && !b.equals("2") &&
                    !b.equals("3") && !b.equals("4")) {
                System.out.println("Invalid option.");


                //Invalid response
                System.out.println("Return to the menu? (yes/no)");
                boolean ask = true;
                while (ask) {
                    String n = a.next();
                    if (n.equals("yes")) {
                        ask = false;
                    }
                    if (!n.equals("yes")) {
                        if (n.equals("no")) {
                            ask = false;
                            run = false;
                        }
                        if (!n.equals("no")) {
                            System.out.println("Invalid option.");
                            System.out.println("Return to the menu? (yes/no)");
                        }
                    }
                }
            }
        }
    }
}