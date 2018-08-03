package controller.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.paint.Color;
import model.constants.EnemyType;
import model.entity.Entity;
import model.entity.enemy.Enemy;
import model.entity.enemy.FlyEnemy;
import model.entity.enemy.GroundEnemy;
import model.entity.player.Player;
import model.view.View;
import view.score.ScoreView;
import view.viewableobject.ViewableObjectView;

public class EntityManager {

	public static final double PLAYER_SIZE = 50d;
	public static final double PLAYER_POS_X = 50d;
	public static final double PLAYER_POS_Y = TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-PLAYER_SIZE/2;
	public static final Color PLAYER_COLOR = Color.BLACK;
	
	public static final double ENEMY_SIZE = 50d;
	public static final double ENEMY_POS_X = SmartJumperManager.getInstance().getCanvas().getWidth();
	public static final double ENEMY_POS_Y = TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-ENEMY_SIZE/2;
	public static final Color ENEMY_COLOR = Color.RED;
	
	
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
			PLAYER_POS_X,
			PLAYER_POS_Y,
			PLAYER_SIZE,
			PLAYER_SIZE
		);
		playerView = new ViewableObjectView(player,  PLAYER_COLOR);
		scoreView = new ScoreView(player);
		
		entities.add(player);
		views.add(playerView);
		views.add(scoreView);
	}
	
	public void spawnEnemy() {
		entities.remove(enemy);
		views.remove(enemyView);
		
		chooseRndEnemy();
		enemyView = new ViewableObjectView(enemy, ENEMY_COLOR);
		
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
			ENEMY_POS_X,
			ENEMY_POS_Y,
			ENEMY_SIZE,
			ENEMY_SIZE
		);
	}
	
	private void spawnFlyEnemy() {
		int rndHeight = new Random().nextInt((int) (Player.MAX_JUMP_DISTANCE - PLAYER_SIZE/2));
		enemy = new FlyEnemy(
			ENEMY_POS_X,
			ENEMY_POS_Y - rndHeight,
			ENEMY_SIZE,
			ENEMY_SIZE
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
	public List<View> getEntityViews() {
		List<View> entityViews = views;
		entityViews.remove(scoreView);
		return entityViews;
	}
	public List<View> getViews() {
		return views;
	}
}