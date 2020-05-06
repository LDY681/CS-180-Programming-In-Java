import java.util.Scanner;

/**
 * The FAFSAClient class prompts the user for information relevant to their
 * FAFSA application, reads the information, and stores it so it may be used
 * the FAFSA class to determine their federal financial aid eligibility and
 * their total estimated award amount.
 * 
 * @author Neil Allison, nalliso@purdue.edu
 *
 */
public class FAFSAClient {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	
		boolean isAcceptedStudent;
		boolean isSSregistered;
		boolean hasSSN;
		boolean hasValidResidency;
		
		int age;
		int creditHours;
		double studentIncome;
		double parentIncome;
		boolean isDependent;
		String classStanding;
		
		System.out.println("Have you been accepted into a degree or certificate program?");
		isAcceptedStudent = s.nextLine().equalsIgnoreCase("yes");
		System.out.println("Are you registered for the selective service?");
		isSSregistered = s.nextLine().equalsIgnoreCase("yes");
		System.out.println("Do you have a social security number?");
		hasSSN = s.nextLine().equalsIgnoreCase("yes");
		System.out.println("Do you have valid residency status?");
		hasValidResidency = s.nextLine().equalsIgnoreCase("yes");
		System.out.println("How old are you?");
		age = s.nextInt();
		System.out.println("How many credit hours do you plan on taking?");
		creditHours = s.nextInt();
		System.out.println("What is your total yearly income?");
		studentIncome = s.nextDouble();
		System.out.println("What is your parent's total yearly income?");
		parentIncome = s.nextDouble();
		System.out.println("Are you a dependent?");
		isDependent = s.nextLine().equalsIgnoreCase("yes");
		s.nextLine();
		System.out.println("Are you an undergraduate or graduate?");
		classStanding = s.nextLine();
		
		s.close();
		
		FAFSA student = new FAFSA(isAcceptedStudent, isSSregistered, hasSSN, 
				hasValidResidency, isDependent, age, creditHours, 
				studentIncome, parentIncome, classStanding);
		
		System.out.printf("Your total estimated federal aid pacakge is: $%.2f", student.calcFederalAidAmount());

	}
}
