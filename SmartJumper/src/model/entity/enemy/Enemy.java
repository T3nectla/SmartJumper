package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

import model.entity.Entity;

public abstract class Enemy extends Entity {
	
	private long score;
	private boolean scoreUsed;
	
	public Enemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		scoreUsed = false;
		calcVel();
	}
	
	
	public void setScoreUsed(boolean scoreUsed) {
		this.scoreUsed = scoreUsed;
	}
	
	public long getScore() {
		return score;
	}
	public boolean isScoreUsed() {
		return scoreUsed;
	}
	
	private void calcVel() {
		setVel(-ThreadLocalRandom.current().nextInt(5, 20), 0);
		calcScore();
	}
	
	private void calcScore() {
		score = (((long) getVel().getX())*-1)-1;
	}
}