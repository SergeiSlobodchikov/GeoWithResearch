import java.io.Serializable;

public class Node implements Serializable {

    public Node(Person p1, Relationship re, Person p2) {
        this.p1 = p1;
        this.re = re;
        this.p2 = p2;
    }


    Person p1;
    Relationship re;
    Person p2;
    Cat cat;

    @Override
    public String toString() {
        return String.format("<%s %s %s>", p1, re, p2);
    }

}