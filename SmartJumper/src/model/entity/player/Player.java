package model.entity.player;

import javafx.geometry.Point2D;
import model.constants.Constants;
import model.entity.Entity;

public class Player extends Entity {
	
	public static final double MAX_JUMP_DISTANCE = 200;
	private long score;
	private Point2D onGroundPos;
	
	public Player(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		onGroundPos = new Point2D(posX, posY);
		score = 0;
		setVel(0, Constants.JUMP);
	}
	
	@Override
	public void update() {
		if(isJumpPressed()) {
			setPos(getPos().add(getVel()));
			
			if(onGroundPos.distance(getPos()) >= MAX_JUMP_DISTANCE) {
				cancelJump();
			}	
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