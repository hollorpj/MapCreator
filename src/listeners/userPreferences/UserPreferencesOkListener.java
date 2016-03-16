package listeners.userPreferences;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import dao.DAO;
import preferences.UserPreferences;
import view.panels.inputPanel.B_DataGeneratorInputPanel;
import view.windows.B_MainWindow;

public class UserPreferencesOkListener implements ActionListener {
	private JTextField resourceWidth;
	private JTextField resourceHeight;
	private JTextField locationField;
	private JTextField tilesLocation;
	private JTextField scaledWidth;
	private JTextField scaledHeight;
	private JTextField outputWidth;
	private JTextField outputHeight;
	
	public UserPreferencesOkListener(JTextField tilesLocation, JTextField resourceWidth, JTextField resourceHeight, JTextField locationField, JTextField scaledtWidth, JTextField scaledHeight, JTextField outputWidth, JTextField outputHeight) {
		this.locationField = locationField;
		this.resourceWidth = resourceWidth;
		this.resourceHeight = resourceHeight;
		this.tilesLocation = tilesLocation;
		this.scaledWidth = scaledtWidth;
		this.scaledHeight = scaledHeight;
		this.outputWidth = outputWidth;
		this.outputHeight = outputHeight;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Tells system where to find properties file along with tilesets
		UserPreferences u = DAO.getUserPreferences();
		u.setResourceFolder(locationField.getText());
		u.setInputWidth(Integer.parseInt(resourceWidth.getText()));
		u.setInputHeight(Integer.parseInt(resourceHeight.getText()));
		u.setSelectedTileset(tilesLocation.getText());
		u.setScaledTileWidth(Integer.parseInt(scaledWidth.getText()));
		u.setScaledTileHeight(Integer.parseInt(scaledHeight.getText()));
		u.setOutputWidth(Integer.parseInt(outputWidth.getText()));
		u.setOutputHeight(Integer.parseInt(outputHeight.getText()));
		
		DAO.buildProperties();
		
		System.out.println("dooaas");
		// Initiates building of main screen
		new B_DataGeneratorInputPanel();
		System.out.println("moodesl");
		//new C_InputPanel();
				
		DAO.setMainWindow(new B_MainWindow());
	}
	
}
