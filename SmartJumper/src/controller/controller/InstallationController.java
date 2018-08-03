package controller.controller;

import java.io.File;

import controller.manager.SmartJumperManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

public class InstallationController {
	
	@FXML
	private TextField currentPathTextField;
	
	@FXML
	Button choosePathButton;
	
	@FXML
	private void initialize() {
		currentPathTextField.setText(System.getProperty("user.home"));
	}
	
	@FXML
	private void choosePathButtonAction() {
			DirectoryChooser directoryChooser = new DirectoryChooser();
			directoryChooser.setTitle("Choose a file directory to save the data.");
			directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			File dir = directoryChooser.showDialog(SmartJumperManager.getInstance().getStage());
			try {
				currentPathTextField.setText(dir.getPath());
			}catch(NullPointerException ex) {
				//Path is empty here, so we need to do nothing
			}
	}
}