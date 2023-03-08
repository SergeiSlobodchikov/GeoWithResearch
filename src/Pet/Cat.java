package Pet;

import java.util.Random;

import GeoTREE.Gender;


public class Cat extends Pets implements Voice {

    public Cat(String name, int age, Gender gender, String petColor) {
        super(name, age, gender, petColor);
    }


    public Cat(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, Gender gender) {
        super(name, gender);
    }

    public Cat(String name, int age, String petColor) {
        super(name, age, petColor);
    }

    public Random random = new Random();


    public void purr() {
        System.out.println(this.getName() + " мурлычет");
        hasCome = true;
    }

    public void askForFood(Human human) {
        System.out.println(this.getName() + " просит еды у " + human.getFirstName());
        hasCome = true;
    }

    public void leavesTheHuman() {
        if (this.hasCome) {
            this.hasCome = false;
            System.out.println(this.getName() + " уходит в соседнюю комнату");
        }
    }

    public void scratchFurniture() {
        System.out.println(this.getName() + " царапает мебель");
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
                leavesTheHuman();
            } else {
                System.out.println(this.getName() + " удивленно смотрит так как рядом с вами");
            }
        }
    }

    @Override
    public void eat() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " откликается на вызов и идет покушать");
                this.hasCome = true;
                System.out.println(this.getName() + " ест");
            } else {
                System.out.println(this.getName() + " где-то лежит, голод еще не пришел");
            }
        } else {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " ест");
            } else {
                System.out.println("Он просто хотел чтобы миска была не пустой");
            }
        }
    }

    @Override
    public void sleep() {
        System.out.println("Решил поспать пошел на свободную кровать");
        this.hasCome = false;
    }

    @Override
    public void play() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " бежит играть видимо очень хочет поиграть");
                this.hasCome = true;
            } else {
                System.out.println(this.getName() + " не откликается");
            }
        } else {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " играет c вами");
            } else System.out.println("Сам с собой играйся!!!");
        }
    }

    @Override
    public void voicePet() {
        System.out.println(this.getName() + " начал мяукать");
    }
}
