package view.panels.curSelectedPanel;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dao.DAO;

public class B_CurSelectedPanel extends A_DataOfCurSelectedPanel {
	private JPanel panel;
	private JLabel label;
	
	public B_CurSelectedPanel() {
		panel = new JPanel();
		
		DAO.setCurSelectedImage(super.getCurSelectedImage());
		label = new JLabel(new ImageIcon(super.getCurSelectedImage()));
		
		panel.add(label);
	}
	
	public void refresh() {
		panel.remove(label);
		super.setCurSelctedImage(DAO.getCurSelectedImage());
		label = new JLabel(new ImageIcon(super.getCurSelectedImage()));		
		panel.add(label);
	}
	
	public JPanel getCurSelectedPanel() {
		return panel;
	}
}
