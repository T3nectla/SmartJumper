package model.entity.enemy;

public class GroundEnemy extends Enemy {
	public GroundEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
	}
	
	@Override
	public void update() {
		if(isOnGround()) {
			setPos(getPos().add(getVel()));
		}
	}
}