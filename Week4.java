package week4;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Week4 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Course> courseList = new ArrayList<>();

        int courseNum = 0;
        while (courseNum < 3) {
            System.out.println("How many courses do you want to create? (at least 3): ");
            courseNum = input.nextInt();
            if (courseNum < 3) {
                System.out.println("You must create at least 3 courses!");
            }
        }
        input.nextLine();

        for (int i = 0; i < courseNum; i++) {
            System.out.print("Enter course name: ");
            String courseName = input.nextLine();
            
            System.out.print("Enter course capacity: ");
            int capacity = input.nextInt();
            input.nextLine();
            
            Course course = new Course(courseName, capacity);
            courseList.add(course);
        }

        System.out.println("\n--- Courses created successfully! ---");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n==================================");
            System.out.println("             MENU                 ");
            System.out.println("==================================");
            System.out.println("1. Show course names and capacities");
            System.out.println("2. Register student");
            System.out.println("3. Show all courses and student lists");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice (1-4): ");
            
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Courses ---");
                    for (Course c : courseList) {
                        System.out.println("- Course: " + c.courseName + " | Capacity: " + c.capacity + " | Enrolled: " + c.enrolledStudents.size());
                    }
                    break;

                case 2:
                    System.out.println("\nWhich course do you want to join? (Enter exact name): ");
                    String wantingCourse = input.nextLine();

                    boolean isCourseFound = false;

                    for (Course a : courseList) {
                        if (wantingCourse.equals(a.courseName)) {
                            isCourseFound = true;

                            if (a.enrolledStudents.size() >= a.capacity) {
                                System.out.println("This course is full. Registration failed.");
                                break; 
                            }

                            System.out.print("Enter student ID: ");
                            String id = input.nextLine();

                            boolean isDuplicate = false;
                            for (Student s : a.enrolledStudents) {
                                if (s.studentID.equals(id)) {
                                    isDuplicate = true;
                                    break;
                                }
                            }

                            if (isDuplicate) {
                                System.out.println("This student is already registered for this course.");
                                break;
                            }

                            System.out.print("Enter student name: ");
                            String name = input.nextLine();
                            
                            Student student = new Student(id, name);
                            a.enrolledStudents.add(student);
                            System.out.println("Registration successful.");
                            break;
                        }
                    }

                    if (!isCourseFound) {
                        System.out.println("No course found with that name.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- ALL COURSES DETAILED INFORMATION ---");
                    for (Course c : courseList) {
                        c.displayCourseInfo();
                        System.out.println("----------------------------------");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system. Have a great day!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
        
        input.close();
    }
}
        
    
    

