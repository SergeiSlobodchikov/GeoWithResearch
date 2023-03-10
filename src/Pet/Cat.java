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
        if (getHunger() < 40) {
            System.out.println(this.getName() + " просит еды у " + human.getFirstName());
            hasCome = true;
        }
    }

    public void leavesTheHuman() {
        if (this.hasCome) {
            this.hasCome = false;
            System.out.println(this.getName() + " уходит в соседнюю комнату");
            this.hunger -= 5;
        }
    }

    public void scratchFurniture() {
        System.out.println(this.getName() + " царапает мебель");
        this.hunger -= 10;
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
        this.hunger -= 5;
    }

    @Override
    public void eat() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (getHunger() < 40) {
                System.out.println(this.getName() + " откликается на вызов и идет покушать");
                this.hasCome = true;
                System.out.println(this.getName() + " ест");
                this.hunger = 100;
            } else {
                System.out.println(this.getName() + " где-то лежит, голод еще не пришел");
            }
        } else {
            if (getHunger() < 40) {
                System.out.println(this.getName() + " ест");
                this.hunger = 100;
            } else {
                System.out.println("Он просто хотел чтобы миска была не пустой");
            }
        }
        this.hunger -= 5;
    }

    @Override
    public void sleep() {
        System.out.println("Решил поспать пошел на свободную кровать");
        this.hasCome = false;
        this.hunger -= 10;
    }

    @Override
    public void play() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " бежит играть видимо очень хочет поиграть");
                this.hasCome = true;
                this.hunger -= 20;
            } else {
                System.out.println(this.getName() + " не откликается");
                this.hunger -= 5;
            }
        } else {
            if (randomInt % 2 == 0) {
                System.out.println(this.getName() + " играет c вами");
                this.hunger -= 20;
            } else System.out.println("Сам с собой играйся!!!");
            this.hunger -= 5;
        }
    }

    @Override
    public void voicePet() {
        System.out.println(this.getName() + " начал мяукать");
    }


}

