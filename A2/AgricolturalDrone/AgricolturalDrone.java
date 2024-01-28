package A2.AgricolturalDrone;
import A2.UAV.UAV;

public class AgricolturalDrone extends UAV{
    private String brand;
    private int carryCapacity;

    // The line `AgricolturalDrone(){}` is defining a default constructor for the `AgricolturalDrone`
    // class. However, the constructor is currently empty and does not contain any code.
    public AgricolturalDrone(){}

    // The code `AgricolturalDrone(double weight, double price, String brand, int carryCapacity)` is a
    // constructor for the `AgricolturalDrone` class. It takes four parameters: `weight`, `price`,
    // `brand`, and `carryCapacity`.
    public AgricolturalDrone(double weight, double price, String brand, int carryCapacity){
        super(weight,price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }

    // The code `AgricolturalDrone(AgricolturalDrone object)` is a copy constructor for the
    // `AgricolturalDrone` class. It creates a new instance of `AgricolturalDrone` by copying the
    // values from another `AgricolturalDrone` object.
    public AgricolturalDrone(AgricolturalDrone object){
        super(object);
        this.brand = object.brand;
        this.carryCapacity = object.carryCapacity;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    
    @Override
    public String toString() {
        return "This Agricoltural Drone is made by:" + this.brand + "\nThe weight is: " + super.getWeight() + "\nThe price is: " + super.getPrice() +"\nThe carry Capacity is: " + this.carryCapacity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof AgricolturalDrone)){
            return false;
        }
        else {
            double errorTerm = 0.00001;
            AgricolturalDrone otherObj = (AgricolturalDrone) obj;
            return (this.getWeight() - otherObj.getWeight() < errorTerm) && (this.getPrice() - otherObj.getPrice() < errorTerm) &&
            this.getBrand().equalsIgnoreCase(otherObj.getBrand()) && (this.getCarryCapacity() - otherObj.getCarryCapacity() < errorTerm);
        }
    }



}
