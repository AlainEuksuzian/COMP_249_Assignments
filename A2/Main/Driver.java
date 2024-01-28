package A2.Main;

import java.util.HashSet;
import java.util.Set;
import A2.AgricolturalDrone.AgricolturalDrone;
import A2.AgricolturalDrone.MAV;
import A2.FlyingObjectsInterface.FlyingObjects;
import A2.Helicopter.Helicopter;
import A2.Helicopter.Quadcopter;
import A2.Multirotor.Multitrotor;
import A2.UAV.UAV;

public class Driver {
    private static FlyingObjects[] allFlyingObjects = new FlyingObjects[15];

    /**
     * copies an array of descendant to Objects to a new Object and returns it
     * @param array of type Object
     * @return copyArray of type Object
     */
    public static Object[] copyFlyingObjects(Object[] array){
        Object[] copiedArray = new Object[array.length];

        for (int i = 0; i < array.length; i++){
            Object element = array[i];

            if (element instanceof Helicopter){
                copiedArray[i] = new Helicopter((Helicopter) element);
            }
            else if (element instanceof Quadcopter){
                copiedArray[i] = new Quadcopter((Quadcopter) element);
            }
            else if (element instanceof AgricolturalDrone){
                copiedArray[i] = new AgricolturalDrone((AgricolturalDrone) element);
            }
            else if (element instanceof MAV){
                copiedArray[i] = new MAV((MAV) element);
            }
            else if (element instanceof Multitrotor){
                copiedArray[i] = new Multitrotor((Multitrotor) element);
            }
            else if (element instanceof UAV){
                copiedArray[i] = new UAV((UAV) element);
            }
        }
        return copiedArray;
    }
    public static void main(String[] args) {
        
        fillArray();
        printArray();

        //checks if 2 objects are equal
        objectEquality();
        
        Object[] copiedFlyingObjectArray = copyFlyingObjects(allFlyingObjects);

        for (Object e: copiedFlyingObjectArray){
            System.out.println(e);
            System.out.println("--------------------------");
        }
        System.out.println("________________END__________________");

        System.out.println("THE TWO CHEAPEAST FLYING OBJECTS ARE: ");
        // gets 2 cheapest prices items
        for (FlyingObjects e : twoCheapeastObjects()){
            System.out.println(e);
            System.out.println("__________________");
        }

    }

    /**
     * loops through the flyingObject array and finds 2 cheapest items
     * @return an array of double where first element cheapeast price, second element 2nd cheapest
     */
    private static FlyingObjects[] twoCheapeastObjects(){  

        FlyingObjects cheapestObj = allFlyingObjects[0];
        FlyingObjects secondCheapestObj = allFlyingObjects[1];
        
        for (int i = 2; i < allFlyingObjects.length; i++){
            if (allFlyingObjects[i].getPrice() < cheapestObj.getPrice()){
                secondCheapestObj = cheapestObj;
                cheapestObj = allFlyingObjects[i];
            }
        }
        return new FlyingObjects[] {cheapestObj,secondCheapestObj};

    }

    /**
     * Checks for object equality among the FlyingObjects in the array.
     * This method iterates over the array of FlyingObjects and compares each object
     * with every other object to find instances with the same properties. If such instances
     * are found, they are printed to the console, and only one instance is added to the set
     * to avoid duplicate printing.
     */
    private static void objectEquality(){
        Set<FlyingObjects> uniqueSets = new HashSet<>();

        for (int i =0; i < allFlyingObjects.length; i++){
            for (int k = i + 1; k < allFlyingObjects.length; k++){
                if (!uniqueSets.contains(allFlyingObjects[i]) && allFlyingObjects[i].equals(allFlyingObjects[k]) && i != k){
                    System.out.println(allFlyingObjects[k]);
                    System.out.println("-----------------------------");
                    uniqueSets.add(allFlyingObjects[i]);
                }
            }
        }
    }

    /**
     * fills rray with manually created objects of all types
     */
    private static void fillArray(){
         // manual array creation
         allFlyingObjects[0] = new Helicopter("honda", 1000, 120, 7, 2020, 5);
         allFlyingObjects[1] = new Helicopter("honda", 1300, 100, 7, 2021, 8);
         allFlyingObjects[2] = new Quadcopter("toyota", 500, 200, 4, 20023, 5, 220);
         allFlyingObjects[3] = new Quadcopter("toyota", 500, 200, 4, 20023, 5, 220);
         allFlyingObjects[4] = new Multitrotor("multi", 220, 550, 3, 1990, 10, 7);
         allFlyingObjects[5] = new Multitrotor("multi", 200, 550, 3, 1990, 10, 7);
         UAV uavOne = new UAV(500, 200);
         allFlyingObjects[6] = uavOne;
         allFlyingObjects[7] = new UAV(uavOne);
         allFlyingObjects[8] = new UAV(1111, 4440);
         AgricolturalDrone aggDroneOne = new AgricolturalDrone(200, 100, "crop", 1);
         allFlyingObjects[9] = aggDroneOne;
         allFlyingObjects[10] = new AgricolturalDrone(aggDroneOne);
         allFlyingObjects[11] = new AgricolturalDrone(200, 100, "crop", 1);
         MAV mavOne = new MAV(230, 110, "mavBrand", 20);
         allFlyingObjects[12] = mavOne;
         allFlyingObjects[13] = new MAV(mavOne);
         allFlyingObjects[14] = new MAV(3333, 1110, "civic", 10);
    }

    private static void printArray(){
        for (FlyingObjects obj : allFlyingObjects){
            System.out.println(obj);
            System.out.println("----------------------------------------");
        }
    }
}
