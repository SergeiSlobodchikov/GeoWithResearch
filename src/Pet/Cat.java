package Pet;

import java.util.Random;

import GeoTREE.Gender;


public class Cat extends Pets {
    private boolean hasCome;

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

    public boolean isHasCome() {
        return hasCome;
    }

    public Random random = new Random();


    public void purr() {
        System.out.println(this.getName() + " мурлычет");
        this.hasCome = true;
    }

    public void askForFood() {
        System.out.println(this.getName() + " просит еды");
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

    public static void petCat() {
        Human Sergei = new Human("Сергей", "Слободчиков", Gender.male);
        Cat Tihan = new Cat("Тихан", 18, Gender.male);
        Sergei.callCat(Tihan);
        Sergei.callCat(Tihan);
        Sergei.callCat(Tihan);
        Sergei.playWithCat(Tihan);
        Sergei.pettingCat(Tihan);
        Tihan.askForFood();
        Sergei.feedCat(Tihan);
        Tihan.leavesTheHuman();
        Tihan.scratchFurniture();
    }


}

