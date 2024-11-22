package courses;

import personnel.Instructor;

final public class Course {
    private String code;
    private String name;
    private Instructor instructor;

    public final String getCode() {
        return code;
    }

    public final void setCode(String code) {
        String regex = "^(BD|AD|SD)[1-12]\\d{2}$";
        if (code == null || !code.matches(regex)) {
            throw new IllegalArgumentException("Invalid code: " + code);
        }
        this.code = code;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty() || !name.matches("[A-Za-z0-9 ]+")) {
            throw new IllegalArgumentException(
                    "Invalid course name. It must contain only letters, numbers, and spaces.");
        }
        this.name = name.trim();
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

}
