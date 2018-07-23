package controller.controller;

import controller.manager.GameManager;
import controller.manager.EntityManager;
import controller.manager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class GameController {

	@FXML
	private Canvas gameCanvas;
	@FXML
	private BorderPane root;
	
	@FXML
	private void initialize() {
		gameCanvas.setWidth(root.getPrefWidth());
		gameCanvas.setHeight(root.getPrefHeight());
		
		SceneManager.getInstance().setCanvas(gameCanvas);
	}
	
	@FXML
	private void gameKeyPressed(KeyEvent e) {
		switch(e.getCode()) {
			case SPACE:
				EntityManager.getInstance().getPlayer().jump();
				break;
			case P:
				GameManager.getInstance().initialize();
				GameManager.getInstance().start();
				break;
			default:
				break;
		}
	}
	@FXML
	private void gameKeyReleased(KeyEvent e) {
		switch(e.getCode()) {
			case SPACE:
				EntityManager.getInstance().getPlayer().cancelJump();
				break;
			default:
				break;
	}
	}
}