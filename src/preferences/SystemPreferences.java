package preferences;

import java.io.File;
import java.util.Date;

import dao.DAO;

public class SystemPreferences {
	private String missingImageLocation;
	private String outputLocation;
	private String outputTileLocation;
	private String outputMapLocation;
	private String stamp;
	
	public SystemPreferences() {
		UserPreferences userPreferences = DAO.getUserPreferences();
				
		this.stamp = String.valueOf(new Date(System.currentTimeMillis()));
		setMissingImageLocation(userPreferences.getResourceFolder() + "/Sys/missingTile.png");
		setOutputLocation(userPreferences.getResourceFolder() + "/Output/generated_" + stamp);
		setOutputTileLocation(outputLocation + "/tiles");
		setOutputMapLocation(outputMapLocation = outputLocation + "/map");
	}	

	public String getOutputLocation() {
		return outputLocation;
	} 
	
	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
		setOutputTileLocation(outputLocation + "/tiles");
		setOutputMapLocation(outputLocation + "/map");		
	}

	public String getOutputTileLocation() {
		return outputTileLocation;
	}

	public void setOutputTileLocation(String outputTileLocation) {
		new File(outputTileLocation).mkdirs();
		this.outputTileLocation = outputTileLocation;
	}

	public String getOutputMapLocation() {
		return outputMapLocation;
	}

	public void setOutputMapLocation(String outputMapLocation) {
		new File(outputMapLocation).mkdirs();
		this.outputMapLocation = outputMapLocation;
	}

	public String getMissingImageLocation() {
		return missingImageLocation;
	}
	
	public void setMissingImageLocation(String missingImageLocation) {
		new File(missingImageLocation).mkdirs();
		this.missingImageLocation = missingImageLocation;
	}	
	
	
}
