package view.score;

import javafx.scene.paint.Color;
import model.entity.player.Player;
import model.view.View;

public class ScoreView extends View {

	private Player player;
	
	public ScoreView(Player player) {
		this.player = player;
	}

	@Override
	public void show() {
		getGC().setFill(Color.GREEN);
		getGC().fillText(
			"Score: " + player.getScore(),
			5,
			25
		);
	}
}