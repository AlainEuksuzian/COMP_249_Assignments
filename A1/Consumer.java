package A1;

/* */
public class Consumer {

    private String name;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private int age;
    private String gender;
    private String martialStatus;
    private String education;

    private static int numberOfCustomers = 0;
    private static final String[] MaritalStatus = {"Single","Married","Divorsed"};
    private static final String[] Education = {"HS","College","University"};

    Consumer(String name,int streetNumber,String city,String postalCode,int age,String gender, String martialStatus,String education){
        this.name = name;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.age = age;
        this.gender = gender;
        this.martialStatus = martialStatus;
        this.education = education;
        numberOfCustomers++;
    }


    /**
     * seets name of object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return name of object
     */
    public String getName() {
        return name;
    }

    /**
     * sets streen number of object
     * @param streetNumber
     */
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    /**
     * @return street number of obj
     */
    public int getStreetNumber() {
        return streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setMartialStatus(String martialStat) {
        if (containsMaritial(martialStat)){
            this.martialStatus = martialStat;
            return;
        }
        System.out.println("invalid option entered");
        
    }



    public String getMartialStatus() {
        return martialStatus;
    }

    public void setEducation(String education) {
        if (containsEducation(education)){
            this.education = education;
            return;
        }
        System.out.println("invalid option entered");
    }

    public String getEducation() {
        return education;
    }

    public int getNumberOfConsumers(){
        return numberOfCustomers;
    }

    @Override
    public String toString() {
        return "Streen number: " + this.streetNumber + "\nStreet Name" + this.streetName + "\nCity: " + this.city +
         "\nPostal Code: " + this.postalCode+
        "\nAge: " + this.age + "\nGender: " + this.gender + "\nMaritial Status: " 
        + this.martialStatus +  "\nEducation: " + this.education;
    
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        else if (!(obj instanceof Consumer)){
            return false;
        }
        else {
            Consumer otherObj = (Consumer) obj;
            return  this.streetNumber == otherObj.streetNumber && this.streetName.equalsIgnoreCase(otherObj.streetName) 
            &&this.city.equalsIgnoreCase(otherObj.city) && this.postalCode.equalsIgnoreCase(otherObj.postalCode) 
            && this.age == otherObj.age && this.gender.equalsIgnoreCase(otherObj.gender) && this.martialStatus.equals(otherObj.martialStatus)
            && this.education.equals(otherObj.education);
        }
    }

    private static boolean containsMaritial(String userInput){

        for (int i = 0; i < MaritalStatus.length; i++){
            if (MaritalStatus[i].equalsIgnoreCase(userInput)){
                return true;
            }
        }
        return false;
    }

    private static boolean containsEducation(String userInput){
        for (int i = 0; i < Education.length; i++){
            if (Education[i].equalsIgnoreCase(userInput)){
                return true;
            }
        }
        return false;
    }






}