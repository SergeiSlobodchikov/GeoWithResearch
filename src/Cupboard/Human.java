package Cupboard;

import GeoTREE.Gender;
import GeoTREE.Person;

import java.time.LocalDate;

public class Human extends Person {
    public Human(String firstName, String lastName, Gender gender) {
        super(firstName, lastName, gender);
    }

    public Human(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Human(String firstName, String lastName, LocalDate birthDate) {
        super(firstName, lastName, birthDate);
    }

    public Human(String firstName) {
        super(firstName);
    }

    public void openDoor(Cupboard cupboard) {
        if (!cupboard.CupboardOr()) {
            if (this.getGender() == Gender.male) {
                System.out.println(this.getFirstName() + " открыл дверь шкафа");
            } else if (this.getGender() == Gender.female) {
                System.out.println(this.getFirstName() + " открыла дверь шкафа");
            } else {
                System.out.println(this.getFirstName() + " открыло дверь шкафа");
            }
            cupboard.openDoor();
        } else {
            System.out.println("Дверь шкафа уже открыта");
        }
    }

    public void closeDoor(Cupboard cupboard) {
        if (cupboard.CupboardOr()) {
            if (this.getGender() == Gender.male) {
                System.out.println(this.getFirstName() + " закрыл дверь шкафа");
            } else if (this.getGender() == Gender.female) {
                System.out.println(this.getFirstName() + " закрыла дверь шкафа");
            } else {
                System.out.println(this.getFirstName() + " закрыло дверь шкафа");
            }
            cupboard.closeDoor();
        } else {
            System.out.println("Дверь шкафа закрыта, ну что красивый шкаф");
        }
    }


    public void looked(Cupboard cupboard){
        if (cupboard.CupboardOr()) {
            if (this.getGender() == Gender.male) {
                System.out.println(this.getFirstName() + " осмотрел шкаф и там находится " + cupboard.items() );
            } else if (this.getGender() == Gender.female) {
                System.out.println(this.getFirstName() + " осмотрела шкаф и там находится " + cupboard.items() );
            } else {
                System.out.println(this.getFirstName() + " осмотрело шкаф и там находится " + cupboard.items() );
            }
        } else {
            System.out.println("Дверь шкафа закрыта, ну что красивый шкаф, жаль сквозь смотреть не могу");
        }
    }
    public void findItemInCupboard(String itemName, Cupboard cupboard) {
        if (cupboard.CupboardOr()) {
            if (cupboard.items().contains(itemName)) {
                if (this.getGender() == Gender.male) {
                    System.out.println(this.getFirstName() + " нашел " + itemName + " в шкафу");
                } else if (this.getGender() == Gender.female) {
                    System.out.println(this.getFirstName() + " нашла " + itemName + " в шкафу");
                } else {
                    System.out.println(this.getFirstName() + " нашло " + itemName + " в шкафу");
                }
            } else {
                System.out.println(itemName + " нету этой вещи в шкафу");
            }
        } else {
            System.out.println("Сначала нужно открыть дверь шкафа");
        }
    }

    public void addItem(String itemName, Cupboard cupboard) {
        if (cupboard.CupboardOr()) {
            if (this.getGender() == Gender.male) {
                System.out.println("Положил в шкаф: " + itemName);
            } else if (this.getGender() == Gender.female) {
                System.out.println("Положила в шкаф: " + itemName);
            } else {
                System.out.println("Положило в шкаф: " + itemName);
            }
            cupboard.addItem(itemName);
        } else {
            System.out.println("Сначала нужно открыть дверь шкафа");
        }
    }

    public void tookItem(String itemName, Cupboard cupboard) {
        if (cupboard.CupboardOr()) {
            if (this.getGender() == Gender.male) {
                System.out.println("Забрал из шкафа: " + itemName);
            } else if (this.getGender() == Gender.female) {
                System.out.println("Забрала из шкафа: " + itemName);
            } else {
                System.out.println("Забрало из шкафа: " + itemName);
            }
            cupboard.removeItem(itemName);
        } else {
            System.out.println("Сначала нужно открыть дверь шкафа");
        }
    }

}
