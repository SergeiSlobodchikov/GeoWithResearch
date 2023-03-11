package Pet;
import java.util.Comparator;
public class ComparatorFood implements Comparator<Pets>{
    @Override
    public int compare(Pets p1, Pets p2) {
        return Integer.compare(p1.getHunger(), p2.getHunger());
    }

}
