package model.entity.enemy;

public class FlyEnemy extends Enemy {

	public FlyEnemy(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setGravityActive(false);
	}

	@Override
	public void update() {
		setPos(getPos().add(getVel()));
	}
}