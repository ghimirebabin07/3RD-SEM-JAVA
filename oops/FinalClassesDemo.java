class Parent {
    void show() {
        System.out.println("Parent class");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("Child class");
    }
}

final class FinalClass {
    void finalShow() {
        System.out.println("Final class");
    }
}

public class FinalClassesDemo {
    public static void main(String[] args) {

        // Using parent-child relationship
        Child childObj = new Child();
        childObj.show();      // inherited from Parent
        childObj.display();   // Child's own method

        // Using final class
        FinalClass finalObj = new FinalClass();
        finalObj.finalShow(); // call the method
    }
}
