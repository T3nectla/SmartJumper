package controller.controller;

import controller.manager.EntityManager;
import controller.manager.GameManager;
import controller.manager.GameStateManager;
import controller.manager.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.constants.GameState;

public class GameController {

	@FXML
	private Canvas gameCanvas;
	@FXML
	private BorderPane root;
	
	private boolean keyPressed = false;
	
	@FXML
	private void initialize() {
		SceneManager.getInstance().setCanvas(gameCanvas);
	}
	
	@FXML
	private void gameKeyPressed(KeyEvent e) {
		if(keyPressed) {
			return;
		}
		
		GameStateManager gameStateManager = GameStateManager.getInstance();
		switch(e.getCode()) {
			case SPACE:
				EntityManager.getInstance().getPlayer().jump();
				break;
			case P:
				keyPressed = true;

				if (gameStateManager.getCurrentGameState() == GameState.RUNNING) {
					GameManager.getInstance().pause();
					return;
				}
				
				if (gameStateManager.getCurrentGameState() == GameState.PAUSING) {
					GameManager.getInstance().play();
				}
				break;
			case N:
				if(gameStateManager.getCurrentGameState() == GameState.STOPPING) {
					GameManager.getInstance().start();
				}
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
			case P:
				keyPressed = false;
				break;
			default:
				break;
		}
	}
}