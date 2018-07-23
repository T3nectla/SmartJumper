package model.entity.player;

import model.constants.Constants;
import model.entity.Entity;

public class Player extends Entity {
	
	private long score;
	
	public Player(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		score = 0;
		setVel(0, Constants.JUMP);
	}
	
	@Override
	public void update() {
		if(isJumpPressed()) {
			setPos(getPos().add(getVel()));
			return;
		}
		
		if(!isGravityActive() && !isOnGround()) {
			setGravityActive(true);
		}
	}
	
	public void jump() {
		if(!isJumpPressed() && isOnGround()) {
			setJumpPressed(true);
			setGravityActive(false);
			setOnGround(false);
		}
	}
	
	public void cancelJump() {
		setJumpPressed(false);
	}
	
	public void setScore(long score) {
		this.score = score;
	}
	
	public long getScore() {
		return score;
	}
}