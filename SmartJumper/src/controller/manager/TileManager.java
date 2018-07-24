package controller.manager;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import model.tile.GroundTile;
import view.viewableobject.ViewableObjectView;

public class TileManager {
	
	private GroundTile groundTile;
	private ViewableObjectView groundTileView;
	
	private static final TileManager tileManager = new TileManager();
	private TileManager() {}
	public static TileManager getInstance() {
		return tileManager;
	}
	
	public void spawnTile() {
		Canvas gameCanvas = SceneManager.getInstance().getCanvas();
		
		groundTile = new GroundTile(gameCanvas.getWidth()/2, gameCanvas.getHeight()*.9, gameCanvas.getWidth(), 100);
		groundTileView = new ViewableObjectView(groundTile, Color.BROWN);
	}
	
	public GroundTile getGroundTile() {
		return groundTile;
	}
	public ViewableObjectView getGroundTileView() {
		return groundTileView;
	}
}