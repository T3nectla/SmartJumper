package view.helpline;

import javafx.scene.paint.Color;
import model.entity.player.Player;
import model.view.View;

public class HelpLineView extends View {
	
	public static final int POS_X_START = 0;
	public static final Color COLOR = Color.GREEN;
	
	
	private Player player; 
	
	public HelpLineView(Player player) {
		this.player = player;
	}
	
	@Override
	public void show() {
		getGC().setStroke(COLOR);
		double posY = player.getGroundPos().getY() - Player.MAX_JUMP_DISTANCE - player.getBound().getHeight()/2;
		getGC().strokeLine(
			POS_X_START,
			posY,
			getGC().getCanvas().getWidth(),
			posY
		);
	}
}