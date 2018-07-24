package model.entity.enemy;

import java.util.concurrent.ThreadLocalRandom;

import model.constants.Constants;

public class GroundEnemy extends Enemy {
	
	public GroundEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setVel(-ThreadLocalRandom.current().nextInt(Constants.GROUNDENEMY_MIN_SPEED, Constants.GROUNDENEMY_MAX_SPEED), 0);
		calcScore();
	}
	
	@Override
	public void update() {
		if(isOnGround()) {
			setPos(getPos().add(getVel()));
		}
	}
}