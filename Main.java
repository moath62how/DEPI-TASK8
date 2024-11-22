import courses.Course;
import grades.Grade;
import java.util.*;
import personnel.Student;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();
    static ArrayList<Course> courseList = new ArrayList<>();
    static ArrayList<Grade> gradeList = new ArrayList<>();

    static void printGreetings() {
        System.out.println("Welcome to the XYZ Student Management System ");
    }

    static void addStudent() {
        try {
            System.out.print("Enter Student SSN: ");
            String ssn = scanner.next();

            System.out.print("Enter Student Name: ");
            String name = scanner.next();

            System.out.print("Enter Student Age: ");
            byte age = scanner.nextByte();

            System.out.print("Enter Student Current Level (1-12): ");
            byte currentLevel = scanner.nextByte();

            Student newStudent = new Student(ssn, name, age, currentLevel);
            studentList.add(newStudent);
            System.out.println("Student added to list successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding student: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Please check your Inputs and try again");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }

    static void addCourse() {
        try {
            System.out.print("Enter Course Code (e.g., BD112): ");
            String code = scanner.next();
            System.out.print("Enter Course Name: ");
            String name = scanner.next();
            Course newCourse = new Course();
            newCourse.setCode(code);
            newCourse.setName(name);
            courseList.add(newCourse);
            System.out.println("Course added successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding course: " + e.getMessage());
        }
    }

    static void editCourse() {
        System.out.print("Enter the course code to edit: ");
        String code = scanner.next();
        Course courseToEdit = null;
        for (Course course : courseList) {
            if (course.getCode().equals(code)) {
                courseToEdit = course;
                break;
            }
        }

        if (courseToEdit != null) {
            System.out.print("Enter new course name (or leave empty to keep current): ");
            scanner.nextLine();
            String newName = scanner.nextLine();
            if (!newName.trim().isEmpty()) {
                courseToEdit.setName(newName);
            }

            System.out.print("Enter new course code (or leave empty to keep current): ");
            String newCode = scanner.nextLine();
            if (!newCode.trim().isEmpty()) {
                courseToEdit.setCode(newCode);
            }

            System.out.println("Course updated successfully!");
        } else {
            System.out.println("Course not found with code: " + code);
        }
    }

    static void deleteCourse() {
        System.out.print("Enter the course code to delete: ");
        String code = scanner.next();
        Course courseToDelete = null;
        for (Course course : courseList) {
            if (course.getCode().equals(code)) {
                courseToDelete = course;
                break;
            }
        }

        if (courseToDelete != null) {
            courseList.remove(courseToDelete);
            System.out.println("Course with code " + code + " has been removed.");
        } else {
            System.out.println("Course not found with code: " + code);
        }
    }

    static void recordCourseGrade() {
        try {
            System.out.print("Enter student SSN: ");
            String ssn = scanner.next();

            Student student = null;
            for (Student s : studentList) {
                if (s.getSSN().equals(ssn)) {
                    student = s;
                    break;
                }
            }

            if (student != null) {
                System.out.print("Enter course code: ");
                String code = scanner.next();
                Course course = null;
                for (Course c : courseList) {
                    if (c.getCode().equals(code)) {
                        course = c;
                        break;
                    }
                }

                if (course != null) {
                    System.out.print("Enter grade (0-100): ");
                    float gradeValue = scanner.nextFloat();
                    Grade grade = new Grade();
                    grade.setGrade(gradeValue);
                    grade.setCourse(course);
                    student.addCourseGrade(grade);
                    gradeList.add(grade);
                    System.out.println("Grade recorded successfully!");
                } else {
                    System.out.println("Course not found.");
                }
            } else {
                System.out.println("Student not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error recording grade: " + e.getMessage());
        }
    }

    static void calculateTotalGrade() {
        System.out.print("Enter student SSN to calculate total grade: ");
        String ssn = scanner.next();
        Student student = null;
        for (Student s : studentList) {
            if (s.getSSN().equals(ssn)) {
                student = s;
                break;
            }
        }

        if (student != null) {
            float totalGrade = 0;
            for (Grade grade : student.getPastGradesList()) {
                totalGrade += grade.getGrade();
            }
            float averageGrade = totalGrade / student.getPastGradesList().size();
            System.out.println("Total grade for student " + student.getName() + ": " + totalGrade);
            System.out.println("Average grade: " + averageGrade);
        } else {
            System.out.println("Student not found.");
        }
    }

    static void printOptionMenu() {
        System.out.println("=================================");
        System.out.println("     Student Management Menu     ");
        System.out.println("=================================");
        System.out.println("1. Add Student");
        System.out.println("2. Edit Student");
        System.out.println("3. Delete Student");
        System.out.println("4. Add Course");
        System.out.println("5. Edit Course");
        System.out.println("6. Delete Course");
        System.out.println("7. Record Course Grade");
        System.out.println("8. Calculate Total Grade");
        System.out.println("9. Exit");
        System.out.println("=================================");
        System.out.print("Please select an option (1-9): ");
    }

    public static void main(String[] args) {
        printGreetings();
        byte choice;
        do {
            printOptionMenu();
            choice = scanner.nextByte();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 4:
                    addCourse();
                    break;
                case 5:
                    editCourse();
                    break;
                case 6:
                    deleteCourse();
                    break;
                case 7:
                    recordCourseGrade();
                    break;
                case 8:
                    calculateTotalGrade();
                    break;
                case 9:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 9);
    }
}
