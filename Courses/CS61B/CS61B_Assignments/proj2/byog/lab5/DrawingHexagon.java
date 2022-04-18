package byog.lab5;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class DrawingHexagon {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 60;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * compute the width of ith row of a size hexagon
     *
     * @param size the size of the hexagon
     * @param i    the row number of hexagon where i=0 is the
     *             bottom row
     * @return
     */
    private static int hexRowWidth(int size, int i) {
        if (size == 0) {
            return 0;
        }
        int returnValue;
        if (i >= size) {
            returnValue = size + 2 * (2 * size - i - 1);
        } else {
            returnValue = size + 2 * i;
        }
        return returnValue;
    }

    /**
     * find the position of start point(left) of one tile
     * by using the given position(left bottom position of hexagon
     *
     * @param position start position(left bottom position of hexagon
     * @param i        the ith line of a hexagon
     * @param size     the size of a hexagon
     * @return
     */
    private static Position findPosition(Position position, int i, int size) {
        Position p = new Position(position.x, position.y);
        if (i >= size) {
            p.x = position.x - (2 * size - i - 1);
            p.y = position.y + i;
        } else {
            p.x = position.x - i;
            p.y = position.y + i;
        }
        return p;
    }

    /**
     * add a row of tree a hexagon at given position
     *
     * @param position the start position(left) of the row of this hexagon
     * @param width    the width of this row
     * @param world    the given world in which we draw this row
     */
    private static void addRowTree(Position position, int width, TETile[][] world) {
        int boundary = world[0].length;
        if (width + position.x > boundary) {
            throw new IllegalArgumentException("Out of boundary");
        }
        for (int i = 0; i < width; i++) {
            world[position.x + i][position.y] = Tileset.TREE;
        }
    }

    /**
     * add a row of flower a hexagon at given position
     *
     * @param position the start position(left) of the row of this hexagon
     * @param width    the width of this row
     * @param world    the given world in which we draw this row
     */
    private static void addRowFlower(Position position, int width, TETile[][] world) {
        int boundary = world[0].length;
        if (width + position.x > boundary) {
            throw new IllegalArgumentException("Out of boundary");
        }
        for (int i = 0; i < width; i++) {
            world[position.x + i][position.y] = Tileset.FLOWER;
        }
    }

    /**
     * add a row of mountain a hexagon at given position
     *
     * @param position the start position(left) of the row of this hexagon
     * @param width    the width of this row
     * @param world    the given world in which we draw this row
     */
    private static void addRowMountain(Position position, int width, TETile[][] world) {
        int boundary = world[0].length;
        if (width + position.x > boundary) {
            throw new IllegalArgumentException("Out of boundary");
        }
        for (int i = 0; i < width; i++) {
            world[position.x + i][position.y] = Tileset.MOUNTAIN;
        }
    }

    /**
     * add a hexagon of tree at given position
     *
     * @param size     the size of this hexagon
     * @param position the position(left bottom) of this hexagon
     * @param world    the world in which we draw this heaxgon
     */
    public static void addHexagonTree(int size, Position position, TETile[][] world) {
        for (int i = 0; i < 2 * size; i++) {
            Position p = findPosition(position, i, size);
            addRowTree(p, hexRowWidth(size, i), world);
        }
    }

    /**
     * add a hexagon of flower at given position
     *
     * @param size     the size of this hexagon
     * @param position the position(left bottom) of this hexagon
     * @param world    the world in which we draw this heaxgon
     */
    public static void addHexagonFlower(int size, Position position, TETile[][] world) {
        for (int i = 0; i < 2 * size; i++) {
            Position p = findPosition(position, i, size);
            addRowFlower(p, hexRowWidth(size, i), world);
        }
    }

    /**
     * add a hexagon of mountain at given position
     *
     * @param size     the size of this hexagon
     * @param position the position(left bottom) of this hexagon
     * @param world    the world in which we draw this heaxgon
     */
    public static void addHexagonMountain(int size, Position position, TETile[][] world) {
        for (int i = 0; i < 2 * size; i++) {
            Position p = findPosition(position, i, size);
            addRowMountain(p, hexRowWidth(size, i), world);
        }
    }

    /**
     * find the top hexagon start point(left bottom)
     *
     * @param position the start point under this hexagon
     * @param size     the size of the hexagon
     * @return
     */
    private static Position findTop(Position position, int size) {
        Position p = new Position(position.x, position.y);
        p.y = p.y + 2 * size;
        return p;
    }

    /**
     * Draw three hexagons
     *
     * @param p     the start point of these three hexagons
     * @param size  the size of each hexagons
     * @param world the world in which we draw the hexagons
     */
    private static void threeHexagon(Position p, int size, TETile[][] world) {
        for (int i = 0; i < 3; i++) {
            addHexagonTree(size, p, world);
            p = findTop(p, size);
        }
    }

    /**
     * Draw three hexagons
     *
     * @param p     the start point of these three hexagons
     * @param size  the size of each hexagons
     * @param world the world in which we draw the hexagons
     */
    private static void fourHexagon(Position p, int size, TETile[][] world) {
        for (int i = 0; i < 4; i++) {
            addHexagonFlower(size, p, world);
            p = findTop(p, size);
        }
    }

    /**
     * Draw three hexagons
     *
     * @param p     the start point of these three hexagons
     * @param size  the size of each hexagons
     * @param world the world in which we draw the hexagons
     */
    private static void fiveHexagon(Position p, int size, TETile[][] world) {
        for (int i = 0; i < 5; i++) {
            addHexagonMountain(size, p, world);
            p = findTop(p, size);
        }
    }

    public static void main(String[] args) {
        /* Print a single hexagon
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Position p = new Position(20, 20);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        int height = world[0].length;
        int width = world.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        addHexagon(3, p, world);
        ter.renderFrame(world);
         */

        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
        Position p1 = new Position(20, 20);
        Position p2 = new Position(27, 16);
        Position p3 = new Position(34, 12);
        Position p4 = new Position(41, 16);
        Position p5 = new Position(48, 20);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        int height = world[0].length;
        int width = world.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        threeHexagon(p1, 4, world);
        fourHexagon(p2, 4, world);
        fiveHexagon(p3, 4, world);
        fourHexagon(p4, 4, world);
        threeHexagon(p5, 4, world);
        ter.renderFrame(world);
    }
}
