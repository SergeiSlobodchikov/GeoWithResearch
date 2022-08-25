public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void purr() {
        System.out.println(this.name + " мурлычет");
    }

    public void askForFood() {
        System.out.println(this.name + " просит еды");
    }

    public void scratchFurniture() {
        System.out.println(this.name + " царапает мебель");
    }
}
