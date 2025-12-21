class calculator{ 
    void add(int a, int b){ 
        System.out.println("Sum of two integers: " + (a + b)); 
    }
    void add(int a, int b, int c){ 
        System.out.println("Sum of three integers: " + (a + b + c)); 
    }

}
public class Overloading {
    public static void main(String args[]){ 
        calculator calc = new calculator(); 
        calc.add(10, 20); 
        calc.add(10, 20, 30); 
    }
}