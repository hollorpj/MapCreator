package view.panels.outputPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import dao.DAO;

public class C_OutputPanel extends B_DataGeneratorOutputPanel {
	private JPanel main;
	private List<JButton> tileButtons;
	
	private GridBagConstraints c;
	
	public C_OutputPanel() {
		super();
		this.main = new JPanel(new GridBagLayout());
		this.tileButtons = super.getTileButtons();
		
		this.c = new GridBagConstraints();
		
		buildPanel();
	}
	
	private void buildPanel() {
		int numCols = DAO.getUserPreferences().getOutputWidth();
		int numRows = DAO.getUserPreferences().getOutputHeight();
		
		c.gridx = 0;
		c.gridy = 0;
		
		JButton curButton;
		int count = 0;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				curButton = tileButtons.get(count);

				main.add(curButton, c);				
				c.gridx++;
				System.out.println(i + " " + j);
				
				count++;
			}
			c.gridy++;
			c.gridx = 0;
		}
	}
	
	public JPanel getOutputPanel() {
		System.out.println("Got");
		return main;
	}
}