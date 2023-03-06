package GeoTREE;

import java.util.ArrayList;

public interface GenealogicalTree {
    /**
     * @param person1      Человек 1
     * @param person2      Человек 2
     * @param relationship Вид уз кем станет человек 2, к человеку 1.
     * @apiNote Пример; addRelationship(Irina, Masha, Relationship.children) -> Masha станет children(ребенком) а Irina parent(родитель)
     */
    void addRelationship(Person person1, Person person2, Relationship relationship);

    /**
     * @param p1      Человек 1
     * @param p2      Человек 2
     * @apiNote Проверка есть ли какие-нибудь связи
     */
    boolean hasRelationship(Person p1, Person p2);

    ArrayList<Node> getTree();

    /**
     * @param person   Человек которому мы хотим вызвать его конкретные генеалогические связи
     * @param relationship   Вид генеалогической связи
     */
    ArrayList<String> findRelationships(Person person, Relationship relationship);

    /**
     * @param  person   Человек которому мы хотим вызвать все его связи
     */
    ArrayList<String> allRelationships(Person person);
}

