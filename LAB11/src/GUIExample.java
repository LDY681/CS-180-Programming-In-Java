import javax.swing.JOptionPane;

public class GUIExample {
    public static void main(String[] args) {

        // Display a YES_NO dialog and store the result
        int selectedOption = JOptionPane.showOptionDialog(null, "Would you like to take the quiz?", "Quiz",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

        // Check if the user selected YES in the previous dialog
        if (selectedOption == JOptionPane.YES_OPTION) {

            boolean passed = false;
            do {
                // Create a drop-down menu dialog with various options
                // showInputDialog(params...) returns an Object so we cast to a String
                String[] options = {"int", "double", "String", "boolean"};
                String selection = (String)JOptionPane.showInputDialog(null, "Which of the following is not a "
                        + "primitive type?", "Question 1", JOptionPane.PLAIN_MESSAGE, null, options, null);

                // Compare the user-input with the expected input
                // Display the corresponding information message
                if (selection.equals("String")) {
                    passed = true;
                    JOptionPane.showMessageDialog(null, "Good job!", "Correct", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Try again.", "Incorrect", JOptionPane.INFORMATION_MESSAGE);
                }
            } while (!passed);
        }
    }
}