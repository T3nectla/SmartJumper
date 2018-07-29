package view.viewableobject;

import javafx.scene.paint.Color;
import model.view.View;
import model.view.Viewable;

public class ViewableObjectView extends View {

	private Color color;
	private Viewable viewableObject;
	
	public ViewableObjectView(Viewable viewableObject, Color color) {
		this.viewableObject = viewableObject;
		this.color = color;
	}
	
	@Override
	public void show() {
		getGC().setFill(color);
		getGC().fillRect(
			viewableObject.getPos().getX()-(viewableObject.getBound().getWidth()/2d),
			viewableObject.getPos().getY()-(viewableObject.getBound().getHeight()/2d),
			viewableObject.getBound().getWidth(),
			viewableObject.getBound().getHeight()
		);
	}
}