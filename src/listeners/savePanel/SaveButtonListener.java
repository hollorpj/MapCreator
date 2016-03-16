package listeners.savePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import dao.DAO;
import procedures.system.SaveProcedure;

public class SaveButtonListener implements ActionListener {
	JTextField saveLocation;
	
	public SaveButtonListener(JTextField location) {
		this.saveLocation = location;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		DAO.getSystemPreferences().setOutputLocation(saveLocation.getText());
		new SaveProcedure();
	}

	
}
