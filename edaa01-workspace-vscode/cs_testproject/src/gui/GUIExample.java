package gui;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GUIExample {
	private int counter;
	private JLabel label;

	public GUIExample() {
		SwingUtilities.invokeLater(() -> createWindow());
	}

	private void createWindow() {
		JFrame frame = new JFrame("A small GUI Exmple");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		JButton button = new JButton("Click!");
		button.addActionListener(event -> {
			counter ++;
			label.setText(Integer.toString(counter));	
		});
		label = new JLabel("0");	
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 50));
		panel.add(button);
		panel.add(label);
		pane.add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new GUIExample();
	}

}
