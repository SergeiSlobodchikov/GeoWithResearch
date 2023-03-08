package Pet;

import GeoTREE.Gender;

public class Main {
    public static void main(String[] args) {
        pet();
    }

    public static void pet() {
        Human Sergei = new Human("Сергей", "Слободчиков", Gender.male);
        Cat Tihan = new Cat("Тихан", 18, Gender.male);
        Dog Warik = new Dog("Варик");
        GuineaPig Vasya = new GuineaPig("Вася");
        Sergei.callPets(Tihan);
        Sergei.callPets(Warik);
        Sergei.callPets(Vasya);
        System.out.println();
        Sergei.playWithPets(Tihan);
        Sergei.playWithPets(Warik);
        Sergei.playWithPets(Vasya);
        System.out.println();
        Sergei.pettingCats(Tihan);
        Sergei.goingWalkDog(Warik);
        Sergei.tookGuineaPig(Vasya);
        System.out.println();
        Tihan.askForFood(Sergei);
        Warik.askForFood(Sergei);
        Vasya.askForFood(Sergei);
        System.out.println();
        Sergei.feedPets(Tihan);
        Sergei.feedPets(Warik);
        Sergei.feedPets(Vasya);
        System.out.println();
        Tihan.voicePet();
        Warik.voicePet();
        Vasya.voicePet();
        System.out.println();
        Tihan.leavesTheHuman();
        Warik.leavesTheHuman();
        Vasya.leavesTheHuman();
        System.out.println();
        Tihan.scratchFurniture();
        Warik.chewFurniture();
        Vasya.gnawingThings();
        System.out.println();
        Tihan.sleep();
        Warik.sleep();
        Vasya.sleep();
    }
}