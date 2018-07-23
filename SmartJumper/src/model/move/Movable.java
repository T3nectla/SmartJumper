package model.move;

import javafx.geometry.Point2D;
import model.collision.Collidable;

public interface Movable extends Collidable {
	abstract void setPos(Point2D pos);
	abstract void setPos(double posX, double posY);
	abstract void setOnGround(boolean onGround);
	abstract void setGravityActive(boolean gravityActive);
	abstract boolean isOnGround();
}