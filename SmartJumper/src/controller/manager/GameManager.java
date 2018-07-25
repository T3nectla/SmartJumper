package controller.manager;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import model.constants.Constants;
import model.constants.GameState;
import model.entity.Entity;
import model.view.View;
import view.helpline.HelpLineView;
import view.stateview.NewStateTextView;

public class GameManager {

	private Timeline gameTimeline;
	private Canvas gameCanvas;
	
	private static final GameManager gameManager = new GameManager();
	private GameManager() {}
	public static GameManager getInstance() {
		return gameManager;
	}
	
	public void initialize() {
		SceneManager sceneManager = SceneManager.getInstance();
		gameCanvas = sceneManager.getCanvas();
		gameCanvas.setWidth(sceneManager.getScene().getWidth());
		gameCanvas.setHeight(sceneManager.getScene().getHeight());
		sceneManager.setCanvas(gameCanvas);
		
		GameStateManager.getInstance().initialize();
		
		if(gameTimeline == null) {
			gameTimeline = new Timeline(new KeyFrame(Duration.millis(Constants.FPS), e-> draw()));
			gameTimeline.setCycleCount(Timeline.INDEFINITE);
		}
		
		sceneManager.getScene().getRoot().requestFocus();
	}
	
	public void start() {
		ViewManager viewManager = ViewManager.getInstance();
		viewManager.clear();
		
		TileManager tileManager = TileManager.getInstance();
		tileManager.spawnTile();
		
		EntityManager entityManager = EntityManager.getInstance();
		entityManager.spawnPlayer();
		entityManager.spawnEnemy();
		
		viewManager.addViews(entityManager.getViews());
		viewManager.addView(entityManager.getScoreView());
		viewManager.addView(tileManager.getGroundTileView());
		viewManager.addView(new HelpLineView(entityManager.getPlayer()));
		
		play();
	}
	
	public void nextEnemy() {
		EntityManager entityManager = EntityManager.getInstance();
		ViewManager viewManager = ViewManager.getInstance();
		viewManager.removeView(entityManager.getEnemyView());
		entityManager.spawnEnemy();
		viewManager.addView(entityManager.getEnemyView());
	}

	
	public void play() {
		gameTimeline.play();
		GameStateManager.getInstance().setCurrentGameState(GameState.RUNNING);
	}
	
	
	public void pause() {
		gameTimeline.pause();
		GameStateManager.getInstance().setCurrentGameState(GameState.PAUSING);
	}
	
	public void stop() {	
		gameTimeline.stop();
		GameStateManager.getInstance().setCurrentGameState(GameState.STOPPING);
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
		
		GameStateManager.getInstance().setCurrentGameState(GameState.STARTING);
		if(GameStateManager.getInstance().getCurrentGameState() == GameState.STARTING) {
			new NewStateTextView().show();
			play();
			pause();
		}
	}
}