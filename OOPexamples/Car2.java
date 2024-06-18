package OOPexamples;

public class Car2 {
    private String make;
    private String model;
    private String color;
    // Constructor
    public Car2(String make, String model, String color) {
    this.make = make;
    this.model = model;
    this.color = color;
    }
    // Getters and setters for attributes
    public String getMake() {
    return make;
    }
    public void setMake(String make) {
    this.make = make;
    }
    public String getModel() {
    return model;
    }
    public void setModel(String model) {
    this.model = model;
    }
    public String getColor() {
    return color;
    }
    public void setColor(String color) {
    this.color = color;
    }
     // Other methods
 public void startEngine() {
    // Code to start the car's engine
    }
    public void drive() {
    // Code to control the car's movement
    }
   }