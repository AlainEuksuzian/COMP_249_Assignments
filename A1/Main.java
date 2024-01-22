package A1;
import java.util.Scanner;
public class Main {
    private static Scanner keyboard = new Scanner(System.in);
    private static final String password = "password";
    private static int numberOfConsumers = Integer.parseInt(getUserInput("\"Hello, welcome to the app!\nenter the number of consumers to store in DB: "));
    private static Consumer[] consumerDatabase = new Consumer[numberOfConsumers];
    private static int incorrectPasswordInput = 0;

    public static void main(String[] args) {

        while(true){
            int choice = userMenu();
        
            switch (choice) {
                case 1:
                    if (!optionOne()){
                        System.out.println("Program has detected suspicious activity and will terminate immediately!");
                        System.exit(0);
                    }
                    break;

                case 2:
                    optionTwo();
                    break;

                case 3:
                    int age = Integer.parseInt(getUserInput("enter age to query:"));
                    String gender = getUserInput("enter gender to query: ");
                    String education = getUserInput("enter education to query: ");
                    optionThree(age, gender, education);
                    break;

                case 4:
                    int ageQuery = Integer.parseInt(getUserInput("enter age to query: "));
                    String postalCode = getUserInput("enter postal code to query: ");
                    optionFour(ageQuery, postalCode);
                    break;

                case 5:
                    optionFive();
                    break;

                default:
                    System.out.println("invalid entry, try again");
                    break;
            }
        }
    }

    private static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }

    private static int userMenu(){
        int menuOption = Integer.parseInt(getUserInput("What do you want to do?\n1.Enter a new Consumer (password required)\n2.Change information of a Consumer (password required)\n3.Display all Consumers similar to a given consumer\n4.Display all Consumers with given age and location\n5.Quit\nPlease enter your choice >"));
        return menuOption;
    }

    
    private static boolean passwordCheck(String passwordInput){
        if (passwordInput.equals(password)){
            return true;
        }
        return false;
    }


    private static boolean userLogin(){
        while(incorrectPasswordInput < 12){
            int option = userMenu();
            if (option == 1){
                int tries = 0;
                while(tries < 3){
                    String pwQuery = getUserInput("enter the password to proceed:");
                    if (passwordCheck(pwQuery)){
                    return true;
                    }
                    else{
                        tries++;
                        System.out.println("incorrect password");
                    }
                    incorrectPasswordInput++;  
                }
            }
        }
        return false;
    }

    private static boolean optionOne(){

        boolean isLogged = userLogin();

        if (isLogged){
            int numberOfAdd = Integer.parseInt(getUserInput("enter the number of consumer you want to add: "));
                    
        if (numberOfAdd <= (consumerDatabase.length - Consumer.getNumberOfConsumers())){
            int counter = 0;
            while(counter < numberOfAdd){
                createConsumer();
                counter++;
            }
        }
        else {
            System.out.println("Will only add: " + (consumerDatabase.length - Consumer.getNumberOfConsumers()) + " as limit reached ");
            int counter = 0;
            while (counter < (consumerDatabase.length - Consumer.getNumberOfConsumers())){
                createConsumer();
                counter++;
            }
        }
        return true;
        }

        return false;
    }


    private static void createConsumer(){
        String name = getUserInput("enter the name of consumer to add: ");
        int streetNumber = Integer.parseInt(getUserInput("ente the street number: "));
        String city = getUserInput("enter the city name: ");
        String postalCode = getUserInput("enter the postal code to add: ");
        int age = Integer.parseInt(getUserInput("enter the age:"));
        String gender = getUserInput("enter the gender to add: ");
        String maritialStatus = getUserInput("enter the maritial status: ");
        String education = getUserInput("enter the education level: ");
        Consumer toAdd = new Consumer(name, streetNumber, city, postalCode, age, gender, maritialStatus, education);
        try{
            consumerDatabase[Consumer.getNumberOfConsumers() - 1] = toAdd;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.err.println(e.getMessage());
        }
    }


    // CHANGE VOID TO BOOLEAN
    private static void optionTwo(){
        boolean isLogged = false;
        int tries = 0;

        while (tries < 3 && !isLogged){
            String pwInput = getUserInput("enter the password to prioceed: ");
            if (passwordCheck(pwInput)){
                isLogged = true;
            }
            else{
                System.out.println("false input");
                tries++;
            }
        }
        if (!isLogged){
            System.out.println("program terminated due to safety reasons");
            System.exit(0);
        }
        else {
            System.out.println("you are logged in");
            // ADD CODE TO DO OPTION 2 AFTER LOGGED
        }

    }

    private static void optionThree(int age, String gender, String education){
        for (Consumer element : consumerDatabase ){
            if (element.getAge() == age && element.getGender() == gender && element.getEducation() == education){
                System.out.println(element);
            }
        }
    }

    private static void optionFour(int age, String postalCode){
        for (Consumer element : consumerDatabase){
            if (element.getAge() == age && element.getPostalCode() == postalCode){
                System.out.println(element);
            }
        }
    }

    private static void optionFive(){
        System.out.println("end of program");
        System.exit(0);
    }





}
