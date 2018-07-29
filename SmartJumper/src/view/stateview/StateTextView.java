package view.stateview;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import model.constants.Font;
import model.view.View;

public class StateTextView extends View {
	
	public static final TextAlignment TEXTALIGNMENT = TextAlignment.CENTER; 
	public static final VPos VPOS = VPos.CENTER;
	public static final Color COLOR = Color.DARKORANGE;
	public static final javafx.scene.text.Font FONT = Font.MEDIUM;
	
	
	private String stateStr;
	
	public StateTextView(String stateStr) {
		this.stateStr = stateStr;
	}
	
	@Override
	public void show() {
		getGC().setTextAlign(TEXTALIGNMENT);
		getGC().setTextBaseline(VPOS);
		getGC().setFill(COLOR);
		getGC().setFont(FONT);
		getGC().fillText(
			stateStr,
			getGC().getCanvas().getWidth()/2d,
			getGC().getCanvas().getHeight()/2d
		);
	}
}