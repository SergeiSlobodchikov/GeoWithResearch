import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Геологическое древо \n2. Взаимодействие человека и шкафа\n3. " +
                "Взаимодействие человека и кота \nВыход любой другой знак \nНажмите цифру и enter:");
        int number = scan.nextInt();
        switch (number) {
            case  (1):
                GeoTree.geoTree();
                break;
            case (2):
                Cupboard.cupboard();
                break;
            case (3):
                Cat.petCat();
                break;
            default:
                break;
        }



    }
}
