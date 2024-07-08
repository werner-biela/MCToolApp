public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String localChunk() {
        return "Local Chunk:\nfrom (" + pointOneCord(x) + ", " + pointOneCord(y) + ")" +
                " to (" + pointTwoCord(x) + ", " + pointTwoCord(y) + ")";
    }

    public String netherCord() {
        int netherX = x / 8;
        int netherY = y / 8;
        return "Nether Location: (" + netherX + ", " + netherY + ")";
    }

    private int cordMod(int cordInput) {
        int cord;
        if (cordInput < 0) {
            cord = (Math.abs(cordInput) % 16) - 1;
        } else {
            cord = (Math.abs(cordInput) % 16);
        }
        return cord;
    }

    private int pointOneCord(int cordInput) {
        int cord;
        if (cordInput >= 0) {
            cord = cordInput - cordMod(cordInput);
        } else {
            cord = (cordInput + cordMod(cordInput)) - 15;
        }
        return cord;
    }

    private int pointTwoCord(int cordInput) {
        return pointOneCord(cordInput) + 15;
    }

    public String toString() {
        return "P0: (" + x + ", " + y + ")";
    }
}
