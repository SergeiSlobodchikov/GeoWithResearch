package GeoTREE;

import java.util.ArrayList;
import java.util.Iterator;

public class GeoTree implements GenealogicalTree {
    private ArrayList<Node> tree = new ArrayList<>();
    PersonComparator comparator = new PersonComparator();

    @Override
    public void addRelationship(Person person1, Person person2, Relationship relationship) {
        if (!hasRelationship(person1, person2)) {
            Node node1 = new Node(person1, relationship, person2);
            Node node2 = new Node(person2, relationship.getOppositeRelationship(), person1);
            tree.add(node1);
            tree.add(node2);
        }
    }

    @Override
    public boolean hasRelationship(Person p1, Person p2) {
        for (Relationship relationship : Relationship.values()) {
            Relationship rel = relationship;
            for (Node node : tree) {
                if (comparisonResult(node.p1, p1) && comparisonResult(node.p2, p2) && node.re == rel && p1 != p2) {
                    return true;

                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<Node> getTree() {
        return tree;
    }

    @Override
    public ArrayList<String> findRelationships(Person p, Relationship re) {
        ArrayList<String> result = new ArrayList<>();
        for (Node node : tree) {
            if (node.p1.equals(p) && node.re == re) {
                result.add(node.p2.getFirstName());
            }
        }
        return result;
    }

    @Override
    public ArrayList<String> allRelationships(Person p) {
        ArrayList<String> result = new ArrayList<>();
        result.add("Все отношения " + p.getFirstName() + " " + p.getLastName());
        for (Node t : tree) {
            if (t.p1.getFirstName().equals(p.getFirstName())) {
                result.add(t.re + ": " + t.p2.getFirstName() + " " + t.p2.getLastName());
            }
        }
        return result;
    }

    public void removeRelationship(Person person1, Person person2) {
        Iterator<Node> iterator = tree.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.p1.equals(person1) && node.p2.equals(person2)) {
                iterator.remove();
            }
        }
    }

    public boolean comparisonResult(Person p1, Person p2) {
        int comparisonResult = comparator.compare(p1, p2);
        return comparisonResult == 0;
    }

}