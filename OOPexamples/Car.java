package OOPexamples;

public class Car {

    private String make;
    private String model;
    private String color;
  
    public Car(String make, String model, String color) {
      this.make = make;
      this.model = model;
      this.color = color;
    }
  
    public void startEngine() {
      System.out.println("\nStarting the engine...");
    }
  
    public void drive() {
      System.out.println("Driving the car...");
    }
  
    public void setColor(String color) {
      this.color = color;
    }
  
    public String getColor() {
      return color;
    }
  
    public String getMake() {
      return make;
    }
  
    public String getModel() {
      return model;
    }
  
  }
