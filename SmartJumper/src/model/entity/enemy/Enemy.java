package model.entity.enemy;

import model.entity.Entity;

public abstract class Enemy extends Entity {
	
	private long score;
	
	public Enemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
	}
	
	public long getScore() {
		return score;
	}
	
	protected void calcScore() {
		score = ((long) getVel().getX())*-1;
	}
}