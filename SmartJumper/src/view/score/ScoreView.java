package view.score;

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.entity.player.Player;
import model.view.View;

public class ScoreView extends View {

	private Player player;
	
	public ScoreView(Player player) {
		this.player = player;
	}

	@Override
	public void show() {
		getGC().setTextAlign(TextAlignment.LEFT);
		getGC().setTextBaseline(VPos.CENTER);
		getGC().setFill(Color.GREEN);
		getGC().setFont(new Font(20));
		getGC().fillText(
			"Score:",
			5,
			25,
			50
		);
		getGC().setFill(Color.BLUE);
		getGC().fillText(
			"" + player.getScore(),
			5+55,
			25
		);
	}
}