package view.panels.inputPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import dao.DAO;

public class C_InputPanel {
	// temp area	
	private JPanel panel;
	private GridBagConstraints c;
	
	private B_DataGeneratorInputPanel data;
	
	public C_InputPanel() {
		panel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		
		data = new B_DataGeneratorInputPanel();
	
		buildPanel();
	}
	
	private void buildPanel() {
		List<JButton> inputButtons = data.getTileButtons();
		
		int numRows = 0;
		int numCols = 0;
		if (inputButtons.size() <= 128) {
			numRows = 16;
			numCols = 8;
		} else if (inputButtons.size() <= 192) {
			numRows = 16;
			numCols = 12;
		} else if (inputButtons.size() <= 256) {
			numRows = 16;
			numCols = 16;
		}
		
		int bound = inputButtons.size();
		int buttonCount = 0;
		JButton curButton;
		c.gridx = 0;
		c.gridy = 0;
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		// build row(s)
		for (int i = 0; i < numRows; i++) {
			// Build column
			for (int j = 0; j < numCols; j++) {
				curButton = inputButtons.get(buttonCount);
				curButton.setBorder(border);
				curButton.setSize(DAO.getUserPreferences().getScaledTileWidth(), DAO.getUserPreferences().getScaledTileHeight());
				
				panel.add(curButton, c);
		
				// Check if bounds reached before continuing
				buttonCount++;
				if (buttonCount == bound)
					return;
				
				// move to next column if applicable
				c.gridx++;
			}
			// move to next row if applicatble
			c.gridx = 0;
			c.gridy++;
		}		
	}
	
	public JPanel getUserInputPanel() {
		return panel;
	}
	
	public void clearUserInputPanel() {
		panel = new JPanel(new GridBagLayout());
	}
	
}
