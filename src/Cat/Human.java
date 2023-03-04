package Cat;

import GeoTREE.Gender;
import GeoTREE.Person;

import java.time.LocalDate;

public class Human extends Person {
    public Human(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender);
    }

    public Human(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Human(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Human(String firstName) {
        super(firstName);
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void pettingCat(Cat cat) {
        if (!cat.isHasCome()){
            System.out.println(this.getFirstName() + " идет гладить кота " + cat.getName());
            System.out.println("начал гладить");
        } else {
            System.out.println(cat.getName() + " рядом можно и погладить");
        }
        cat.purr();
    }


    public void callCat(Cat cat) {
        System.out.println(this.getFirstName() + " зовет кота " + cat.getName());
        cat.respondToCall(this);
    }

    public void feedCat(Cat cat) {
        if (!cat.isHasCome()){
            System.out.println(this.getFirstName() + " зовет кота " + cat.getName());
        } else {
            System.out.println(this.getFirstName() + " кормит кота");
        }
        cat.eat();
    }

    public void playWithCat(Cat cat) {
        if (!cat.isHasCome()){
            System.out.println(this.getFirstName() + " зовет поиграть " + cat.getName());
            cat.play();
        } else System.out.println(this.getFirstName() + " играет с котом " + cat.getName());
    }
}
