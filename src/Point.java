/**
 * <p>
 * This class handles the calculation of both the local Chunk and Nether
 * coordinates based on the given point's coordinates.
 * </P>
 * 
 */

public class Point {
    private int x;
    private int y;

    /**
     * Constructs a new Point object with the given x and y coordinates.
     *
     * @param x The x-coordinate of the given Point.
     * @param y The y-coordinate of the given Point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a string representation of the local chunk coordinates based on the
     * given Point's coordinates.
     *
     * @return A string in the format "Local Chunk:\nfrom (x1, y1) to (x2, y2)".
     *         x1 and y1 represent the starting coordinates of the local chunk,
     *         calculated using the {@link #pointOneCoordinates(int)} method.
     *         x2 and y2 represent the ending coordinates of the local chunk,
     *         calculated using the {@link #pointTwoCoordinates(int)} method.
     */
    public String localChunk() {
        return "Local Chunk:\nfrom (" + pointOneCoordinates(x) + ", " + pointOneCoordinates(y) + ")" +
                " to (" + pointTwoCoordinates(x) + ", " + pointTwoCoordinates(y) + ")";
    }

    /**
     * Calculates and returns the Nether coordinates based on the given point.
     *
     * @return A string representing the Nether coordinates in the format "Nether
     *         Location: (x, y)".
     *         The x and y values are the coordinates divided by 8.
     */
    public String netherCoordinates() {
        int netherX = x / 8;
        int netherY = y / 8;
        return "Nether Location: (" + netherX + ", " + netherY + ")";
    }

    private int playersLocationInChunk(int cordInput) {
        int cord;
        if (cordInput < 0) {
            cord = (Math.abs(cordInput) % 16) - 1;
        } else {
            cord = (Math.abs(cordInput) % 16);
        }
        return cord;
    }

    private int pointOneCoordinates(int cordInput) {
        int cord;
        if (cordInput >= 0) {
            cord = cordInput - playersLocationInChunk(cordInput);
        } else {
            cord = (cordInput + playersLocationInChunk(cordInput)) - 15;
        }
        return cord;
    }

    private int pointTwoCoordinates(int cordInput) {
        return pointOneCoordinates(cordInput) + 15;
    }

    /**
     * String representation of the the given Point(P0).
     * 
     * @return String format: "P0: (x, y)"
     */
    public String toString() {
        return "P0: (" + x + ", " + y + ")";
    }
}
