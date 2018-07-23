package controller.manager;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.util.Duration;
import model.constants.Constants;
import model.entity.Entity;
import model.view.View;

public class GameManager {

	private Timeline gameTimeline;
	private Canvas gameCanvas;
	
	private static final GameManager gameManager = new GameManager();
	private GameManager() {}
	public static GameManager getInstance() {
		return gameManager;
	}
	
	public void initialize() {
		gameCanvas = SceneManager.getInstance().getCanvas();
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
		
		
		if(gameTimeline == null) {
			gameTimeline = new Timeline(new KeyFrame(Duration.millis(Constants.FPS), e-> draw()));
			gameTimeline.setCycleCount(Timeline.INDEFINITE);
		}
	}
	
	public void nextEnemy() {
		EntityManager entityManager = EntityManager.getInstance();
		ViewManager viewManager = ViewManager.getInstance();
		viewManager.removeView(entityManager.getEnemyView());
		entityManager.spawnEnemy();
		viewManager.addView(entityManager.getEnemyView());
	}
	
	public void start() {
		SceneManager.getInstance().getScene().getRoot().requestFocus();
		
		gameTimeline.play();
	}
	
	public void stop() {
		gameTimeline.stop();
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
	}
}