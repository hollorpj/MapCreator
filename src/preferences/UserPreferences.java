package preferences;

public class UserPreferences {
	private String resourceFolder;
	private int inputWidth;
	private int inputHeight;
	private int outputWidth;
	private int outputHeight;
	private String selectedTileset;
	private int scaledTileWidth;
	private int scaledTileHeight;
	
	
	public UserPreferences() {}
	
	public int getOutputWidth() {
		return outputWidth;
	}

	public void setOutputWidth(int outputWidth) {
		this.outputWidth = outputWidth;
	}

	public int getOutputHeight() {
		return outputHeight;
	}

	public void setOutputHeight(int outputHeight) {
		this.outputHeight = outputHeight;
	}

	public int getScaledTileWidth() {
		return scaledTileWidth;
	}

	public void setScaledTileWidth(int outputWidth) {
		this.scaledTileWidth = outputWidth;
	}

	public int getScaledTileHeight() {
		return scaledTileHeight;
	}

	public void setScaledTileHeight(int outputHeight) {
		this.scaledTileHeight = outputHeight;
	}

	public String getSelectedTileset() {
		return selectedTileset;
	}
	
	public void setSelectedTileset(String selectedTileset) {
		this.selectedTileset = selectedTileset;
	}
	
	public int getInputWidth() {
		return inputWidth;
	}
	
	public void setInputWidth(int inputWidth) {
		this.inputWidth = inputWidth;
	}

	public int getInputHeight() {
		return inputHeight;
	}

	public void setInputHeight(int inputHeight) {
		this.inputHeight = inputHeight;
	}
	
	public void setResourceFolder(String resourceFolder) {
		this.resourceFolder = resourceFolder;
	}
	
	public String getResourceFolder() {
		return this.resourceFolder;
	}	
}
