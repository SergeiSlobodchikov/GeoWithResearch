package GeoTREE;

import java.util.ArrayList;


public class Reserch {
    private ArrayList<String> result;
    private GenealogicalTree geoTree;

    public Reserch(GenealogicalTree geoTree) {
        this.geoTree = geoTree;
    }

    public boolean hasRelationship(Person p1, Person p2) {
        return geoTree.hasRelationship(p1, p2);
    }

    public ArrayList<String> spend(Person p, Relationship re) {
        return geoTree.findRelationships(p, re);
    }
}
