package model.event.event.playerevent.scoreevent;

import model.entity.player.Player;
import model.event.event.playerevent.PlayerEvent;

public class ScoreEvent extends PlayerEvent {
	
	public ScoreEvent(Player player) {
		super(player);
	}
}