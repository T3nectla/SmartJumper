package controller.manager;

import model.constants.GameState;

public class GameStateManager {

	private GameState currentGameState;
	
	private static final GameStateManager gameStateManager = new GameStateManager();
	private GameStateManager() {}
	public static GameStateManager getInstance() {
		return gameStateManager;
	}
	
	public void initialize() {
		currentGameState = GameState.NEW;
	}
	
	public void setCurrentGameState(GameState gameState) {
		if(checkFalseGameState(gameState)) {
			return;
		}
		currentGameState = gameState;
	}
	public GameState getCurrentGameState() {
		return currentGameState;
	}
	
	private boolean checkFalseGameState(GameState gameState) {
		switch(gameState) {
			case NEW:
				return true;
			case STARTING:
				if(currentGameState != GameState.NEW) {
					return true;
				}
				break;
			case RUNNING:
				if(currentGameState == GameState.NEW) {
					return true;
				}
				break;
			case PAUSING:
				if(currentGameState != GameState.RUNNING) {
					return true;
				}
				break;
			case STOPPING:
				if(currentGameState != GameState.RUNNING) {
					return true;
				}
				break;
			default:
				return true;
		}
		
		return false;
	}
}