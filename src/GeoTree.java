import java.time.LocalDate;
import java.util.ArrayList;


public class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public boolean hasRelationship(Person p1, Person p2) {
        for (Relationship relationship : Relationship.values()) {
            Relationship rel = relationship;
            for (Node node : tree) {
                if (node.p1.equals(p1) && node.p2.equals(p2) && node.re == rel && p1 != p2) {
                    return true;
                }
            }

        } return false;
    }
    public void appendChild(Person parent, Person children) {
        int parentYears = Integer.parseInt(parent.getBirthDate().substring(0, 4));
        int childrenYears = Integer.parseInt(children.getBirthDate().substring(0, 4));
        if (parentYears + 15 < childrenYears) {
            if (!hasRelationship(parent, children)) {
                tree.add(new Node(children, Relationship.parent, parent));
                tree.add(new Node(parent, Relationship.children, children));
            }
        } else {
            System.out.println("Разница у ребенка с родителем маленькая");
        }
    }

    public void appendSibling(Person Sibling1, Person Sibling2) {
        if (!hasRelationship(Sibling1, Sibling2)) {
            tree.add(new Node(Sibling1, Relationship.Sibling, Sibling2));
            tree.add(new Node(Sibling2, Relationship.Sibling, Sibling1));
        }
    }

    public void appendSpouse(Person Spouse1, Person Spouse2) {
        if (!hasRelationship(Spouse1, Spouse2)) {
            tree.add(new Node(Spouse1, Relationship.Spouse, Spouse2));
            tree.add(new Node(Spouse2, Relationship.Spouse, Spouse1));
        }
    }

    public void appendGrandparent(Person Grandparent, Person Grandchild) {
        if (!hasRelationship(Grandparent, Grandchild)) {
            tree.add(new Node(Grandchild, Relationship.Grandparent, Grandparent));
            tree.add(new Node(Grandparent, Relationship.Grandchild, Grandchild));
        }
    }

    public void appendAunt_Uncle(Person Aunt_Uncle, Person NEPHEW_NIECE) {
        if (!hasRelationship(Aunt_Uncle, NEPHEW_NIECE)) {
            tree.add(new Node(NEPHEW_NIECE, Relationship.Aunt_Uncle, Aunt_Uncle));
            tree.add(new Node(Aunt_Uncle, Relationship.NEPHEW_NIECE, NEPHEW_NIECE));
        }
    }



    public static void geoTree(){
        Person irina = new Person("Ирина", "Баранова", LocalDate.of(1990, 5, 25));
        Person vasya = new Person("Вася", "Баранов", LocalDate.of(1988, 3, 15));
        Person masha = new Person("Маша", "Баранова", LocalDate.of(2012, 5, 22));
        Person jane = new Person("Женя", "Баранов", LocalDate.of(2015, 7, 19));
        Person ivan = new Person("Ваня", "Иванов", LocalDate.of(1988, 2, 7));
        Person Tosya = new Person("Тоисья", "Иванова");
        GeoTree gt = new GeoTree();
        gt.appendChild(irina, masha);
        gt.appendChild(irina, jane);
        gt.appendChild(vasya, jane);
        gt.appendChild(vasya, masha);
        gt.appendSibling(ivan, irina);
        gt.appendSpouse(irina, vasya);
        gt.appendAunt_Uncle(ivan, masha);
        gt.appendAunt_Uncle(ivan, jane);
        gt.appendGrandparent(Tosya, irina);
        gt.appendGrandparent(Tosya, ivan);

        SaveAndLoadFile saver = new SaveAndLoadFile();
        saver.saveToFile("src/file.ser", gt);
        SaveAndLoadFile loader = new SaveAndLoadFile();
        GeoTree loadedTree = loader.loadFromFile("src/file.ser");
        System.out.println();
        new Reserch(gt).printAllRelationships(irina);
        new Reserch(loadedTree).printAllRelationships(irina);
        System.out.println();
        new Reserch(gt).printAllRelationships(masha);
        new Reserch(loadedTree).printAllRelationships(masha);
        System.out.println();
        new Reserch(gt).printAllRelationships(ivan);
        new Reserch(loadedTree).printAllRelationships(ivan);
        System.out.println(new Reserch(gt).spend(irina, Relationship.children));
        System.out.println();
    }
}
