package A1;
import java.util.Scanner;
public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static final String password = "password";
    public static void main(String[] args) {
        System.out.println("Hello, welcome to the app!");
        int numberOfConsumers = Integer.parseInt(getUserInput("enter the number of consumers to store in DB: "));
        Consumer[] consumerDatabase = new Consumer[numberOfConsumers];
        int option = userMenu();
    }

    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }

    public static int userMenu(){
        int menuOption = Integer.parseInt(getUserInput("What do you want to do?\n1.Enter a new Consumer (password required)\n2.Change information of a Consumer (password required)\n3.Display all Consumers similar to a given consumer\n4.Display all Consumers with given age and location\n5.Quit\nPlease enter your choice >"));
        return menuOption;
    }

    


}
