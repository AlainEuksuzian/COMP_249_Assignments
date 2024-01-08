package comp249_assignments.A1;

/* */
public class Consumer {

        enum MaritalStatus{
        Single,
        Married,
        Divorsed
    };
        enum Education{
        HS,
        College,
        University
    };

    private String name;
    private int streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private int age;
    private String gender;
    private MaritalStatus martialStatus;
    private Education education;

    private static int numberOfCustomers = 0;

    Consumer(String name,int streetNumber,String city,String postalCode,
    int age,String gender, MaritalStatus martialStatus,Education education){
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

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

    public void setMartialStatus(MaritalStatus martialStatus) {
        this.martialStatus = martialStatus;
    }
    public MaritalStatus getMartialStatus() {
        return martialStatus;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Education getEducation() {
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



}
