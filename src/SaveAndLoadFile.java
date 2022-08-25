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
                switch (node.re) {
                    case parent:
                        geoTree.appendChild(node.p2, node.p1);
                        break;
                    case children:
                        geoTree.appendChild(node.p1, node.p2);
                        break;
                    case Sibling:
                        geoTree.appendSibling(node.p2, node.p1);
                        break;
                    case Spouse:
                        geoTree.appendSpouse(node.p2, node.p1);
                        break;
                    case Grandparent:
                        geoTree.appendGrandparent(node.p2, node.p1);
                        break;
                    case Grandchild:
                        geoTree.appendGrandparent(node.p1, node.p2);
                        break;
                    case Aunt_Uncle:
                        geoTree.appendAunt_Uncle(node.p2, node.p1);
                        break;
                    case NEPHEW_NIECE:
                        geoTree.appendAunt_Uncle(node.p1, node.p2);
                        break;
                }
            }
            System.out.println("Данные загружены из файла " + fileName);
            return geoTree;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных из файла " + fileName);
            e.printStackTrace();
            return null;
        }
    }
}