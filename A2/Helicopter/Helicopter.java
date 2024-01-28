package A2.Helicopter;
import A2.Airplane.*;
import A2.FlyingObjectsInterface.FlyingObjects;

public class Helicopter extends Airplane implements FlyingObjects {

    private int cylinders;
    private int creationYear;
    private int passengerCapacity;

    public Helicopter(){}

    public Helicopter(String brand, double price, int horsePower,int cylinder, int creationYear, int passengerCapacity){
        super(brand, price, horsePower);
        this.cylinders = cylinder;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }

  
    public Helicopter(Helicopter object){
        super(object);
        this.cylinders = object.cylinders;
        this.creationYear = object.creationYear;
        this.passengerCapacity = object.passengerCapacity;
    }

    /**
     * The function sets the number of cylinders for a given object.
     * @param cylinders The "cylinders" parameter is an integer that represents the number of cylinders
     * in an engine.
     */
    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
    
    public int getCreationYear() {
        return creationYear;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }
    
    /**
     * @return String description of each object instances both local and inheriteds
     */
    @Override
    public String toString() {
        return "Helicopter Brand: " + super.getBrand() + "\nHelicopter price: " + super.getPrice() +
         "\nHelicopter HorsePower: " + super.getHorsePower() + "\nHelicopter cylinders: " + this.cylinders + 
         "\nHelicopter Creation Year:" + this.getCreationYear() + "\nHelicopter Passanger Capacity: " + this.passengerCapacity;
    }

    /**
     * @param Object
     * @return true if 2 objects have same instances, false Otherwise
     */
    @Override
    public boolean equals(Object obj) {
       if (obj == null){
        return false;
       }
       else if (!(obj instanceof Helicopter)){
        return false;
       }
       else {
        double epsilon = 0.00001;
        Helicopter otherObj = (Helicopter) obj;
        return (this.getBrand().equalsIgnoreCase(otherObj.getBrand()) && (this.getPrice() - otherObj.getPrice() < epsilon) && this.getHorsePower() == otherObj.getHorsePower() &&
        this.getCylinders() == otherObj.getCylinders() && this.getCreationYear() == otherObj.getCreationYear() && this.getPassengerCapacity() == otherObj.getPassengerCapacity());
       }
    }

}
