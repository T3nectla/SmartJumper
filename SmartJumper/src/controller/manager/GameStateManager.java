package controller.manager;

import model.constants.GameState;
import view.stateview.GameStateTextView;

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
		if(checkFalseGameState(gameState)) {
			return;
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
			case STARTING:
				checkFailedState = checkAllowedPrevGameState(GameState.NEW);
				break;
			case RUNNING:
				checkFailedState = checkAllowedPrevGameState(GameState.STARTING, GameState.PAUSING, GameState.STOPPING);
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
		for(int i=0;i<allowedPrevGameStates.length;i++) {
			if(currentGameState == allowedPrevGameStates[i]) {
				checkFailedState = false;
				break;
			}
		}
		
		return checkFailedState;
	}
}