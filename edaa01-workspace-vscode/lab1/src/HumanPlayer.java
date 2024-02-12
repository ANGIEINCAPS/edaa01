import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String userId) {
        super(userId);

    }

    @Override
    public int takePins(Board board) {
        //System.out.println("How many pins do you want to pick?");
        // int input = scanner.nextInt();
        int input = UserInterface.askForInt(getUserId() + ", input how many pins you wish to take: ");

        if (input == 1 || input == 2) {
            board.takePins(input);
        } else {
            UserInterface.printMessage("Invalid input. Try again.");
            takePins(board);
        }

        return input;
    }
}
