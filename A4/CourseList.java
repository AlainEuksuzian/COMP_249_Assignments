package A4;
import java.util.NoSuchElementException;

public class CourseList {
    
    private class CourseNode{
        private Course course;
        private CourseNode link;

        /**
         * empty constructor to set both instances to null
         */
        CourseNode(){
            this.course = null;
            this.link = null;
        }

        /**
         * parametarized constructor to set both instances
         * @param obj
         * @param node
         */
        CourseNode(Course obj, CourseNode node){
            this.course = obj;
            this.link = node;
        }

        /**
         * copy constructor 
         * @param object
         */
        CourseNode(CourseNode object){
            this.course = object.course;
            this.link = object.link;
        }

        /**
         * creates a new Node of type copy
         */
        public CourseNode clone(){
            return new CourseNode(this.course, this.link);
        }

        /**
         * sets argument to course instance, setter method
         * @param course
         */
        public void setCourse(Course course) {
            this.course = course;
        }

        /**
         * returns course instance, getter method
         * @return
         */
        public Course getCourse() {
            return course;
        }

        /**
         * sets node to argument, setter method
         * @param link
         */
        public void setLink(CourseNode link) {
            this.link = link;
        }

        /**
         * returns link instance getter method
         * @return
         */
        public CourseNode getLink() {
            return link;
        }
    } // END OF INNER CourseNode Class

    private CourseNode head;
    private int size;

    /**empty construtor */
    CourseList(){}

    /**
     * copy constructor 
     * @param object
     */
    CourseList(CourseList object){
        this.head = object.head;
        this.size = object.size;
    }

    /**
     * adds a new node with Course data type to head
     * @param object containting course data
     */
    public void addToStart(Course object){
        head = new CourseNode(object, head);
    }


    /**
     * inserts a new Node at a chosen index from user, throws NoSuchElementException if index (location) out of bounds
     * @param index for location to be added
     * @param object the data type to be added
     */
    public void insertAtIndext(int index, Course object){
        if (index < 0 || index > size-1){
            throw new NoSuchElementException("the index size is not valid");
        }
        else if (index == 0){
            //here
            head = new CourseNode(object, head);
            size++;
        }
        else if (index == size -1){
            CourseNode position = head;

            for (int i = 0; i < size - 1; i++){
                position = position.link;
            }
            CourseNode toAdd = new CourseNode(object, null);
            position.link = toAdd;
            size++;
        }
        else {
            CourseNode previous = null;
            CourseNode position = head;

            for (int i = 0; i < index; i++){
                previous = position;
                position = position.link;
            }
            CourseNode toAdd = new CourseNode(object, position);
            previous.link = toAdd;
            previous = toAdd;
            size++;
        }
    }
}