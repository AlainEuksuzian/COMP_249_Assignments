package A4;

public class Course implements DirectlyRelatable{
    
    private String courseId;
    private String courseName;
    private double credit;
    private String preReqId;
    private String coReqId;


    /**
     * constructor to set all the manual argument inputs to instances of obj
     * @param id , @param name , @param cr , @param preReq , @param coReq
     */
    Course(String id, String name, double cr, String preReq, String coReq ){
        this.courseId = id;
        this.courseName = name;
        this.credit = cr;
        this.preReqId = preReq;
        this.coReqId = coReq;
    }

    /**
     * copy Constructor but unique String Id input 
     * @param object
     * @param id
     */
    Course(Course object, String id){
        this.courseId = id;
        this.courseName = object.courseName;
        this.credit = object.credit;
        this.preReqId = object.preReqId;
        this.coReqId = object.coReqId;
    }

    /**
     * sets argument to courseId instance
     * @param courseId
     */
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    /**
     * @return returns courseId instance
     */
    public String getCourseId() {
        return courseId;
    }

    /**
     * sets the argument to courseName instance
     * @param courseName
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseName instance
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * sets the argument to credit instance 
     * @param credit
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     * Returns the credit of the course.
     * 
     * @return the credit of the course
     */
public double getCredit() {
    return credit;
}

    /**
     * sets the argument to preReqId instance
     * @param preReqId
     */
    public void setPreReqId(String preReqId) {
        this.preReqId = preReqId;
    }

    /**
     * @return the preReqId instance
     */
    public String getPreReqId() {
        return preReqId;
    }

    /**
     * sets the argument to coReqId instance
     * @param coReqId
     */
    public void setCoReqId(String coReqId) {
        this.coReqId = coReqId;
    }

    /**
     * @return the coReqId instance
     */
    public String getCoReqId() {
        return coReqId;
    }

    /**
     * 
     * @param id as couse Id 
     * @return new object cloning the calling object except for a new/unique course Id (argument)
     */
    public Course clone(String id){
        return new Course(id, this.getCourseName(), this.getCredit(), this.getPreReqId(), this.getCoReqId());
    }

    /**
     * implement Interface methos
     * @return true if argument name is a prerequisite or corequisit to calling objects prerequ or coreq Instance
     */
    @Override
    public boolean isDirectlyRelated(Course C) {
        
        if (C == null){
            return false;
        }
        else {
            return ((C.getCourseName().equalsIgnoreCase(this.getPreReqId())) ||
                   (C.getCourseName().equalsIgnoreCase(this.getCoReqId()))) ;
        }


    }



    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "Course id: " + this.getCourseId() +
            "\nCourse Name: " + this.getCourseName() +
            "\nCredit unit: " + this.getCredit() +
            "\nClass PreRequisite: " + this.getPreReqId() +
            "\nClass CoRequisite: " + this.getCoReqId();
    }

    /**
     * @param Object 
     * @return true if 2 objects are equal except for courseId, false for any other possibility
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof Course)){
            return false;
        }
        else {
            double epsilon = 0.00001;
            Course otherObj = (Course) obj;
            return (this.getCourseName().equalsIgnoreCase(otherObj.getCourseName())) &&
                   (this.getCredit() - otherObj.getCredit() < epsilon) &&
                   (this.getPreReqId().equalsIgnoreCase(otherObj.getPreReqId())) &&
                   (this.getCoReqId().equalsIgnoreCase(otherObj.getCoReqId()));
        }
    }
}
