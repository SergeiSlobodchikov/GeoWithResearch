package Pet;

import java.util.Random;

import GeoTREE.Gender;

public class Dog extends Pets implements Voice{

    public Dog(String name, int age, Gender gender, String petColor) {
        super(name, age, gender, petColor);
    }

    public Dog(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public Dog(String name) {
        super(name);
    }

    public Dog(String name, Gender gender) {
        super(name, gender);
    }

    public Dog(String name, int age, String petColor) {
        super(name, age, petColor);
    }

    public Random random = new Random();


    public void bark() {
        System.out.println(this.getName() + " гавкает");
        hasCome = true;
    }

    public void whining() {
        System.out.println(this.getName() + " скулит просится погулять");
        hasCome = true;
    }

    public void askForFood(Human human) {
        System.out.println(this.getName() + " просит еды у " + human.getFirstName());
    }

    public void leavesTheHuman() {
        if (this.hasCome) {
            this.hasCome = false;
            System.out.println(this.getName() + " уходит в соседнюю комнату");
        }
    }

    public void chewFurniture() {
        System.out.println(this.getName() + " грызет мебель");
    }

    @Override
    public void eat() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " откликается на зов и идет покушать");
                this.hasCome = true;
                System.out.println("Ест");
            } else {
                System.out.println(this.getName() + " что-то не идет, видимо поел в тихую");
            }
        } else {
            System.out.println(this.getName() + " так как рядом сразу напал на корм");
        }

    }

    @Override
    public void sleep() {
        System.out.println("Решил поспать лег рядом с хозяином");
        this.hasCome = true;
    }

    @Override
    public void play() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " бежит играть видимо очень хочет поиграть");
                this.hasCome = true;
            } else {
                System.out.println(this.getName() + " зовет играть на улицу с мячиком");
                System.out.println("Вы поиграли на улице и вернулись домой");
            }
        } else {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " играет c вами");
            }
        }
    }

    @Override
    public void respondToCall(Human human) {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " откликается на вызов и идет к " + human.getFirstName());
                this.hasCome = true;
            } else {
                System.out.println(this.getName() + " где-то лежит");
            }
        } else {
            if (randomInt % 2 == 0) {
                bark();
            } else {
                System.out.println(this.getName() + " начинает вас лизать");
            }
        }
    }


    @Override
    public void voicePet() {
        System.out.println(this.getName() + " начал гавкать");
    }
}