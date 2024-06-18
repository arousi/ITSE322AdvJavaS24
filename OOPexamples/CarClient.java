package OOPexamples;

public class CarClient {

    public static void main(String[] args) {
        // *notice that we are defining the Car with a Red colo
        Car myCar = new Car("Toyota", "Camry", "Red");

        myCar.startEngine();

        myCar.drive();
        // *But here we will change it using sets of that class called Car
        myCar.setColor("Blue");

        System.out.println("Car details:");
        System.out.println("Make: " + myCar.getMake());

        System.out.println("Model: " + myCar.getModel());

        System.out.println("Color: " + myCar.getColor());

        // **Ghost ))
        myCar.setColor("Transparent");
        System.out.println("Color: " + myCar.getColor());

    }

}
