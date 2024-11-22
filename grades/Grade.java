package grades;

import courses.Course;

public class Grade {
    private float grade;
    private Course course;

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        if (grade < 0.0 || grade > 100.0) {
            throw new IllegalArgumentException("Grade must be between 0.0 and 100.0.");
        }
        this.grade = grade;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
