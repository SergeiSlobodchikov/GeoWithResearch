package Cupboard;

import java.util.ArrayList;
import java.util.Arrays;

import GeoTREE.Gender;


class Cupboard {
    private boolean isDoorOpen;
    public ArrayList<String> items = new ArrayList<>();

    public Cupboard() {
        this.isDoorOpen = false;
        this.items = new ArrayList<>();
    }

    public boolean CupboardOr() {
        return isDoorOpen;
    }

    public ArrayList<String> items() {
        return items;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    public void addItem(String itemName) {
        items.add(itemName);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public static void cupboard() {
        Human Sergei = new Human("Сергей", "Слободчиков", Gender.male);
        Cupboard shkaf = new Cupboard();
        shkaf.items().addAll(Arrays.asList("рубашка", "майка", "футболка", "джинсы"));
        Sergei.openDoor(shkaf);
        Sergei.addItem("Рубашка", shkaf);
        Sergei.looked(shkaf);
        Sergei.findItemInCupboard("футболка", shkaf);
        Sergei.tookItem("футболка", shkaf);
        Sergei.closeDoor(shkaf);
        System.out.println();
    }
}


