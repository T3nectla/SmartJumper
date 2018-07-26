package view.stateview;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.view.View;

public class StateTextView extends View {

	private String stateStr;
	
	public StateTextView(String stateStr) {
		this.stateStr = stateStr;
	}
	
	@Override
	public void show() {
		getGC().setTextAlign(TextAlignment.CENTER);
		getGC().setTextBaseline(VPos.CENTER);
		getGC().setFill(Color.DARKORANGE);
		getGC().setFont(new Font(40));
		getGC().fillText(
			stateStr,
			getGC().getCanvas().getWidth()/2,
			getGC().getCanvas().getHeight()/2
		);
	}
}