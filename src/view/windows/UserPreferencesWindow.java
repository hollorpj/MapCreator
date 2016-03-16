package view.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.userPreferences.UserPreferencesBrowseListener;
import listeners.userPreferences.UserPreferencesOkListener;

public class UserPreferencesWindow {
	private JFrame window;
	private JPanel panel;
	private JTextField resourceLocation;
	private JButton browseButton;
	private JTextField resourceWidth;
	private JTextField resourceHeight;
	private JTextField selectedTileset;
	private JTextField outputWidth;
	private JTextField outputHeight;
	private JTextField scaledWidth;
	private JTextField scaledHeight;
	private JButton okButton;
	
	public UserPreferencesWindow() {
		initializeComponents();
		layoutComponents();
		display();
	}
	
	private void initializeComponents() {		
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridBagLayout());		
		
		resourceLocation = new JTextField(20);
		resourceLocation.setText("Resource Folder");
		
		browseButton = new JButton("Browse");
		browseButton.addActionListener(new UserPreferencesBrowseListener(resourceLocation));
		
		resourceWidth = new JTextField(10);
		resourceWidth.setText("Number of columns for input tiles");
		
		resourceHeight = new JTextField(10);
		resourceHeight.setText("Number of rows for input tiles");
		
		selectedTileset = new JTextField(10);
		selectedTileset.setText("Name of input tile set");
		
		scaledWidth = new JTextField(10);
		scaledWidth.setText("Scaled width");
		
		scaledHeight = new JTextField(10);
		scaledHeight.setText("Scaled height");
		
		outputWidth = new JTextField(10);
		outputWidth.setText("Output Width");
		
		outputHeight = new JTextField(10);
		outputHeight.setText("Output Height");
		
		okButton = new JButton("OK");
		okButton.addActionListener(new UserPreferencesOkListener(selectedTileset, resourceWidth, resourceHeight, resourceLocation, scaledWidth, scaledHeight, outputWidth, outputHeight));
	}
	
	private void layoutComponents() {
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 1;
		panel.add(resourceLocation, c);
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(browseButton, c);
		
		c.gridx = 0;
		c.gridy = 2;
		panel.add(resourceWidth, c);
		
		c.gridx = 1;
		c.gridy = 2;
		panel.add(resourceHeight, c);
		
		c.gridx = 0;
		c.gridy = 3;
		panel.add(scaledWidth, c);
		
		c.gridx = 1;
		c.gridy = 3;
		panel.add(scaledHeight, c);
		
		
		c.gridx = 0;
		c.gridy = 4;
		panel.add(outputWidth, c);
		
		c.gridx = 1;
		c.gridy = 4;
		panel.add(outputHeight, c);
		
		c.gridx = 0;
		c.gridy = 5;
		panel.add(selectedTileset, c);
		
		
		
		c.gridx = 2;
		c.gridy = 5;
		panel.add(okButton, c);
	}
	
	private void display() {
		window.add(panel);
		window.pack();
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UserPreferencesWindow();
	}
}
