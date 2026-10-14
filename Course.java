package week4;
import java.util.List;
import java.util.ArrayList;

public class Course {

    String courseName;
    int capacity;
    List<Student> enrolledStudents;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
        
        this.enrolledStudents = new ArrayList<>();
    }

    public void displayCourseInfo() {
        System.out.println("Course Name: " + courseName + ", Capacity: " + capacity + ", Current Enrolled: " + enrolledStudents.size());
        
        if (enrolledStudents.isEmpty()) {
            System.out.println("  - No students enrolled yet.");
        } else {
            System.out.println("  - Enrolled Students:");
            for (Student s : enrolledStudents) {
                System.out.println("    * " + s.name + " (ID: " + s.studentID + ")");
            }
        }
    }
}

