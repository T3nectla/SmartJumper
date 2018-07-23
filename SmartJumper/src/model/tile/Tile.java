package model.tile;

import javafx.geometry.Point2D;
import model.bounds.Bound;
import model.collision.Collidable;
import model.collision.CollisionBound;

public abstract class Tile implements Collidable {
	
	private Point2D pos;
	private Bound bound;
	private CollisionBound collisionBound;
	private boolean collisionActive;
	
	public Tile(double posX, double posY, double boundX, double boundY) {
		pos = new Point2D(posX, posY);
		bound = new Bound(boundX, boundY);
		collisionBound = new CollisionBound(this);
		collisionActive = false;
	}
	
	public void setPos(Point2D pos) {
		this.pos = pos;
	}
	public void setPos(double x, double y) {
		pos = new Point2D(x, y);
	}
	public void setBound(Bound bound) {
		this.bound = bound;
	}
	public void setBound(double boundX, double boundY) {
		bound = new Bound(boundX, boundY);
	}
	public void setCollisionActive(boolean collisionActive) {
		this.collisionActive = collisionActive;
	}
	
	@Override
	public Point2D getPos() {
		return pos;
	}
	@Override
	public Bound getBound() {
		return bound;
	}
	@Override
	public CollisionBound getCollisionBound() {
		return collisionBound;
	}
	public boolean isCollisionActive() {
		return collisionActive;
	}
}