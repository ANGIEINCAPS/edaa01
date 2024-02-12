import java.util.Random;

public class Board {
    private int noPins;

    Random random = new Random();

    public Board() {
        setUp(random.nextInt(5) + 5);
    }

    public void setUp(int noPins) {
        this.noPins = noPins;
    }

    public void takePins(int pinsRemoved) {
        noPins -= pinsRemoved;
    }

    public int getNoPins() {
        return noPins;
    }
}
