package controller.manager;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FileManager {
	
	private static final FileManager fileManager = new FileManager();
	private FileManager() {}
	public static FileManager getInstance() {
		return fileManager;
	}
	
	public void createNewFile(String url) {
		File file = new File(url);
		try {
			if(file.createNewFile()) {
				Logger.getAnonymousLogger().info(() -> "Created the file " + url + ".");
			}
		} catch (IOException ex) {
			Logger.getAnonymousLogger().severe(ex.getMessage());
		}
	}
}