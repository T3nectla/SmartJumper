package controller.manager;

import model.collision.Collidable;
import model.move.Movable;

public class CollisionManager {
	
	public static final double LEFT_MAP_BOUND = 0;
	
	private static final CollisionManager collisionManager = new CollisionManager();
	private CollisionManager() {}
	public static CollisionManager getInstance() {
		return collisionManager;
	}
	
	public boolean checkCollision(Collidable collidableObject1, Collidable collidableObject2) {
		if(collidableObject1 == collidableObject2) {
			return false;
		}
		
		return
			collidableObject1.getCollisionBound().getBottomBound() > collidableObject2.getCollisionBound().getTopBound() &&
			collidableObject1.getCollisionBound().getRightBound() > collidableObject2.getCollisionBound().getLeftBound() &&
			collidableObject1.getCollisionBound().getTopBound() < collidableObject2.getCollisionBound().getBottomBound() &&
			collidableObject1.getCollisionBound().getLeftBound() < collidableObject2.getCollisionBound().getRightBound();
	}
	
	public boolean checkOutOfBounds(Movable movableObject) {
		return movableObject.getCollisionBound().getRightBound() < LEFT_MAP_BOUND;
	}
}