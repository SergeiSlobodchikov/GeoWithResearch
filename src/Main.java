import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Person irina = new Person("Ирина", "Баранова", LocalDate.of(1990, 5, 25));
        Person vasya = new Person("Вася", "Баранов", LocalDate.of(1988, 3, 15));
        Person masha = new Person("Маша", "Баранова", LocalDate.of(2012, 5, 22));
        Person jane = new Person("Женя", "Баранов", LocalDate.of(2015, 7, 19));
        Person ivan = new Person("Ваня", "Иванов", LocalDate.of(1988, 2, 7));
        GeoTree gt = new GeoTree();
        gt.appendChild(irina, masha);
        gt.appendChild(irina, jane);
        gt.appendChild(vasya, jane);
        gt.appendChild(vasya, masha);
        gt.appendSibling(ivan, irina);
        gt.appendSpouse(irina, vasya);
        gt.appendAunt_Uncle(ivan, masha);
        gt.appendAunt_Uncle(ivan, jane);
        SaveAndLoadFile saver = new SaveAndLoadFile();
        System.out.println(new Reserch(gt).hasRelationship(irina, vasya,
                Relationship.Spouse));
        System.out.println(new Reserch(gt).spend(irina,
                Relationship.children));
        System.out.println(new Reserch(gt).spend(ivan,
                Relationship.Sibling));
        new Reserch(gt).printAllRelationships(irina);
        saver.saveToFile("src/file.ser", gt);
        System.out.println();
        SaveAndLoadFile loader = new SaveAndLoadFile();
        GeoTree loadedTree = loader.loadFromFile("src/file.ser");
        System.out.println(new Reserch(loadedTree).hasRelationship(irina, vasya,
                Relationship.Spouse));
        System.out.println(new Reserch(loadedTree).spend(irina,
                Relationship.children));
        System.out.println(new Reserch(loadedTree).spend(ivan,
                Relationship.Sibling));
        new Reserch(loadedTree).printAllRelationships(irina);

        Human Sergei = new Human("Сергей", "Слободчиков", gender.male);
        Cupboard shkaf = new Cupboard();
        Sergei.openDoor(shkaf);
        shkaf.addItem("Рубашка");
        Sergei.openDoor(shkaf);
        Sergei.findItemInCupboard("Рубашка", shkaf);
        Sergei.closeDoor(shkaf);

    }

}
