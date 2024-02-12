import java.util.Random;

public class ComputerPlayer extends Player {
    Random random = new Random();

    public ComputerPlayer(String userId) {
        super(userId);
    }

    @Override
    public int takePins(Board board) {
        int randomChoice = random.nextInt(2) + 1;
        board.takePins(randomChoice);

        return randomChoice;
    }

}