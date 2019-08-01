package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @After
    public void tearDown() {
        Squad.clearAllSquads();
    }

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

    @Test
    public void getAllSquads()throws Exception {
        Squad squad=setupSquad();
        Squad otherSquad=setupSquad();
        assertEquals(2,Squad.getAllSquads().size());

    }

    @Test
    public void getAllSquads_containsAllSquads()throws Exception {
        Squad squad=setupSquad();
        Squad otherSquad=setupSquad();
        assertTrue(Squad.getAllSquads().contains(squad));
        assertTrue(Squad.getAllSquads().contains(otherSquad));
    }

    @Test
    public void clearAllSquads_deletesAllSquadInstances()throws Exception{
        Squad squad=setupSquad();
        Squad otherSquad=setupSquad();
        Squad.clearAllSquads();
        assertTrue(Squad.getAllSquads().isEmpty());
    }

    @Test
    public void getSquadId_squadInstantiatesWithCorrectID() throws Exception{
        Squad squad=setupSquad();
        assertEquals(1,squad.getSquadId());
    }
}