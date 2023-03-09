package GeoTREE;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SaveAndLoadFile {

    public void saveToFile(String fileName, GeoTree geoTree) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(geoTree.getTree());
            System.out.println("Данные сохранены в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных в файл " + fileName + ": " + e.getMessage());
        }
    }

    public GeoTree loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            ArrayList<Node> nodes = (ArrayList<Node>) ois.readObject();
            GeoTree geoTree = new GeoTree();
            for (Node node : nodes) {
                Person person1 = node.p1;
                Person person2 = node.p2;
                Relationship relationship = node.re;
                geoTree.addRelationship(person1, person2, relationship);
            }
            return geoTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных из файла " + fileName);
            e.printStackTrace();
            return null;
        }
    }
}