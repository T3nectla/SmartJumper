package model.entity.player;

import controller.manager.TileManager;
import javafx.geometry.Point2D;
import model.constants.Constants;
import model.entity.Entity;

public class Player extends Entity {
	
	private long score;
	private Point2D groundPos;
	
	public Player(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		groundPos = new Point2D(0, TileManager.getInstance().getGroundTile().getCollisionBound().getTopBound());
		score = 0;
		setVel(0, Constants.JUMP);
	}
	
	@Override
	public void update() {
		if(isJumpPressed()) {
			setPos(getPos().add(getVel()));
			
			if(groundPos.distance(getPos()) >= Constants.MAX_JUMP_DISTANCE) {
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
	public Point2D getGroundPos() {
		return groundPos;
	}
}