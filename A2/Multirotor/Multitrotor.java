package A2.Multirotor;
import A2.Helicopter.Helicopter;

public class Multitrotor extends Helicopter{
    private int numberRotors;

    // empty constructor
    public Multitrotor(){}

    //constructor that sets inherited and locale instances
    public Multitrotor(String brand, double price, int horsePower,int cylinder, int creationYear, int passengerCapacity, int numRotator){
        super(brand, price, horsePower,cylinder, creationYear, passengerCapacity);
        this.numberRotors = numRotator;
    }

    

    // The code `Multitrotor(Multitrotor object)` is a constructor that creates a new `Multitrotor`
    // object by copying the values from another `Multitrotor` object.
    public Multitrotor(Multitrotor object){
        super(object);
        this.numberRotors = object.numberRotors;
    }

    /**
    * sets number of rotors to instance arguments
    */
    public void setNumberRotors(int numberRotors) {
        this.numberRotors = numberRotors;
    }

    /**
    * @return number of rotors
    */
    public int getNumberRotors() {
        return numberRotors;
    }

    /**
    * @return a desciption of all instances
    */
    @Override
    public String toString() {
        return "The brand is: " + super.getBrand() + 
        "\nThe price is: " + super.getPrice() + 
        "\nThe horse power is: " + super.getHorsePower() + 
        "\nThe cylinder is: " + super.getCylinders()+ 
        "\nThe creation Year is: " + super.getCreationYear() + 
        "\nThe paassenger Capacity is: " + super.getPassengerCapacity() +
         "\nThe max speed is: " + this.getNumberRotors();
    }

    /**
    * @param Object obj
    * @return True if same objects equality, false if different instance, or argumnet null or argument not instance of class
    */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof Multitrotor)){
            return false;
        }
        else {
            double epsilon = 0.00001;
            Multitrotor otherObj = (Multitrotor) obj;
            return 
            (super.getBrand().equalsIgnoreCase(otherObj.getBrand()) && 
            (super.getPrice() - otherObj.getPrice() < epsilon) && 
            (super.getHorsePower() == otherObj.getHorsePower()) &&
            (this.getCylinders() == otherObj.getCylinders()) && 
            (this.getCreationYear() == otherObj.getCreationYear()) && 
            (this.getPassengerCapacity() == otherObj.getPassengerCapacity()) && 
            (this.getNumberRotors() == otherObj.getNumberRotors()));
        }
    }
}
