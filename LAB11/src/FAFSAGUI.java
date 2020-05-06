import jdk.nashorn.internal.scripts.JO;

import javax.swing.JOptionPane;

public class FAFSAGUI {
    public static boolean inttoboolean(int value){
        if (value == 0){
            return true;
        }
        if (value == 1){
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to the FAFSA!", "Welcome",
                JOptionPane.INFORMATION_MESSAGE);
        int isAcceptedStudent = JOptionPane.showOptionDialog(null, "Have you been accepted into a degree" +
                        " or certificate program?", "Program Acceptance",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        int isSSregistered = JOptionPane.showOptionDialog(null, "Are you registered for the selective service?"
                , "Selective Service", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        int hasSSN = JOptionPane.showOptionDialog(null, "Do you have a social security number?",
                "Social Security Number", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        int hasValidResidency = JOptionPane.showOptionDialog(null, "Do you have valid residency status?",
                "Residency Status", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        boolean ageerror = false;
        int age = 0;
        do {
            age = Integer.parseInt(JOptionPane.showInputDialog(null, "How old are you?", "Age",
                    JOptionPane.QUESTION_MESSAGE));
            ageerror = false;
            if (age < 0) {
                ageerror = true;
                JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: Age",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (ageerror);

        int creditHours = 0;
        boolean cherror = false;
        do {
            creditHours = Integer.parseInt(JOptionPane.showInputDialog(null, "How many credit hours do you plan on taking?"
                    , "Credit Hours", JOptionPane.QUESTION_MESSAGE));
            cherror = false;
            if (creditHours > 24 || creditHours < 1) {
                cherror = true;
                JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, inclusive.", "Error: Credit Hours",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (cherror);
        boolean sierror = false;
        double studentIncome = 0;
        do {
            studentIncome = Double.parseDouble(JOptionPane.showInputDialog(null, "What is your total yearly income?"
                    , "Student Income", JOptionPane.QUESTION_MESSAGE));
            sierror = false;
            if (studentIncome < 0) {
                sierror = true;
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Student Income",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (sierror);

        boolean pierror= false;
        double parentIncome = 0;
        do {
            parentIncome = Double.parseDouble(JOptionPane.showInputDialog(null, "What is your parent's total yearly income?"
                    , "Parent Income", JOptionPane.QUESTION_MESSAGE));
            pierror = false;
            if (parentIncome < 0) {
                pierror = true;
                JOptionPane.showMessageDialog(null, "Income cannot be a negative number.", "Error: Parent Income",
                        JOptionPane.ERROR_MESSAGE);
            }
        } while (pierror);
        int isIndependent = JOptionPane.showOptionDialog(null, "Are you a dependent?", "Dependency", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        String[] options = {"Freshman", "Sophomore", "Junior", "Senior","Graduate"};
        String classStanding = (String)JOptionPane.showInputDialog(null, "What is your current class standing?", "Class Standing",
                JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (!classStanding.equals("Graduate")){
            classStanding = "Undergraduate";
        }
        FAFSA fafsa = new FAFSA(inttoboolean(isAcceptedStudent), inttoboolean(isSSregistered), inttoboolean(hasSSN),
                inttoboolean(hasValidResidency), inttoboolean(isIndependent), age, creditHours
                , studentIncome, parentIncome, classStanding);
        double grant = fafsa.calcFederalGrant();
        double loan = fafsa.calcStaffordLoan();
        double workStudy = fafsa.calcWorkStudy();
        double totalaid = fafsa.calcFederalAidAmount();
        String output =String.format("Results Available!\n Your grant is $%d!\n Your loan is $%d!\n Your workStudy is $%d!\n Your total aid is $%d!", (int)grant, (int)loan, (int)workStudy, (int)totalaid);
        JOptionPane.showMessageDialog(null, output, "FAFSA Results",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
