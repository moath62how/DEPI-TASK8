package personnel;

final public class Instructor extends Person {

    private float Monthlysalary;

    public Instructor(String SSN, String name, byte age, float Monthlysalary) throws Exception {
        super(SSN, name, age);
        setMonthlysalary(Monthlysalary);
    }

    @Override
    public void DisplayInfo() {
        System.out.println("Instructor's SSN: " + this.getSSN());
        System.out.println("Instructor's Name: " + this.getName());
        System.out.println("Instructor's Age: " + this.getAge());
        System.out.println("Instructor's Salary: " + this.getMonthlysalary());
    }

    public final float getMonthlysalary() {
        return Monthlysalary;
    }

    public final void setMonthlysalary(float Monthlysalary) {
        if (Monthlysalary < 0) {
            throw new IllegalArgumentException("Monthlysalary cannot be negative");
        } else
            this.Monthlysalary = Monthlysalary;
    }

}
