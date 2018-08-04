package controller.controller;

import java.io.File;

import controller.manager.FileManager;
import controller.manager.SmartJumperManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class InstallationController {
	
	private File dir = new File(System.getProperty("user.home"));
	
	@FXML
	private TextField currentPathTextField;
	
	@FXML
	private void initialize() {
		currentPathTextField.setText(dir.getPath());
	}
	
	@FXML
	private void choosePathButtonAction() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Choose a file directory to save the data.");
		directoryChooser.setInitialDirectory(dir);
		dir = directoryChooser.showDialog(SmartJumperManager.getInstance().getStage());
		try {
			currentPathTextField.setText(dir.getPath());
		}catch(NullPointerException ex) {
			//Path is empty here, so we need to do nothing
		}
	}
	
	@FXML
	private void nextButtonAction() {
		FileManager.getInstance().createNewFile(currentPathTextField.getText() + "/SmartJumper.json");
	}
}