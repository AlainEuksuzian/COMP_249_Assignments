package A1;
import java.util.Scanner;
public class tester {
    private static Scanner keyboard = new Scanner(System.in);
    private static final String password = "password";
    public static void main(String[] args) {

       Consumer obj1 = new Consumer("alain3", 1234, "toupin","mtl","h4k1z",30,"male","single","hs");

       Main.menuToChange(obj1);

    }



    private static boolean passwordCheck(String pwToCheck){
        return pwToCheck.equals(password);
    }


    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }
}
