package model.event.event.playerevent;

import model.entity.player.Player;

public abstract class PlayerEvent {

	private Player player;
	
	public PlayerEvent(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}
}