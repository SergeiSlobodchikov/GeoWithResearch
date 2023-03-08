package Pet;

import GeoTREE.Gender;
import GeoTREE.Person;

import java.time.LocalDate;

public class Human extends Person {
    private int whereHuman;
    public Human(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender);
        this.whereHuman = 1;

    }
    public Human(String firstName, String lastName) {
        super(firstName, lastName);
        this.whereHuman = 1;
    }
    public Human(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
        this.whereHuman = 1;
    }
    public Human(String firstName) {
        super(firstName);
        this.whereHuman = 1;
    }

    public int getWhereHuman() {
        return whereHuman;
    }

    public void pettingCats(Cat cat) {
        if (!cat.isHasCome()){
            System.out.println(this.getFirstName() + " идет гладить кота " + cat.getName());
            System.out.println("начал гладить");
        } else {
            System.out.println(cat.getName() + " рядом можно и погладить");
        }
        cat.purr();
    }


    public void callPets(Pets pets) {
        System.out.println(this.getFirstName() + " зовет " + pets.getName());
        pets.respondToCall(this);
    }

    public void feedPets(Pets pets) {
        if (!pets.isHasCome()){
            System.out.println(this.getFirstName() + " зовет покормить " + pets.getName());
        } else {
            System.out.println(this.getFirstName() + " кормит " + pets.getName());
        }
        pets.eat();
    }

    public void playWithPets(Pets pets) {
        if (!pets.isHasCome()){
            System.out.println(this.getFirstName() + " зовет поиграть " + pets.getName());
            pets.play();
        } else System.out.println(this.getFirstName() + " играет с " + pets.getName());
    }

    public void goingWalkDog(Dog dog){
        if (!dog.isHasCome()){
            System.out.println(this.getFirstName() + " ищет " + dog.getName() + " чтобы выгулять");
            System.out.println("пошли гулять");
        } else {
            System.out.println(dog.getName() + " рядом, пошли гулять");
        }
        dog.hasCome = true;
    }

    public void tookGuineaPig(GuineaPig guineaPig){
        guineaPig.beTaken(this);
    }



}
