class Student {

    String name;
    int age;

    // Default constructor
    Student() {
        name = "Manish";
        age = 18;
        System.out.println("Default constructor called");
    }

    // Parameterized constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Parameterized constructor called");
    }

    // Method to display details
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class Constructor_ba {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.display();

        System.out.println("----------------");

        Student s2 = new Student("Babin", 19);
        s2.display();
    }
}
