package creatures;

import huglife.*;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class TestClorus {

    @Test
    public void testClorus() {
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Empty());
        surrounded.put(Direction.BOTTOM, new Plip());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());
        Clorus c = new Clorus();
        Action actual = c.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.ATTACK, Direction.BOTTOM);
        assertEquals(expected, actual);
    }
}
