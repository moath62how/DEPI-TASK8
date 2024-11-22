package personnel;

import courses.Course;
import grades.Grade;
import java.util.ArrayList;

final public class Student extends Person {
    private ArrayList<Course> enrolledCourseList = new ArrayList<>();
    private ArrayList<Grade> pastGradesList = new ArrayList<>();
    private byte currentLevel;

    public Student(String SSN, String name, byte age, byte currentLevel) throws IllegalArgumentException {
        super(SSN, name, age);
        setCurrentLevel(currentLevel);
    }

    @Override
    public void DisplayInfo() {
        System.out.println("Student's SSN: " + this.getSSN());
        System.out.println("Student's Name: " + this.getName());
        System.out.println("Student's Age: " + this.getAge());
    }

    public ArrayList<Course> getEnrolledCourseList() {
        return enrolledCourseList;
    }

    public void setEnrolledCourseList(ArrayList<Course> enrolledCourseList) {
        this.enrolledCourseList = enrolledCourseList;
    }

    public ArrayList<Grade> getPastGradesList() {
        return pastGradesList;
    }

    public void setPastGradesList(ArrayList<Grade> pastGradesList) {
        this.pastGradesList = pastGradesList;
    }

    public byte getCurrentLevel() {
        return currentLevel;
    }

    public void addCourseGrade(Grade grade) {
        this.pastGradesList.add(grade);
    }

    public void addCourse(Course course) {
        this.enrolledCourseList.add(course);
    }

    public void setCurrentLevel(byte currentLevel) throws IllegalArgumentException {
        if (currentLevel < 0 || currentLevel > 12) {
            throw new IllegalArgumentException("Your level must be between 1 and 12 .");
        }
        this.currentLevel = currentLevel;
    }

}
