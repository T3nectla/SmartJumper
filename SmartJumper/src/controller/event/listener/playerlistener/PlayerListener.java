package controller.event.listener.playerlistener;

import com.google.common.eventbus.Subscribe;

import controller.manager.EntityManager;
import model.entity.enemy.Enemy;
import model.event.event.playerevent.scoreevent.ScoreEvent;

public class PlayerListener {
	
	@Subscribe
	public void onAddScore(ScoreEvent e) {
		Enemy enemy = EntityManager.getInstance().getEnemy();
		if(!enemy.isScoreUsed()) {
			enemy.setScoreUsed(true);
			e.getPlayer().setScore(e.getPlayer().getScore() + enemy.getScore());
		}
	}
}