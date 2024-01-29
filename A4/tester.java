package A4;

public class tester {
   public static void main(String[] args) {
    Course firstCourse = new Course("12345", "oop2", 3, "comp248", "math201");

    Course secondCourse = firstCourse.clone("9999");

    Course thirdCourse = new Course("1233", "comp352", 3, "oop2", "oop3");

    System.out.println(thirdCourse.isDirectlyRelated(firstCourse));

   }

    
}
