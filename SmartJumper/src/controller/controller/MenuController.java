package controller.controller;

import controller.manager.GameManager;
import controller.manager.SmartJumperManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.constants.Root;
import model.constants.Title;

public class MenuController {
	
	@FXML
	private Button playButton;
	@FXML
	private Button aiButton;
	@FXML
	private Button exitButton;
	
	@FXML
	private void initialize() {
		//Empty for now
	}
	
	@FXML
	private void playButtonAction() {
		SmartJumperManager sceneManager = SmartJumperManager.getInstance();
		sceneManager.getStage().setTitle(Title.GAME);
		sceneManager.setScene(Root.GAME);
		GameManager gameManager = GameManager.getInstance();
		gameManager.initialize();
		gameManager.start();
	}
	@FXML
	private void aiButtonAction() {
		//Empty for now
	}
	@FXML
	private void exitButtonAction() {
		Platform.exit();
	}
}