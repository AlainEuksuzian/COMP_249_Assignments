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
        size++;
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

    /**
     * deletes a node either at head, tail or between 2 nodes. based on user argument location input
     * @param index location on node to delete
     */
    public void deleteFromIndex(int index){
        if (index < 0 || index > size -1){
            throw new NoSuchElementException("index out of bounds");
        }
        else if (index == 0){
            head = head.link;
            size--;
        }
        else if (index == size - 1){
            CourseNode position = head;
            CourseNode previous = null;

            for (int i = 0; i < size-1; i++){
                previous = position;
                position = position.link;
            }
            previous.link = null;
            position = null;
            size--;

        }
        else {
            CourseNode position = head;
            CourseNode previous = null;

            for (int i = 0; i < index ; i++){
                previous = position;
                position = position.link;
            }
            previous.link = position.link;
            size--;
        }
    }

    /**
     * deletes head node
     */
    public void deleteFromStart(){
        if (head != null){
            head = head.link;
        }
        else {
            throw new NoSuchElementException("No head node");
        }
    }

    /**
     * finds a node at index and replaces the object in node
     * @param course object to be added
     * @param index location to replace
     */
    public void replaceAtIndex(Course course, int index){
        if (index < 0 || index > size-1){
            System.out.println("invalid index entered");
            return;
        }
        else if (index == 0){
            head = new CourseNode(course, head.link);
        }
        else {
            CourseNode previous = null;
            CourseNode position = head;
    
            for (int i  =0; i < index; i++){
                previous = position;
                position = position.link;
            }
            CourseNode toAdd = new CourseNode(course, position.link);
            previous.link = toAdd;
        }
    }
    /**
     * loops through linked list and returns location (int) of node object that has the instance equal to argument
     * @param courseId object instance to search for
     * @return the index (location of node), null otherwise
     */
    public Integer find(String courseId){

        int location = 1;
        CourseNode position = head;

        while(position != null){
            if (position.course.getCourseId().equalsIgnoreCase(courseId)){
                return location;
            }
            position = position.link;
            location++;

        }
        return null;
    }

    /**
     * method to return true if argument matches the nodes objects instance
     * @param courseId String id to saerch for
     * @return true if mtach found, false otherwise
     */
    public boolean contains(String courseId){
        CourseNode position = head;

        while(position != null){
            if (position.course.getCourseId().equalsIgnoreCase(courseId)){
                return true;
            }
            position = position.link;
        }
        return false;
    }

    /**
     * checks if 2 linkedList are equal for the same Course object (except for course ID which is unique)
     * @param Object that will become another LinkedList
     * @return true if both linkedLists are equals, false otherwise
     */
    public boolean equals(Object object){
        if (object == null){
            return false;
        }
        else if (!(object instanceof CourseList)){
            return false;
        }
        
        else {
            CourseList otherLinkedList = (CourseList) object;
            if (otherLinkedList.size != this.size){
                return false;
            }
            else {
                CourseNode thisListPosition = this.head;
                CourseNode otherListPosition = otherLinkedList.head; 

                while(thisListPosition != null){
                    //involes the equls() overrided on Course class
                    if (!thisListPosition.course.equals(otherListPosition.course)){
                        return false;
                    }
                    thisListPosition = thisListPosition.link;
                    otherListPosition = otherListPosition.link;
                }
                return true;
            }
        }
    }

    /**
     * prints head for unit testing
     */
    public void printHead(){
        System.out.println(head.course);
    }

    /**
     * returns size of the linked list
     * @return int value indicating the size of the list
     */
    public int getSize(){
        return size;
    }

    /**
     * prints linked List
     */
    public void printList(){
        CourseNode position = head;

        while(position != null){
            System.out.println(position.course);
            System.out.println("_________________________");
            position = position.link;
        }
    }

    /**
     * returns course object at a specific node that matches course ID
     * @param id
     * @return 
     */
    public Course getObject(String id){
        CourseNode position = head;

        while(position != null){
            if (position.course.getCourseId().equalsIgnoreCase(id)){
                return position.course;
            }
            position = position.link;
        }
        return null;
    }
}