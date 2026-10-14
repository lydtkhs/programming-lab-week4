package week4;

public class Student {

    String studentID;
    String name;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public void studentInfo() {
        System.out.println("Student ID: " + studentID + ", Student's name: " + name);
    }
}

