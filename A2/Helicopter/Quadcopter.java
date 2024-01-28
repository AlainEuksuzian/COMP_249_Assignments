package A2.Helicopter;

public class Quadcopter extends Helicopter{

    private int maxFlyingSpeed;

    public Quadcopter(){}

    // The code you provided is a constructor for the `Quadcopter` class. It takes several parameters
    // (`brand`, `price`, `horsePower`, `cylinder`, `creationYear`, `passengerCapacity`, `maxSpeed`) and
    // initializes the `Quadcopter` object with those values.
    public Quadcopter(String brand, double price, int horsePower,int cylinder, int creationYear, int passengerCapacity, int maxSpeed){
        super(brand, price,horsePower,cylinder,creationYear,passengerCapacity);
        this.maxFlyingSpeed = maxSpeed;
    }

    // 1.00000001
    // The code you provided is a copy constructor for the `Quadcopter` class. It takes an object of type
    // `Quadcopter` as a parameter and creates a new `Quadcopter` object with the same values as the passed
    // object.
    public Quadcopter(Quadcopter object){
        super(object);
        this.maxFlyingSpeed = object.maxFlyingSpeed;
    }

   /**
    * The function sets the maximum flying speed for an object.
    * @param maxFlyingSpeed The maxFlyingSpeed parameter is an integer that represents the maximum
    * flying speed.
    */
    public void setMaxFlyingSpeed(int maxFlyingSpeed) {
        this.maxFlyingSpeed = maxFlyingSpeed;
    }


    /**
     * The getMaxFlyingSpeed() function returns the maximum flying speed.
     * @return The method is returning the value of the variable "maxFlyingSpeed".
     */
    public int getMaxFlyingSpeed() {
        return maxFlyingSpeed;
    }

    @Override
    public String toString() {
        return "The brand is: " + super.getBrand() + "\nThe price is: " + super.getPrice() + "\nThe horse power is: " + super.getHorsePower() + "\nThe cylinder is: " + super.getCylinders()
        + "\nThe creation Year is: " + super.getCreationYear() + "\nThe paassenger Capacity is: " + super.getPassengerCapacity() + "\nThe max speed is: " + this.getMaxFlyingSpeed();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof Quadcopter)){
            return false;
        }
        else {
            double epsilon = 0.00001;
            Quadcopter otherObj = (Quadcopter) obj;
            return 
            (super.getBrand().equalsIgnoreCase(otherObj.getBrand()) && 
            (super.getPrice() - otherObj.getPrice() < epsilon) && 
            (super.getHorsePower() == otherObj.getHorsePower()) &&
            (this.getCylinders() == otherObj.getCylinders()) && 
            (this.getCreationYear() == otherObj.getCreationYear()) && 
            (this.getPassengerCapacity() == otherObj.getPassengerCapacity()) && 
            (this.getMaxFlyingSpeed() == otherObj.getMaxFlyingSpeed()));
        }
    }

}
