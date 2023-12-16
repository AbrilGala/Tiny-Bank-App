public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private char gender;
    private String nationality;
    private String address;

    //Constructor
    public Person(String firstName, String lastName, int age, char gender, String nationality, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
    }

    //Getters:
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        if(gender == 'm' || gender == 'M'){
            return "Male";
        } else if (gender == 'f' || gender == 'F'){
            return "Female";
        } else {
            return "Other gender";
        }
    }

    public String getNationality() {
        return nationality;
    }

    public String getAddress() {
        return address;
    }


    //Returns a person's personal data
    @Override
    public String toString() {
        return "First Name: "+firstName+"\n Last Name: "+lastName+"\n Age: "+age+"\n Gender: "+getGender()+"\n Nationality: "+nationality+"\n Address: "+address;
    }

}
