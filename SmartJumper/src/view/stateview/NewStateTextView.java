package view.stateview;

import javafx.scene.paint.Color;
import model.view.View;

public class NewStateTextView extends View {

	@Override
	public void show() {
		getGC().setFill(Color.BLACK);
		getGC().fillText(
			"Press P to start the game",
			getGC().getCanvas().getWidth()/2-50,
			getGC().getCanvas().getHeight()/2-50,
			100
		);
	}
}