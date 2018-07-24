package controller.controller;

import controller.manager.GameManager;
import controller.manager.SceneManager;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.constants.Roots;
import model.constants.Titles;

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
		SceneManager sceneManager = SceneManager.getInstance();
		sceneManager.getStage().setTitle(Titles.GAME);
		sceneManager.setScene(Roots.GAME);
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