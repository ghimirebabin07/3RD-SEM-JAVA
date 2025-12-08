class Car {

   
    String brand;
    int year;


    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
    }

    public static void main(String[] args) {

       
        Car c1 = new Car();

       
        c1.brand = "Toyota";
        c1.year = 2020;

       
        c1.display();
    }
}
