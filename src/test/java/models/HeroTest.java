package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void hero_instantiatesCorrectly(){
        Hero hero=setupHero();
        assertTrue(hero instanceof Hero);
    }

    @Test
    public void getHeroNAme() {
        Hero hero=setupHero();
        assertEquals("superman",hero.getHeroNAme());
    }

    @Test
    public void getStrength() {
        Hero hero=setupHero();
        assertEquals("flight",hero.getStrength());
    }

    @Test
    public void getWeakness() {
        Hero hero=setupHero();
        assertEquals("moon",hero.getWeakness());
    }

    @Test
    public void getAge() {
        Hero hero=setupHero();
        assertEquals(10,hero.getAge());
    }

    public Hero setupHero(){
        Hero hero=new Hero("superman","flight","moon",10);
        return hero;
    }
}