public class Doctor {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int age;
    private String specialty;


    public Doctor(String name, int age, String specialty) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
        this.id = ++idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public String getSpecialty() {
        return specialty;
    }

    //toString method to display the doctor's information
    @Override
    public String toString() {
        return "Doctor [ID: " + id + ", Name: " + name + ", Age: " + age + ", Specialty: " + specialty + "]";
    }
}