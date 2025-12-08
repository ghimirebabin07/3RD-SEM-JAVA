class Student {
    String name;
    int age;
    int rollNo;

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Roll No: " + rollNo);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Babin";
        s.age = 20;
        s.rollNo = 5;
        s.display();
    }
}
