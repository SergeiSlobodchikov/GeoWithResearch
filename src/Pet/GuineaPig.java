package Pet;

import GeoTREE.Gender;
;import java.util.Random;

public class GuineaPig extends Pets implements Voice {

    public GuineaPig(String name, int age, Gender gender, String petColor, boolean isTaken) {
        super(name, age, gender, petColor);
        this.isTaken = isTaken;
    }

    public GuineaPig(String name, int age, Gender gender, boolean isTaken) {
        super(name, age, gender);
        this.isTaken = isTaken;
    }

    public GuineaPig(String name, boolean isTaken) {
        super(name);
        this.isTaken = isTaken;
    }

    public GuineaPig(String name, Gender gender, boolean isTaken) {
        super(name, gender);
        this.isTaken = isTaken;
    }

    public GuineaPig(String name, int age, String petColor, boolean isTaken) {
        super(name, age, petColor);
        this.isTaken = isTaken;
    }

    private boolean isTaken = hasCome;

    public GuineaPig(String name) {
        super(name);
    }

    public void squeak() {
        System.out.println(this.getName() + " пищит");
        this.hunger -= 5;
    }

    public void askForFood(Human human) {
        if (getHunger() < 40) {
            System.out.println(this.getName() + " просит еды у " + human.getFirstName());
        }
    }

    public void takeAndBack() {
        if (this.isTaken) {
            this.isTaken = false;
            System.out.println(this.getName() + " была возвращена в клетку");
        } else {
            this.isTaken = true;
            System.out.println(this.getName() + " взял из клетки");
            this.hunger -= 40;
        }
    }

    public void respondToCall(Human human) {
        if (!isTaken) {
            System.out.println(this.getName() + " не может подойти к вам, пока находится в клетке");
        } else {
            System.out.println(this.getName() + " трется об тебя, потому что уже с вами");
            this.hunger -= 15;
        }
    }

    public void beTaken(Human human) {
        if (this.isTaken) {
            System.out.println(this.getName() + " уже с " + human.getFirstName());
        } else {
            System.out.println(this.getName() + " была взята с собой");
            this.isTaken = true;
        }
        this.hunger -= 5;
    }

    @Override
    public void eat() {
        if (getHunger() < 40) {
            if (isTaken) {
                System.out.println(this.getName() + " ест с твоей руки овощи");
            } else {
                System.out.println(this.getName() + " ест свежую травку из миски");
            }
            this.hunger = 100;
        } else {
            System.out.println(this.getName() +" пока не голодный");
            this.hunger -= 5;
        }
    }


    @Override
    public void sleep() {
        if (isTaken) {
            System.out.println(this.getName() + " просится в клетку так как хочет спать");
            this.isTaken = false;
        } else {
            System.out.println(this.getName() + " идет спать в домик");
        }
        this.hunger -= 20;
    }

    @Override
    public void play() {
        if (isTaken) {
            System.out.println(this.getName() + " бегает по руке своего хозяина");
        } else {
            System.out.println(this.getName() + " решил побегать в колесе");
        }
        this.hunger -= 20;
    }

    public void leavesTheHuman() {
        if (isTaken) {
            System.out.println(this.getName() + " начинает прятаться");
        }
        this.hunger -= 10;
    }

    public void gnawingThings() {
        if (isTaken) {
            System.out.println(this.getName() + " начал грызть что попало");
        } else {
            System.out.println(this.getName() + " грызет соляной камень");
        }
        this.hunger -= 5;
    }

    public Random random = new Random();

    @Override
    public void voicePet() {
        int randomInt = random.nextInt(11);
        if (randomInt % 2 == 0) System.out.println(this.getName() + " пищит так как радуется");
        else {
            System.out.println(this.getName() + " фыркает видимо хочет прочистить нос от пыли");
        }
    }
}
