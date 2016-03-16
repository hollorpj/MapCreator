package listeners.userPreferences;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class UserPreferencesBrowseListener implements ActionListener {
	private JTextField inputField;
	
	public UserPreferencesBrowseListener(JTextField input) {
		this.inputField = input;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int returnVal = choose.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			inputField.setText(choose.getSelectedFile().getAbsolutePath());
		}
	}
}
