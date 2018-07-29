package model.collision;

import controller.manager.CollisionBoundManager;

public class CollisionBound {
	
	private Collidable collidableObject;
	private CollisionBoundManager collisionBoundManager;
	
	public CollisionBound(Collidable collidableObject) {
		this.collidableObject = collidableObject;
		collisionBoundManager = CollisionBoundManager.getIntance();
	}
	
	public double getTopBound() {
		return collisionBoundManager.calcTopBound(this.collidableObject);
	}
	public double getBottomBound() {
		return collisionBoundManager.calcBottomBound(this.collidableObject);
	}
	public double getLeftBound() {
		return collisionBoundManager.calcLeftBound(this.collidableObject);
	}
	public double getRightBound() {
		return collisionBoundManager.calcRightBound(this.collidableObject);
	}
}