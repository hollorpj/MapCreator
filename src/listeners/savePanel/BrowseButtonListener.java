package listeners.savePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class BrowseButtonListener implements ActionListener {
	private JTextField saveLocation;
	
	public BrowseButtonListener(JTextField saveLocation) {
		this.saveLocation = saveLocation;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser choose = new JFileChooser();
		choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int returnVal = choose.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			saveLocation.setText(choose.getSelectedFile().getAbsolutePath());
		}
	}

}
