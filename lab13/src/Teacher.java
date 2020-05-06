import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Define class Teacher, subclass of AcademicPerson
public class Teacher extends AcademicPerson {
	// Instance variables
	private static final int MAX_COURSES = 10; // maximum courses
    Map<String,Integer> map = new HashMap<String,Integer>();
    int count = 1 ;
    int pos = 1;
	// Constructor
	public Teacher(String name, String address) {
		super(name, address);
		courses = new String[MAX_COURSES];
	}

	
	// It adds a course into the list of courses.
	// This method throws ArrayElementException when the course that is being
	// added to the list already exists in it.
	public void addCourse(String course) throws ArrayElementException {
        if (map.get(course) !=null){
            throw new ArrayElementException("Course Already in list!");
        }
        if (count > MAX_COURSES){
            throw new ArrayElementException("Course List is full");
        }
        map.put(course, pos);
        count ++;
        pos ++;
	}

	// It removes a course into the list of courses.
	// This method throws ArrayElementException when the course does not exist
	// in the list.
	public void removeCourse(String course) throws ArrayElementException {
    if (map.get(course) == null){
        throw new ArrayElementException("Course not found!");
    }
        map.remove(course);
        count --;
	}

	// It prints all the courses in the list in each line
	@Override
	public void printCourses() {
    System.out.println("Courses teaching this semester:");
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key);
        }
	}

	@Override
	public String toString() {
		return "Teacher: " + super.toString();
	}

}