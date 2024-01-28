package A2.Airplane;

public class Airplane {
    private String brand;
    private double price;
    private int horsePower;

    /**empty Constructor */
    public Airplane(){}

    /**
     * constructor for all instances
     * @param brand
     * @param price
     * @param horsePower
     */
    public Airplane(String brand, double price, int horsePower){
        this.brand = brand;
        this.price = price;
        this.horsePower = horsePower;
    }

    /**
     * copy constructor 
     * @param object
     */
    public Airplane(Airplane object){
        this.brand = object.brand;
        this.price = object.price;
        this.horsePower = object.horsePower;
    }

    /**
     * setter method for brand of airplane
     * @param brand -> String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * getter method for brand
     * @return brand -> String
     */
    public String getBrand() {
        return brand;
    }

      /**
     * setter method for price of airplane
     * @param price -> double
     */
    public void setPrice(double price) {
        this.price = price;
    }

        /**
     * getter method for price
     * @return price -> double
     */
    public double getPrice() {
        return price;
    }

      /**
     * setter method for horsePower of airplane
     * @param horsePower -> int
     */
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

        /**
     * getter method for brand
     * @return horsepower -> int
     */
    public int getHorsePower() {
        return horsePower;
    }

   /**
    * @return String explanation of object
    */
    @Override
    public String toString() {
        return "Airplane brand: " + this.getBrand() +"\nAirplane price:" + this.getPrice() + "\nAirplane HorsePower: " + this.getHorsePower();
    }

    /**
     * @param Object
     * @return true if 2 objects have same instances, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Airplane)){
            return false;
        }
        else{
            Airplane otherObj = (Airplane) obj;
            return this.brand.equalsIgnoreCase(otherObj.brand) && this.price == otherObj.price && this.horsePower == otherObj.horsePower;
        }
    }

}
