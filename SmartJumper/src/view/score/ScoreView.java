package view.score;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import model.constants.Font;
import model.entity.player.Player;
import model.view.View;

public class ScoreView extends View {

	public static final int POS_X = 5;
	public static final int POS_X_PLUS = POS_X + 5;
	public static final int POS_Y = 25;
	public static final int WIDTH = 50;
	
	public static final TextAlignment TEXTALIGNMENT = TextAlignment.LEFT; 
	public static final VPos VPOS = VPos.CENTER;
	public static final Color COLOR = Color.BLUE;
	public static final javafx.scene.text.Font FONT = Font.SMALL;
	
	public static final Color COLOR_TEXT = Color.GREEN;
	public static final String TEXT = "Score:";
	
	private Player player;
	
	public ScoreView(Player player) {
		this.player = player;
	}

	@Override
	public void show() {
		getGC().setTextAlign(TEXTALIGNMENT);
		getGC().setTextBaseline(VPOS);
		getGC().setFill(COLOR_TEXT);
		getGC().setFont(FONT);
		getGC().fillText(
			TEXT,
			POS_X,
			POS_Y,
			WIDTH
		);
		getGC().setFill(COLOR);
		getGC().fillText(
			String.valueOf(player.getScore()),
			POS_X_PLUS + WIDTH,
			POS_Y
		);
	}
}