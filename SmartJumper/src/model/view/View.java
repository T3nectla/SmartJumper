package model.view;

import controller.manager.SmartJumperManager;
import javafx.scene.canvas.GraphicsContext;

public abstract class View {

	private GraphicsContext gc;
	
	public View() {
		gc = SmartJumperManager.getInstance().getCanvas().getGraphicsContext2D();
	}
	
	public abstract void show();
	
	public GraphicsContext getGC() {
		return gc;
	}
}