package controller.manager;

import model.constants.GameState;
import view.gamestate.GameStateTextView;

public class GameStateManager {

	private GameState currentGameState;
	private GameStateTextView gameStateTextView;
	
	private static final GameStateManager gameStateManager = new GameStateManager();
	private GameStateManager() {}
	public static GameStateManager getInstance() {
		return gameStateManager;
	}
	
	public void initialize() {
		currentGameState = GameState.NEW;
		gameStateTextView = new GameStateTextView("");
	}
	
	public void setCurrentGameState(GameState gameState) {
		if(this.currentGameState == gameState) {
			return;
		}
		if(checkFalseGameState(gameState)) {
			throw new IllegalStateException();
		}
		currentGameState = gameState;
	}
	public GameState getCurrentGameState() {
		return currentGameState;
	}
	
	public void setGameStateTextView(GameStateTextView gameStateTextView) {
		this.gameStateTextView = gameStateTextView;
	}
	public void setGameStateTextView(String gameStateStr) {
		gameStateTextView.setGameStateStr(gameStateStr);
	}
	public GameStateTextView getGameStateTextView() {
		return gameStateTextView;
	}
	
	private boolean checkFalseGameState(GameState currentGameState) {
		boolean checkFailedState = false;
		switch(currentGameState) {
			case NEW:
				checkFailedState = checkAllowedPrevGameState();
				break;
			case RUNNING:
				checkFailedState = checkAllowedPrevGameState(GameState.NEW, GameState.PAUSING, GameState.STOPPING);
				break;
			case PAUSING:
				checkFailedState = checkAllowedPrevGameState(GameState.RUNNING);
				break;
			case STOPPING:
				checkFailedState = checkAllowedPrevGameState(GameState.RUNNING);
				break;
			default:
				checkFailedState = checkAllowedPrevGameState();
				break;
		}
	
		return checkFailedState;
	}
	
	private boolean checkAllowedPrevGameState(GameState... allowedPrevGameStates) {
		boolean checkFailedState = true;
		for(GameState allowedPrevGameState : allowedPrevGameStates) {
			if(currentGameState == allowedPrevGameState) {
				checkFailedState = false;
				break;
			}
		}
		
		return checkFailedState;
	}
}