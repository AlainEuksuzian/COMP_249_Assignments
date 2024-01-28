package A2.AgricolturalDrone;
import A2.UAV.UAV;

public class MAV extends UAV{
    private String model;
    private double size;

   // The `MAV(){}` is a default constructor for the `MAV` class. It is used to create an instance of
   // the `MAV` class without any parameters.
    public MAV(){}

    // The `MAV(double weight, double price, String model, double size)` is a constructor for the `MAV`
    // class that takes four parameters: `weight`, `price`, `model`, and `size`.
    public MAV(double weight, double price, String model, double size){
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    // The `MAV(MAV object)` constructor is a copy constructor for the `MAV` class. It takes an object
    // of the `MAV` class as a parameter and creates a new instance of the `MAV` class with the same
    // values for the `weight`, `price`, `model`, and `size` properties as the original object.
    public MAV(MAV object){
        super(object);
        this.model = object.model;
        this.size = object.size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "the Weight of the MAV:" + super.getWeight() +"\nThe price of the MAV: " + 
        super.getPrice() + "\nThe model of the MAV: " + this.model + "\nThe size of the MAV: " + this.size;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof MAV)){
            return false;
        }
        else {
            MAV otherobj = (MAV) obj;
            double epsilon = 0.00001;
            return this.model.equalsIgnoreCase(otherobj.model) && (this.size - otherobj.size < epsilon) && (this.getWeight() - otherobj.getWeight() < epsilon) && (this.getPrice() - otherobj.getPrice() < epsilon);
        }
    }
}
