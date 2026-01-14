 class animal {
    void eat() {
        System.out.println("eating...");
    }
}
class dog extends animal {
    void bark() {
        System.out.println("barking...");
    }
}
class puppy extends dog {
    void weep() {
        System.out.println("weeping...");
    }
}
public class multilevel {
    public static void main(String args[]) {
        puppy p = new puppy();
        p.weep();
        p.bark();
        p.eat();
    }
} 
