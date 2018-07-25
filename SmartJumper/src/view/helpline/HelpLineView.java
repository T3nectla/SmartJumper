package view.helpline;

import javafx.scene.paint.Color;
import model.constants.Constants;
import model.entity.player.Player;
import model.view.View;

public class HelpLineView extends View {
	
	private Player player; 
	
	public HelpLineView(Player player) {
		this.player = player;
	}
	
	@Override
	public void show() {
		getGC().setStroke(Color.GREEN);
		double posY = player.getGroundPos().getY() - Constants.MAX_JUMP_DISTANCE - player.getBound().getHeight()/2;
		getGC().strokeLine(
			0,
			posY,
			getGC().getCanvas().getWidth(),
			posY
		);
	}
}