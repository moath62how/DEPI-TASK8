import java.util.*;
import personnel.Student;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

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
            System.out.println("Student add to list successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding student : " + e.getMessage());
        } catch (InputMismatchException e) {
            System.err.println("Please check your Inputs and try again");
        } catch (Exception e) {
            System.err.println("Oops... Unexpected exception Happend please try again!");
        }
    }

    static void deleteStudent() {
        try {
            System.out.print("Enter the SSN of the student to delete: ");
            String ssn = scanner.next();

            Student studentToDelete = null;
            for (Student student : studentList) {
                if (student.getSSN().equals(ssn)) {
                    studentToDelete = student;
                    break;
                }
            }

            if (studentToDelete != null) {
                studentList.remove(studentToDelete);
                System.out.println("Student with SSN " + ssn + " has been removed.");
            } else {
                System.out.println("Student not found with SSN: " + ssn);
            }
        } catch (Exception e) {
            System.err.println("Oops... Unexpected exception happened, please try again!");
        }
    }

    static void editStudent() {
        try {
            System.out.print("Enter the SSN of the student to edit: ");
            String ssn = scanner.next();

            Student studentToEdit = null;
            for (Student student : studentList) {
                if (student.getSSN().equals(ssn)) {
                    studentToEdit = student;
                    break;
                }
            }

            if (studentToEdit != null) {
                System.out.println("Student found: " + studentToEdit.getName());
                System.out.print("Enter new name (or leave empty to keep current): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    studentToEdit.setName(newName);
                }

                System.out.print("Enter new age (or enter 0 to keep current): ");
                byte newAge = scanner.nextByte();
                if (newAge != 0) {
                    studentToEdit.setAge(newAge);
                }

                System.out.print("Enter new current level (or enter 0 to keep current): ");
                byte newLevel = scanner.nextByte();
                if (newLevel != 0) {
                    studentToEdit.setCurrentLevel(newLevel);
                }

                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student not found with SSN: " + ssn);
            }
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please try again.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding student : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Oops... Unexpected exception happened, please try again!");
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
                case 2:
                    editStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;

            }
        } while (choice != 9);
        System.out.println("Exiting... Goodbye!");

    }

}
