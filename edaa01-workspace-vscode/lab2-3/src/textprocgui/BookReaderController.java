package textprocgui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.Position;

import textproc.GeneralWordCounter;
import textprocview.SortedListModel;

public class BookReaderController {

    public BookReaderController(GeneralWordCounter counter) {
        SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
    }

    private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();

        /*
         * pane är en hehållarkomponent till vilken de övriga komponenterna (listvy,
         * knappar etc.) ska läggas till
         */

        /* JPanel är för knapparna längst ner i fönstret */
        JPanel panel = new JPanel();
        JButton alphabetic = new JButton("Alphabetic");
        JButton frequency = new JButton("Frequency");
        JButton search = new JButton("Search");
        JTextField searchBar = new JTextField(20);
        panel.add(alphabetic);
        panel.add(frequency);
        panel.add(search);
        panel.add(searchBar);

        pane.add(panel, BorderLayout.SOUTH);

        List<Map.Entry<String, Integer>> wordList = counter.getWordList();
        wordList.removeIf(e -> Character.isDigit(e.getKey().charAt(0)));

        SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>(wordList);
        JList<Map.Entry<String, Integer>> list = new JList<>(model);

        JScrollPane scroll = new JScrollPane(list);
        pane.add(scroll);

        frame.pack();
        frame.setVisible(true);

        /* Sorting for frequency descending */
        Comparator<Map.Entry<String, Integer>> compareFrequency = (e1, e2) -> {
            return e2.getValue().compareTo(e1.getValue());
        };
        frequency.addActionListener(e -> model.sort(compareFrequency));

        /* Sorting alphabetically */
        Comparator<Map.Entry<String, Integer>> compareAlphabetic = (e1, e2) -> {
            return e1.getKey().compareTo(e2.getKey());
        };
        alphabetic.addActionListener(e -> model.sort(compareAlphabetic));


        search.addActionListener(e -> {
		    String query = searchBar.getText().toLowerCase().replace(" ", "");
		    int i = -1; 				// -1 = inte hittad
		    
		    i = list.getNextMatch(query, 0, Position.Bias.Forward);

            if (i != -1) {
		    	list.setSelectedIndex(i);
		    	list.ensureIndexIsVisible(i);
		    }
		    else {
		    	JOptionPane.showMessageDialog(null, "Word not found", "Fatal error!", JOptionPane.INFORMATION_MESSAGE);
		    }
        });

        frame.getRootPane().setDefaultButton(search);


    }

}
