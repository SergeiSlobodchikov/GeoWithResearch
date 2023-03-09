package GeoTREE;

import java.util.Comparator;

public class PersonComparator  implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int lastNameComparison = p1.getLastName().compareTo(p2.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        return p1.getFirstName().compareTo(p2.getFirstName());
    }
}

