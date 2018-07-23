package controller.manager;

import java.io.IOException;
import java.util.logging.Logger;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class FXLoader {
	
	private static final FXLoader fxLoader = new FXLoader();
	private FXLoader() {}
	public static FXLoader getInstance() {
		return fxLoader;
	}
	
	public Parent load(String url) {
		Parent loadedRoot = null;
		
		try {
			loadedRoot = FXMLLoader.load(FXLoader.class.getResource(url));
		} catch (NullPointerException | IOException ex) {
			Logger.getAnonymousLogger().severe("Root could not be loaded!");
			Platform.exit();
		}
		
		return loadedRoot;
	}
}