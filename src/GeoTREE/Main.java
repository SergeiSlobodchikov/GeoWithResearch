package GeoTREE;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        geoTree();
    }
    public static void geoTree(){
        Person irina = new Person("Ирина", "Баранова", LocalDate.of(1990, 5, 25));
        Person vasya = new Person("Вася", "Баранов", LocalDate.of(1988, 3, 15));
        Person masha = new Person("Маша", "Баранова", LocalDate.of(2012, 5, 22));
        Person jane = new Person("Женя", "Баранов", LocalDate.of(2015, 7, 19));
        Person ivan = new Person("Ваня", "Иванов", LocalDate.of(1988, 2, 7));
        Person Tosya = new Person("Тоисья", "Иванова");
        GeoTree gt = new GeoTree();
        gt.addRelationship(irina, masha, Relationship.children);
        gt.addRelationship(irina, jane, Relationship.children);
        System.out.println(gt.hasRelationship(irina,vasya));
        gt.addRelationship(vasya, jane, Relationship.children);
        gt.addRelationship(vasya, masha, Relationship.children);
        gt.addRelationship(ivan, irina, Relationship.Sibling);
        gt.addRelationship(irina, vasya, Relationship.Spouse);
        System.out.println(gt.hasRelationship(irina,vasya));
        gt.addRelationship(ivan, masha, Relationship.NEPHEW_NIECE);
        gt.addRelationship(ivan, jane, Relationship.NEPHEW_NIECE);
        gt.addRelationship(Tosya, irina, Relationship.Grandchild);
        gt.addRelationship(Tosya, ivan, Relationship.Grandchild);
        SaveAndLoadFile saver = new SaveAndLoadFile();
        saver.saveToFile("src/GeoTREE/file.ser", gt);
        SaveAndLoadFile loader = new SaveAndLoadFile();
        GeoTree loadedTree = loader.loadFromFile("src/GeoTREE/file.ser");
        System.out.println();
        System.out.println(gt.allRelationships(irina));
        System.out.println(loadedTree.allRelationships(irina));
        System.out.println();
        System.out.println(gt.allRelationships(masha));
        System.out.println(loadedTree.allRelationships(masha));
        System.out.println();
        System.out.println(gt.allRelationships(ivan));
        System.out.println(loadedTree.allRelationships(ivan));
        System.out.println(new Reserch(gt).spend(irina, Relationship.children));
        System.out.println();
    }
}
