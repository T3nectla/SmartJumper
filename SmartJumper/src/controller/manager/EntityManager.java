package controller.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.paint.Color;
import model.entity.Entity;
import model.entity.enemy.Enemy;
import model.entity.enemy.EnemyType;
import model.entity.enemy.FlyEnemy;
import model.entity.enemy.GroundEnemy;
import model.entity.player.Player;
import model.view.View;
import view.score.ScoreView;
import view.viewableobject.ViewableObjectView;

public class EntityManager {

	private Player player;
	private Enemy enemy;
	
	private View playerView;
	private View scoreView;
	private View enemyView;
	
	private List<Entity> entities = new ArrayList<>();
	private List<View> views = new ArrayList<>();
	
	private static final EntityManager entityManager = new EntityManager();
	private EntityManager() {}
	public static EntityManager getInstance() {
		return entityManager;
	}
	
	public void spawnPlayer() {
		entities.remove(player);
		views.remove(playerView);
		views.remove(scoreView);
		
		player = new Player(
			50,
			TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-25,
			50,
			50
		);
		playerView = new ViewableObjectView(player,  Color.BLACK);
		scoreView = new ScoreView(player);
		
		entities.add(player);
		views.add(playerView);
		views.add(scoreView);
	}
	
	public void spawnEnemy() {
		entities.remove(enemy);
		views.remove(enemyView);
		
		chooseRndEnemy();
		enemyView = new ViewableObjectView(enemy, Color.RED);
		
		entities.add(enemy);
		views.add(enemyView);
	}
	
	private void chooseRndEnemy() {
		EnemyType[] enemyTypes = EnemyType.values();
		int rnd = new Random().nextInt(enemyTypes.length);
		
		switch(enemyTypes[rnd]) {
			case GROUNDENEMY:
				spawnGroundEnemy();
				break;
			case FLYENEMY:
				spawnFlyEnemy();
				break;
			default:
				break;
		}
	}
	
	private void spawnGroundEnemy() {
		enemy = new GroundEnemy(
				SceneManager.getInstance().getCanvas().getWidth(),
				TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-25,
				50,
				50
			);
	}
	
	private void spawnFlyEnemy() {
		int rndHeight = ThreadLocalRandom.current().nextInt(25, 200);
		enemy = new FlyEnemy(
			SceneManager.getInstance().getCanvas().getWidth(),
			TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound() - rndHeight,
			50,
			50
		);
	}
	
	public Player getPlayer() {
		return player;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	
	public View getPlayerView() {
		return playerView;
	}
	public View getScoreView() {
		return scoreView;
	}
	public View getEnemyView() {
		return enemyView;
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
	public List<View> getViews() {
		return views;
	}
}