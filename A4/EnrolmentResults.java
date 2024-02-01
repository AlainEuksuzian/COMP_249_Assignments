package A4;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;



public class EnrolmentResults {
    private static CourseList listOne = new CourseList();
    private static CourseList listTwo = new CourseList();

    private static Scanner inputStreamSyllabus = null;
    private static Scanner inpustreamRequest = null;

    private static Scanner keyboard = new Scanner(System.in);

    private static ArrayList<String> requestedCourses = new ArrayList<>();
    private static ArrayList<String> finishedCourses = new ArrayList<>();


    public static void main(String[] args) {

        inputStreamSyllabus = readFile("C:/Users/Alain E/Desktop/vscode-files/JAVA/comp249_assignments/A4/text_files/Syllabus.txt");
    
       Set<Course> uniqueCourses = ParseSyllabusFile(inputStreamSyllabus);
       loadLinkedListOne(uniqueCourses);
        
       String fileChoice = "Request.txt";    
       inpustreamRequest = readFileRequest("C:\\Users\\Alain E\\Desktop\\vscode-files\\JAVA\\comp249_assignments\\A4\\text_files\\"+ fileChoice);
       parseRequestTxt();

       


    }
    /**
    * This method is used to parse the request.txt file and extract the courses that have been requested
     and the courses that have been finished.
    */
    public static void parseRequestTxt(){
        String data = "";
        while(inpustreamRequest.hasNext()){
           data += inpustreamRequest.nextLine() + " ";
        }
        
        int requestedStart = data.indexOf(" ");
        int requestedEnd = data.indexOf("Requested");
  
        String allRequested = data.substring(requestedStart+1, requestedEnd);
        String[] requestedClasses = allRequested.split(" ");

        int wordLength = "Requested".length();

        String finished = data.substring(requestedEnd+wordLength+1);
        String[] finishedClasses = finished.split(" ");
  
        for (String e: finishedClasses){
            requestedCourses.add(e);
        }

        for (String e : requestedClasses){
            finishedCourses.add(e);
        }
    }


    /**
     * Reads the contents of a file and returns it as a Scanner object.
     * @param file the path of the file to be read
     * @return a Scanner object that contains the contents of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    public static Scanner readFileRequest(String file){
        try{
            inpustreamRequest = new Scanner(new FileInputStream(file));
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return inpustreamRequest;
    }

    /**
     * Reads the contents of a file and returns it as a Scanner object.
     *
     * @param file the path of the file to be read
     * @return a Scanner object that contains the contents of the file
     * @throws FileNotFoundException if the file cannot be found
     */
    public static Scanner readFile(String file){
        try{
            inputStreamSyllabus = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return inputStreamSyllabus;
    }


    /**
     * This method is used to parse the syllabus file and extract the courses and their details.
     * @param inputStream the input stream of the syllabus file
     * @return the set of unique courses
     */
    public static Set<Course> ParseSyllabusFile(Scanner inputStream){

        Set<Course> uniqueCourses = new HashSet<Course>();

        try{
            while(inputStream.hasNext()){
                String courseData = inputStream.nextLine();
                String preReq = inputStream.nextLine();
                String coReq = inputStream.nextLine();
                inputStream.nextLine(); // skip empty Line
    
                String[] parsedData = courseData.split("\\s+");
                String preCreqData = "";
                String coReqData = "";
    
                if (preReq.length() == 1){
                    preCreqData = null;
                }
                else {
                    String preReqLocal = preReq.substring(1);
                    preCreqData = preReqLocal.replaceAll("\\s+","");
                }
                if (coReq.length() == 1){
                    coReqData = null;
                }
                else {
                    String coReqLocal = coReq.substring(1);
                    coReqData = coReqLocal.replaceAll("\\s+","");
                }
               
                Course course = new Course(parsedData[0], parsedData[1], Double.parseDouble(parsedData[2]), preCreqData, coReqData);
                uniqueCourses.add(course);
                
            }
        }
        catch(Exception e){
            //do nothing
        }
        return uniqueCourses;
    }

    /**
     * This method is used to load the courses from the syllabus file into a linked list.
     *
     * @param uniqueCourses the set of unique courses
     */
    public static void loadLinkedListOne(Set<Course> uniqueCourses){
        Iterator<Course> iterator = uniqueCourses.iterator();

        while (iterator.hasNext()) {
            listOne.addToStart(iterator.next());
        }
    }

    /**
     * This method is used to get user input from the console.
     * @param message the message to be displayed to the user
     * @return the user input
     */
    public static String getUserInput(String message){
        System.out.print(message);
        return keyboard.nextLine();
    }
}
