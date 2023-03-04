package Cat;

import java.util.Random;
import GeoTREE.Gender;


public class Cat {
    private String name;
    private int age;
    private Gender gender;

    private boolean hasCome;

    public Cat(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hasCome = false;
    }

    public Cat(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.hasCome = false;
    }

    public boolean isHasCome() {
        return hasCome;
    }

    public Random random = new Random();

    public String getName() {
        return this.name;
    }

    public Gender getGender() {
        return gender;
    }

    public void purr() {
        System.out.println(this.name + " мурлычет");
        this.hasCome = true;
    }

    public void askForFood() {
        System.out.println(this.name + " просит еды");
    }

    public void  leavesTheHuman() {
        if (this.hasCome) {
            this.hasCome = false;
            System.out.println(this.name + " уходит в соседнюю комнату");
        }
    }
    public void scratchFurniture() {
        System.out.println(this.name + " царапает мебель");
    }


    public void respondToCall(Human human) {
        if (!hasCome) {
            int randomInt = random.nextInt(11);
            if (randomInt % 2 == 0) {
                System.out.println(this.name + " откликается на вызов и идет к " + human.getFirstName());
                this.hasCome = true;
            } else {
                System.out.println(this.name + " где-то лежит");
            }
        } else System.out.println(this.name + " удивленно смотрит так как рядом с вами");
    }

    public void eat() {
        if (!hasCome) {
            int randomInt = random.nextInt(11);
            if (randomInt % 2 == 0) {
                System.out.println(this.name + " откликается на вызов и идет покушать");
                this.hasCome = true;
                System.out.println(this.name + " ест");
            } else {
                System.out.println(this.name + " где-то лежит, голод еще не пришел");
            }
        } else {
            System.out.println(this.name + " ест");
        }
    }

    public void play() {
        int randomInt = random.nextInt(11);
        if (!hasCome) {
            if (randomInt % 2 == 0) {
                System.out.println(this.name + " бежит играть видимо очень хочет поиграть");
                this.hasCome = true;
            } else {
                System.out.println(this.name + " не откликается");
            }
        } else {
            if (randomInt % 2 == 0) {
                System.out.println(this.name + " играет в вами");
            } else System.out.println("Сам с собой играйся");
        }
    }
    public static void petCat(){
        Human Sergei = new Human("Сергей", "Слободчиков", Gender.male);
        Cat Tihan = new Cat("Тихан", 18, Gender.male);
        Sergei.callCat(Tihan);
        Sergei.playWithCat(Tihan);
        Sergei.pettingCat(Tihan);
        Tihan.askForFood();
        Sergei.feedCat(Tihan);
        Tihan.leavesTheHuman();
        Tihan.scratchFurniture();
    }


}

