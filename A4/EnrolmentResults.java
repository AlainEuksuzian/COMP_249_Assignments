package A4;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;



public class EnrolmentResults {
    private static CourseList listOne = new CourseList();
    private static CourseList listTwo = new CourseList();
    private static Scanner inputStream = null;
    public static void main(String[] args) {

       inputStream = readFile("C:/Users/Alain E/Desktop/vscode-files/JAVA/comp249_assignments/A4/text_files/Syllabus.txt");
    
       Set<Course> uniqueCourses = ParseSyllabusFile(inputStream);
       loadLinkedListOne(uniqueCourses);

       System.out.println(listOne.contains("COMP201"));
       System.out.println("end");

    }

    public static Scanner readFile(String file){
        try{
            inputStream = new Scanner(new FileInputStream(file));
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return inputStream;
    }
    /*method arg: Scanner input
    loop through input and parse
    create course obj and add parsed data
    add course obj to set   .replaceAll("\\s+","")
    loop through set and add object to listOne */

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
               
                double credit = Double.parseDouble(parsedData[2]);
    
                Course course = new Course(parsedData[0], parsedData[1], credit, preCreqData, coReqData);
                uniqueCourses.add(course);
                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return uniqueCourses;
    }

    public static void loadLinkedListOne(Set<Course> uniqueCourses){
        Iterator<Course> itr = uniqueCourses.iterator();

        while (itr.hasNext()) {
            listOne.addToStart(itr.next());
        }
    }
}
