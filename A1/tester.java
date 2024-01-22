package A1;
import java.util.Scanner;
public class tester {
    private static Scanner keyboard = new Scanner(System.in);
    private static final String password = "password";
    public static void main(String[] args) {


    }



    private static boolean passwordCheck(String pwToCheck){
        return pwToCheck.equals(password);
    }


    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }
}
