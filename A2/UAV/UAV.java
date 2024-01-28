package A2.UAV;

import A2.FlyingObjectsInterface.FlyingObjects;

public class UAV implements FlyingObjects {
    private double weight;
    private double price;

    public UAV(){}

    
    /**
     * The UAV function is a constructor that creates an object of the UAV class.
     * @param double weight Set the weight of the uav
     * @param double price Set the price of the uav
     * @return A uav object
     * @docauthor Alain 
     */
    public UAV(double weight, double price){
        this.weight = weight;
        this.price = price;
    }

    /**
     * The UAV function is a copy constructor that creates an object of the UAV class.
     * @param UAV object Create a new uav object
     * @return A uav object
     * @docauthor Alain
     */
    public UAV(UAV object){
        this.weight = object.weight;
        this.price = object.price;
    }


    /**
    * set weight instance
    */
    public void setWeight(double weight) {
        this.weight = weight;
    }


    /**
    * @return weight instance
    */
    public double getWeight() {
        return weight;
    }

    /**
    * sets price instance
    */
    public void setPrice(double price) {
        this.price = price;
    }


    /**
    * @return price instance
    */
    public double getPrice() {
        return price;
    }

    /**
    * @return a string sentence explaining all instances of obj
    */
    @Override
    public String toString() {
        return "this UAV weights: " + this.weight + "\nIt costs: " + this.price ;
    }

    /**
     * @param Object obj superclass of classes
     * @return true of 2 objects equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        else if (!(obj instanceof UAV)){
            return false;
        }
        else {
            double epsilon = 0.00001;

            UAV otherObj = (UAV) obj;
            return (this.weight - otherObj.weight < epsilon) && 
            (this.price - otherObj.price <epsilon);
        }
    }
}
