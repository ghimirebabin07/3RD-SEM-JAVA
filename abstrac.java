abstract class vehhicale {
    abstract void start();

    void fueltype(){
        System.out.println("Vechicale use the fule");

    }

}
class car extends vehhicale{
    public void start(){
        System.out.println("Car started");

    }

    public static void main(String args[]){
        car c = new car();
        c.fueltype();
        c.start();
    }

}
