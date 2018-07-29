package controller.manager;

import model.collision.Collidable;

public class CollisionBoundManager {

	private static final CollisionBoundManager collisionBoundManager = new CollisionBoundManager();
	private CollisionBoundManager() {}
	public static CollisionBoundManager getIntance() {
		return collisionBoundManager;
	}
	
	public double calcTopBound(Collidable collidableObject) {
		return collidableObject.getPos().getY()-(collidableObject.getBound().getHeight()/2);
	}
	public double calcBottomBound(Collidable collidableObject) {
		return collidableObject.getPos().getY()+(collidableObject.getBound().getHeight()/2);
	}
	public double calcLeftBound(Collidable collidableObject) {
		return collidableObject.getPos().getX()-(collidableObject.getBound().getWidth()/2);
	}
	public double calcRightBound(Collidable collidableObject) {
		return collidableObject.getPos().getX()+(collidableObject.getBound().getWidth()/2);
	}
}