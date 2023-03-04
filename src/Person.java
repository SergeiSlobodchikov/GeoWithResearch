
import java.time.LocalDate;
import java.io.Serializable;


public class Person implements Serializable {

    public String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    public Person(String firstName) {
        this.firstName = firstName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public  Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate.toString();
    }

    public Gender getGender() {
        return gender;
    }

}



