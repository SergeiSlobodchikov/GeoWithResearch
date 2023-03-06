package Pet;

import GeoTREE.Gender;

public abstract class Pets {
    private String name;
    private int age;
    private Gender gender;
    private String petColor;

    public Pets(String name, int age, Gender gender, String petColor) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.petColor = petColor;
    }

    public Pets(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Pets(String name) {
        this.name = name;
    }

    public Pets(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Pets(String name, int age, String petColor) {
        this.name = name;
        this.age = age;
        this.petColor = petColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPetColor(String petColor) {
        this.petColor = petColor;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPetColor() {
        return petColor;
    }

    public void eat(){};
}
