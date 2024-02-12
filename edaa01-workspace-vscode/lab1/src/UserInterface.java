import javax.swing.JOptionPane;

public class UserInterface {
    /** Visar en dialogruta med texten msg. */
    public static void printMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    /**
    * Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
    * användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
    * returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
    */
    public static int askForInt(String msg) {
        String input = JOptionPane.showInputDialog("Enter how many pins you want to remove: ");

        if (input == null) return -2;

        try {
            int n = Integer.parseInt(input);
            if (n == 1 || n == 2) return n;
        } catch (NumberFormatException e) {

        }

        return -1;
    }
}