package creatures;

import huglife.*;

import java.awt.Color;
import java.util.List;
import java.util.Map;

public class Clorus extends Creature {
    /**
     * red color.
     */
    private int r;
    /**
     * green color.
     */
    private int g;
    /**
     * blue color.
     */
    private int b;

    /**
     * creates clorus with energy equal to E.
     */
    public Clorus(double e) {
        super("clorus");
        r = 34;
        g = 0;
        b = 231;
        energy = e;
    }

    /**
     * creates a plip with energy equal to 1.
     */
    public Clorus() {
        this(1);
    }

    /**
     * this color method should always return color red = 34, green = 0, blue = 231
     *
     * @return color with property: red = 34, green = 0, blue = 231
     */
    @Override
    public Color color() {
        return new Color(r, g, b);
    }

    @Override
    public void attack(Creature c) {
        energy += c.energy();
    }

    /**
     * Cloruses should lose 0.03 units of energy on a MOVE action.
     */
    @Override
    public void move() {
        energy -= 0.15;
    }

    /**
     * Cloruses should lose 0.01 units of energy on a STAY action.
     */
    @Override
    public void stay() {
        energy -= 0.01;
    }

    /**
     * When a Clorus replicates, it keeps 50% of its energy.
     * The other 50% goes to its offspring.
     * No energy is lost in the replication process.
     *
     * @return the offspring of clorus
     */
    @Override
    public Clorus replicate() {
        Clorus offSpring = new Clorus(energy / 2);
        energy = energy / 2;
        return offSpring;
    }

    /**
     * If there are no empty squares, the Clorus will STAY
     * (even if there are Plips nearby they could attack).
     * Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
     * Otherwise, if the Clorus has energy greater than or equal to one,
     * it will REPLICATE to a random empty square.
     * Otherwise, the Clorus will MOVE to a random empty square.
     *
     * @param neighbors the neighbors information.
     * @return the action of called clorus should do.
     */
    @Override
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        if (empties.size() == 0) {
            return new Action(Action.ActionType.STAY);
        }
        List<Direction> plips = getNeighborsOfType(neighbors, "plip");
        if (plips.size() != 0) {
            Direction moveDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK, moveDir);
        }
        if (energy >= 1) {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE, moveDir);
        }
        Direction moveDir = HugLifeUtils.randomEntry(empties);
        return new Action(Action.ActionType.MOVE, moveDir);
    }
}
