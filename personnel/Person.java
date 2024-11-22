package personnel;

public abstract class Person {

    private String SSN;
    private String name;
    private byte age;

    public Person(String SSN, String name, byte age) throws IllegalArgumentException {
        setSSN(SSN);
        setName(name);
        setAge(age);
    }

    public final String getSSN() {
        return SSN;
    }

    public final void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) throws IllegalArgumentException {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else
            this.name = name;
    }

    public final byte getAge() {
        return age;
    }

    public final void setAge(byte age) throws IllegalArgumentException {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero");
        } else
            this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "SSN='" + SSN + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract void DisplayInfo();
}
