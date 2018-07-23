package model.collision;

public class CollisionBound {
	
	private Collidable collidableObject;
	
	public CollisionBound(Collidable collidableObject) {
		this.collidableObject = collidableObject;
	}
	
	public double getTopBound() {
		return (collidableObject.getPos().getY()-(collidableObject.getBound().getHeight()/2))+.1d;
	}
	public double getBottomBound() {
		return (collidableObject.getPos().getY()+(collidableObject.getBound().getHeight()/2))-.1d;
	}
	public double getLeftBound() {
		return (collidableObject.getPos().getX()-(collidableObject.getBound().getWidth()/2))+.1d;
	}
	public double getRightBound() {
		return (collidableObject.getPos().getX()+(collidableObject.getBound().getWidth()/2))-.1d;
	}
}