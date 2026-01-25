class DemoStudent {
    String name;
    int age;

    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        DemoStudent s1 = new DemoStudent();
        s1.name = "Babin";
        s1.age = 19;
        s1.display();
    }
}
