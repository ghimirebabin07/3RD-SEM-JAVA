class Parent {
    void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child class method");
    }
}

public class Main1 {
    public static void main(String[] args) {
        Parent obj = new Child(); // Runtime polymorphism
        obj.show();
    }
}
