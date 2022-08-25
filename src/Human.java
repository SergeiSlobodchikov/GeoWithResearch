import java.time.LocalDate;
import java.util.ArrayList;

public class Human{

    private String firstName;
    private String lastName;
    private gender gender;


    public  Human(String firstName, String lastName, gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }


    public void openDoor(Cupboard cupboard) {
        Cupboard door = new Cupboard();
        if (!door.CupboardOr()) {
            System.out.println(this.firstName + " открыл(а) дверь шкафа");
            cupboard.openDoor();
        } else {
            System.out.println("Дверь шкафа уже открыта");
        }
    }

    public void closeDoor(Cupboard cupboard) {
        Cupboard door = cupboard;
        if (door.CupboardOr()) {
            System.out.println(this.firstName + " закрыл(а) дверь шкафа");
            cupboard.closeDoor();
        } else {
            System.out.println("Дверь шкафа уже закрыта");
        }
    }

    public void findItemInCupboard(String itemName, Cupboard cupboard) {
        Cupboard door = cupboard;
        if (door.CupboardOr()) {
            if (door.items().contains(itemName)) {
                System.out.println(this.firstName + " нашел(а) " + itemName + " в шкафу");
            } else {
                System.out.println(itemName +" не найдены");
            }
        } else {
            System.out.println("Сначала нужно открыть дверь шкафа");
        }
    }

    public void callCat(String catName) {
        System.out.println(this.firstName + " зовет котика " + catName);
    }

    public void petCat(Cat cat) {
        System.out.println(this.firstName + " гладит котика " + cat.getName());
        cat.purr();
    }
}

