package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @After
    public void tearDown(){
        Hero.clearAllHeroes();
    }

    @Test
    public void hero_instantiatesCorrectly()throws Exception{
        Hero hero=setupHero();
        assertTrue(hero instanceof Hero);
    }

    @Test
    public void getHeroName_returnsCorrectName_true() throws Exception{
        Hero hero=setupHero();
        assertEquals("superman",hero.getHeroName());
    }

    @Test
    public void getStrength_returnsCorrectStrength_true()throws Exception {
        Hero hero=setupHero();
        assertEquals("flight",hero.getStrength());
    }

    @Test
    public void getWeakness_returnsCorrectweakness() throws Exception{
        Hero hero=setupHero();
        assertEquals("moon",hero.getWeakness());
    }

    @Test
    public void getAge_returnsCorrectAge() throws Exception {
        Hero hero=setupHero();
        assertEquals(10,hero.getAge());
    }

    @Test
    public void getAllHeroes_returnsAllHeroCreated()throws Exception {
        Hero hero=setupHero();
        Hero otherHero=setupHero();
        assertEquals(2,Hero.getAllHeroes().size());
    }

    @Test
    public void getAllHeroes_returnsAllHeroes_true()throws Exception{
        Hero hero=setupHero();
        Hero otherHero=setupHero();
        assertTrue(Hero.getAllHeroes().contains(hero));
        assertTrue(Hero.getAllHeroes().contains(otherHero));
    }

    @Test
    public void clearAllHeroes() throws Exception{
        Hero hero=setupHero();
        Hero otherHero=setupHero();
        Hero.clearAllHeroes();
        assertTrue(Hero.getAllHeroes().isEmpty());
    }


    public Hero setupHero(){
        Hero hero=new Hero("superman","flight","moon",10);
        return hero;
    }
}