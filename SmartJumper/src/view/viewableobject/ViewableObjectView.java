package view.viewableobject;

import controller.manager.SceneManager;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.view.View;
import model.view.Viewable;

public class ViewableObjectView extends View {

	private GraphicsContext gc;
	private Color color;
	
	public ViewableObjectView(Viewable viewableObject, Color color) {
		super(viewableObject);
		gc = SceneManager.getInstance().getCanvas().getGraphicsContext2D();
		this.color = color;
	}
	
	@Override
	public void show() {
		gc.setFill(color);
		gc.fillRect(
			getViewableObject().getPos().getX()-(getViewableObject().getBound().getWidth()/2),
			getViewableObject().getPos().getY()-(getViewableObject().getBound().getHeight()/2),
			getViewableObject().getBound().getWidth(),
			getViewableObject().getBound().getHeight()
		);
	}
}