package A2.Main;

public class tester {
    public static void main(String[] args) {
        int[] arr = {11,2,3,4,5,6,7,-10,-10,10};
        int cheapest = arr[0];
        int secondCheapest= arr[1];

        for (int i =0; i < arr.length; i++){
            if (arr[i] < cheapest){
                secondCheapest = cheapest;
                cheapest = arr[i];
            }
        }

        System.out.println(cheapest);
        System.out.println(secondCheapest);

        
    }
}
