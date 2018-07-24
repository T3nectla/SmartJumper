package controller.event.listener.playerlistener;

import com.google.common.eventbus.Subscribe;

import controller.manager.EntityManager;
import controller.manager.GameManager;
import model.event.playerevent.scoreevent.ScoreEvent;

public class PlayerListener {
	
	@Subscribe
	public void onAddScore(ScoreEvent e) {
		e.getPlayer().setScore(e.getPlayer().getScore() + EntityManager.getInstance().getEnemy().getScore());
		GameManager.getInstance().nextEnemy();
	}
}