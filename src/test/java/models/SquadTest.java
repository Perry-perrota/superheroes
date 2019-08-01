package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squadInstantiatesCorrecctly(){
        Squad squad=setupSquad();
        assertTrue(squad instanceof Squad);
    }

    @Test
    public void getSquadSize_returnsCorrectSquadSize_true() {
        Squad squad=setupSquad();
        assertEquals(5,squad.getSquadSize());
    }

    @Test
    public void getSquadName_returnsCorrectSquadName_true() {
        Squad squad=setupSquad();
        assertEquals("avengers",squad.getSquadName());
    }

    @Test
    public void getCause_returnsCorrectCause_true() {
        Squad squad=setupSquad();
        assertEquals("peace",squad.getCause());
    }

    public Squad setupSquad(){
        Squad squad=new Squad(5,"avengers","peace");
        return squad;
    }
}