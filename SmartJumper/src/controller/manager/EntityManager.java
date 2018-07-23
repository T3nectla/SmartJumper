package controller.manager;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import model.entity.enemy.GroundEnemy;
import model.view.View;
import view.viewableobject.ViewableObjectView;

public class EntityManager {

	private Player player;
	private Enemy enemy;
	
	private View playerView;
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
		
		player = new Player(
			50,
			TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-25,
			50,
			50
		);
		playerView = new ViewableObjectView(player,  Color.BLACK);
		
		entities.add(player);
		views.add(playerView);
	}
	
	public void spawnEnemy() {
		entities.remove(enemy);
		views.remove(enemyView);
		
		enemy = new GroundEnemy(
			SceneManager.getInstance().getCanvas().getWidth(),
			TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-25,
			50,
			50
		);
//		enemy = new FlyEnemy(
//			SceneManager.getInstance().getCanvas().getWidth(),
//			TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound()-100,
//			50,
//			50
//		);
		enemyView = new ViewableObjectView(enemy, Color.RED);
		
		entities.add(enemy);
		views.add(enemyView);
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