package models;

public class Hero {
    private String heroNAme;
    private String strength;
    private String weakness;
    private int heroID;
    private int age;

    public Hero(String heroNAme, String strength, String weakness, int age) {
        this.heroNAme = heroNAme;
        this.strength = strength;
        this.weakness = weakness;
        this.age = age;
    }

    public String getHeroNAme() {
        return heroNAme;
    }

    public String getStrength() {
        return strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public int getHeroID() {
        return heroID;
    }

    public int getAge() {
        return age;
    }
}
