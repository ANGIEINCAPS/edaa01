public class Terminator extends Player {

    protected Terminator(String userId) {
        super(userId);
    }

    @Override
    public int takePins(Board board) {
        int pinsRemainder = board.getNoPins() % 3;

        if (pinsRemainder == 1) {
            board.takePins(1);
            return 1;
        } else {
            board.takePins(2);
            return 2;
        }
    }   
    
}
