package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

import model.entity.Entity;

public abstract class Enemy extends Entity {
	
	private long score;
	
	public Enemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		calcVel();
	}
	
	
	public long getScore() {
		return score;
	}
	
	private void calcVel() {
		setVel(ThreadLocalRandom.current().nextInt(-15, -2), 0);
		calcScore();
	}
	
	private void calcScore() {
		score = (((long) getVel().getX())*-1)-1;
		System.out.println("Velocity: " + getVel().getX());
		System.out.println("Score: " + score);
	}
}