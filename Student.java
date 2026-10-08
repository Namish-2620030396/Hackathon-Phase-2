import java.util.Scanner;

public class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    public Student(String studentName, int rollNumber, double marks,
                   String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateScholarship() {
        double scholarshipRate;

        if (marks >= 85) {
            scholarshipRate = 0.25;
        } else if (marks >= 70) {
            scholarshipRate = 0.10;
        } else {
            scholarshipRate = 0.0;
        }

        return calculateFee() * scholarshipRate;
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\n--- Student Course Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligible for Registration: Yes");
        System.out.printf("Course Fee: Rs. %.2f%n", calculateFee());
        System.out.printf("Scholarship: Rs. %.2f%n", calculateScholarship());
        System.out.printf("Final Fee: Rs. %.2f%n", calculateFinalFee());
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int courseCredits = scanner.nextInt();

        Student student = new Student(
                studentName, rollNumber, marks, courseName, courseCredits
        );

        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for course registration.");
        }

        scanner.close();
    }
}
