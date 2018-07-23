package model.collision;

import model.view.Viewable;

public interface Collidable extends Viewable{
	abstract CollisionBound getCollisionBound();
}