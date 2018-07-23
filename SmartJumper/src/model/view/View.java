package model.view;

import controller.manager.SceneManager;
import javafx.scene.canvas.GraphicsContext;

public abstract class View {

	private GraphicsContext gc;
	
	public View() {
		gc = SceneManager.getInstance().getCanvas().getGraphicsContext2D();
	}
	
	public abstract void show();
	
	public GraphicsContext getGC() {
		return gc;
	}
}