import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<String> items(){
        return items;
    }

    public void openDoor() {
        if (!this.isDoorOpen) {
            System.out.println("Дверь шкафа открыта");
            this.isDoorOpen = true;
        } else {
            System.out.println("Дверь шкафа уже открыта");
        }
    }

    public void closeDoor() {
        if (this.isDoorOpen) {
            System.out.println("Дверь шкафа закрыта");
            this.isDoorOpen = false;
        } else {
            System.out.println("Дверь шкафа уже закрыта");
        }
    }

    public void addItem(String itemName) {
        items.add(itemName);
        System.out.println("Добавлена вещь в шкаф: " + itemName);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
        System.out.println("Из шкафа убрана: " + itemName);
    }

    public static void cupboard(){
        Human Sergei = new Human("Сергей", "Слободчиков", Gender.male);
        Cupboard shkaf = new Cupboard();
        shkaf.items().addAll(Arrays.asList("рубашка", "майка", "футболка", "джинсы"));
        Sergei.openDoor(shkaf);
        Sergei.addItem("Рубашка", shkaf);
        Sergei.looked(shkaf);
        Sergei.findItemInCupboard("футболка", shkaf);
        Sergei.tookItem("футболка", shkaf) ;
        Sergei.closeDoor(shkaf);
        System.out.println();
    }
}


