package controller.manager;

import javafx.scene.paint.Color;
import model.tile.GroundTile;
import view.viewableobject.ViewableObjectView;

public class TileManager {
	
	public static final double GROUNDTILE_POS_X = SmartJumperManager.getInstance().getCanvas().getWidth()/2;
	public static final double GROUNDTILE_POS_Y = SmartJumperManager.getInstance().getCanvas().getHeight()*.9;
	public static final double GROUNDTILE_WIDTH = SmartJumperManager.getInstance().getCanvas().getWidth();
	public static final double GROUNDTILE_HEIGHT = 100;
	
	
	private GroundTile groundTile;
	private ViewableObjectView groundTileView;
	
	private static final TileManager tileManager = new TileManager();
	private TileManager() {}
	public static TileManager getInstance() {
		return tileManager;
	}
	
	public void spawnGroundTile() {
		groundTile = new GroundTile(GROUNDTILE_POS_X, GROUNDTILE_POS_Y, GROUNDTILE_WIDTH, GROUNDTILE_HEIGHT);
		groundTileView = new ViewableObjectView(groundTile, Color.BROWN.darker());
	}
	
	public GroundTile getGroundTile() {
		return groundTile;
	}
	public ViewableObjectView getGroundTileView() {
		return groundTileView;
	}
}