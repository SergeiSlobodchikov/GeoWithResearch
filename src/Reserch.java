import java.util.ArrayList;

public class Reserch {
    private ArrayList<String> result;
    private ArrayList<Node> tree;

    public Reserch(GeoTree geoTree) {
        tree = geoTree.getTree();
    }

    public ArrayList<String> spend(Person p, Relationship re) {
        result = new ArrayList<>(); // создаем новый список результатов перед каждым поиском
        for (Node t : tree) {
            if (t.p1.getFirstName().equals(p.getFirstName()) && t.re == re) {
                result.add(t.p2.getFirstName() );
            }
        }
        result.add(" " + re.toString());
        return result;
    }

    public boolean hasRelationship(Person p1, Person p2, Relationship re) {
        for (Node t : tree) {
            if ((t.p1.getFirstName().equals(p1.getFirstName()) && t.p2.getFirstName().equals(p2.getFirstName()))
                    || (t.p1.getFirstName().equals(p2.getFirstName()) && t.p2.getFirstName().equals(p1.getFirstName()))) {
                if (t.re == re) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printAllRelationships(Person p) {
        result = new ArrayList<>();
        for (Node t : tree) {
            if (t.p1.getFirstName().equals(p.getFirstName())) {
                result.add(t.re + ": " + t.p2.getFirstName() + " " + t.p2.getLastName() );
            }
        }
        System.out.println("Все отношения " + p.getFirstName() + " " + p.getLastName() + ":");
        System.out.println(String.join("\n", result));
    }

}