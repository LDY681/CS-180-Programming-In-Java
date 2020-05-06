import java.util.HashMap;
import java.util.Map;

public class TeachingAssistantStudent extends Student {

	private int hours; // total hours of TA
	protected Map<String, Integer> courseHour = new HashMap<String, Integer>();

	public TeachingAssistantStudent(String name, String address) {
		super(name, address);
		this.hours = 0;
	}

	// It adds a course into the HashMap with the key of course and hours as the
	// value.
	// This method throws ArrayElementException when the course that is being
	// added to the HashMap already exists in it.
	public void addCourseHour(String course, int hours)
			throws ArrayElementException {
		if (courseHour.get(course) !=null){
			throw new ArrayElementException("Course Already in list!");
		}
		courseHour.put(course, hours);
	}

	// This method first should print the courses along with the grades that the
	// TA is taking as a student and then print out the courses with the
	// corresponding hours which the TA is assisting in each line.
	// Use Iterator to iterate the HashMap.
	@Override
	public void printCourses() {
		System.out.println("CourseName\t\tCourseGrade");
		System.out.println("CoursesAssisting \t Hours");
		for (Map.Entry<String,Integer> entry : courseHour.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " \t\t\t\t " + value);
		}
	}

	public int getHours(){
		int hours = 0;
		for (Map.Entry<String,Integer> entry : courseHour.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			hours = hours + value;
		}
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return super.toString() + " Also serving as Teaching Assistant.";
	}

}