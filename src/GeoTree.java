import java.util.ArrayList;


public class GeoTree {
    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return tree;
    }

    public boolean hasRelationship(Person p1, Person p2, Relationship rel) {
        for (Node node : tree) {
            if (node.p1.equals(p1) && node.p2.equals(p2) && node.re == rel && p1 != p2) {
                return true;
            }
        }
        return false;
    }

    public void appendChild(Person parent, Person children) {
        int parentYears = Integer.parseInt(parent.getBirthDate().substring(0, 4));
        int childrenYears = Integer.parseInt(children.getBirthDate().substring(0, 4));
        if (parentYears + 15 < childrenYears) {
            if (!hasRelationship(parent, children, Relationship.children)) {
                tree.add(new Node(children, Relationship.parent, parent));
                tree.add(new Node(parent, Relationship.children, children));
            }
        } else {
            System.out.println("Разница у ребенка с родителем маленькая");
        }
    }

    public void appendSibling(Person Sibling1, Person Sibling2) {
        if (!hasRelationship(Sibling1, Sibling2, Relationship.Sibling)) {
            tree.add(new Node(Sibling1, Relationship.Sibling, Sibling2));
            tree.add(new Node(Sibling2, Relationship.Sibling, Sibling1));
        }
    }

    public void appendSpouse(Person Spouse1, Person Spouse2) {
        if (!hasRelationship(Spouse1, Spouse2, Relationship.Spouse)) {
            tree.add(new Node(Spouse1, Relationship.Spouse, Spouse2));
            tree.add(new Node(Spouse2, Relationship.Spouse, Spouse1));
        }
    }

    public void appendGrandparent(Person Grandparent, Person Grandchild) {
        if (!hasRelationship(Grandparent, Grandchild, Relationship.Grandparent)) {
            tree.add(new Node(Grandchild, Relationship.Grandparent, Grandparent));
            tree.add(new Node(Grandparent, Relationship.Grandchild, Grandchild));
        }
    }

    public void appendAunt_Uncle(Person Aunt_Uncle, Person NEPHEW_NIECE) {
        if (!hasRelationship(Aunt_Uncle, NEPHEW_NIECE, Relationship.Grandparent)) {
            tree.add(new Node(NEPHEW_NIECE, Relationship.Aunt_Uncle, Aunt_Uncle));
            tree.add(new Node(Aunt_Uncle, Relationship.NEPHEW_NIECE, NEPHEW_NIECE));
        }
    }
}
