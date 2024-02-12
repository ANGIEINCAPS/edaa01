public class TakePinsGame {
    public static void main(String[] args) {
        Board board = new Board();
        HumanPlayer h = new HumanPlayer("Mario");
        //ComputerPlayer c = new ComputerPlayer("Luigi");
        Terminator c = new Terminator("Waluigi");

        UserInterface.printMessage("Pins game initiated starting with " + board.getNoPins() + " pins.");

        while (board.getNoPins() > 0) {
            UserInterface.printMessage(h.getUserId() + " took " + h.takePins(board) + " pins");
            if (board.getNoPins() <= 0) {
                UserInterface.printMessage(h.getUserId() + " won the game!");
                return;
            }
            UserInterface.printMessage(board.getNoPins() + " pins remain");


            UserInterface.printMessage(c.getUserId() + " took " + c.takePins(board) + " pins");
            if (board.getNoPins() <= 0) {
                UserInterface.printMessage(c.getUserId() + " won the game!");
                return;
            }
            UserInterface.printMessage(board.getNoPins() + " pins remain");

        }

    }
}
