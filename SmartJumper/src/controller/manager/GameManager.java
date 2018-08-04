 package controller.manager;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import model.constants.GameState;
import model.entity.Entity;
import model.view.View;
import view.helpline.HelpLineView;

public class GameManager {

	public static final double FPS = 1000d/60d;
	
	
	private Timeline gameTimeline;
	private Canvas gameCanvas;
	
	private static final GameManager gameManager = new GameManager();
	private GameManager() {}
	public static GameManager getInstance() {
		return gameManager;
	}
	
	public void initialize() {
		SmartJumperManager smartJumperManager = SmartJumperManager.getInstance();
		gameCanvas = smartJumperManager.getCanvas();
		gameCanvas.setWidth(smartJumperManager.getScene().getWidth());
		gameCanvas.setHeight(smartJumperManager.getScene().getHeight());
		smartJumperManager.setCanvas(gameCanvas);
		
		GameStateManager.getInstance().initialize();
		
		if(gameTimeline == null) {
			gameTimeline = new Timeline(new KeyFrame(Duration.millis(FPS), e-> draw()));
			gameTimeline.setCycleCount(Timeline.INDEFINITE);
		}
		
		smartJumperManager.getScene().getRoot().requestFocus();
	}
	
	public void start() {
		ViewManager viewManager = ViewManager.getInstance();
		viewManager.clear();
		
		TileManager tileManager = TileManager.getInstance();
		tileManager.spawnGroundTile();
		
		EntityManager entityManager = EntityManager.getInstance();
		entityManager.spawnPlayer();
		entityManager.spawnEnemy();
		
		viewManager.addViews(entityManager.getViews());
		viewManager.addView(entityManager.getScoreView());
		viewManager.addView(tileManager.getGroundTileView());
		viewManager.addView(new HelpLineView(entityManager.getPlayer()));
		GameStateManager gameStateManager = GameStateManager.getInstance();
		viewManager.addView(gameStateManager.getGameStateTextView());
		
		if(gameStateManager.getCurrentGameState() == GameState.NEW) {
			gameTimeline.play();
			return;
		}
		play();
	}
	
	public void nextEnemy() {
		EntityManager entityManager = EntityManager.getInstance();
		entityManager.spawnEnemy();
		ViewManager.getInstance().updateView(entityManager.getEnemyView());
	}

	
	public void play() {
		GameStateManager gameStateManager = GameStateManager.getInstance();
		gameStateManager.setCurrentGameState(GameState.RUNNING);
		gameStateManager.setGameStateTextView("");
		gameTimeline.play();
	}
	
	
	public void pause() {
		GameStateManager gameStateManager = GameStateManager.getInstance();
		gameStateManager.setCurrentGameState(GameState.PAUSING);
		gameStateManager.setGameStateTextView("Press P to unpause the game");
		ViewManager.getInstance().updateView(gameStateManager.getGameStateTextView());
	}
	
	public void stop() {	
		GameStateManager gameStateManager = GameStateManager.getInstance();
		gameStateManager.setCurrentGameState(GameState.STOPPING);
		gameStateManager.setGameStateTextView("GAME OVER\nPress N to start a new game");
		ViewManager.getInstance().updateView(gameStateManager.getGameStateTextView());
	}
	
	private void draw() {
		gameCanvas.getGraphicsContext2D().clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
		
		for(Entity entity : EntityManager.getInstance().getEntities()) {
			entity.grav();
			entity.update();
		}
		
		for(View view : ViewManager.getInstance().getViews()) {
			view.show();
		}
		
		doGameState();
	}
	
	private void doGameState() {
		GameStateManager gameStateManager = GameStateManager.getInstance();
		switch(gameStateManager.getCurrentGameState()) {
			case NEW:
				play();
				pause();
				break;
			case PAUSING:
				gameTimeline.pause();
				break;
			case STOPPING:
				gameTimeline.stop();
				break;
			default:
				break;
		}
	}
}