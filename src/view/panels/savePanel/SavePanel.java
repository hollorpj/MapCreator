package view.panels.savePanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.savePanel.BrowseButtonListener;
import listeners.savePanel.SaveButtonListener;

public class SavePanel {
	private JPanel main;
	private JTextField location;
	private JButton browseFile;
	private JButton save;
	
	public SavePanel() {
		initComponents();
		layoutComponents();
	}
	
	private void initComponents() {
		main = new JPanel(new GridBagLayout());
		location = new JTextField(15);
		location.setToolTipText("Directory to save output");
		browseFile = new JButton("Browse");
		browseFile.addActionListener(new BrowseButtonListener(location));
		save = new JButton("Save");
		save.addActionListener(new SaveButtonListener(location));
	}
	
	private void layoutComponents() {
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 0;
		c.gridy = 0;
		main.add(location, c);
		
		c.gridx = 1;
		main.add(browseFile, c);
		
		c.gridx = 1;
		c.gridy = 1;
		main.add(save, c);		
	}
	
	public JPanel getSavePanel() {
		return main;
	}
}
