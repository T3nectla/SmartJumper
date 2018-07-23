package model.event.event.entityevent;

import model.collision.Collidable;
import model.entity.Entity;

public class CollisionEvent extends EntityEvent {
	
	private Collidable collidableObject;
	
	public CollisionEvent(Entity entity, Collidable collidableObject) {
		super(entity);
		this.collidableObject = collidableObject;
	}
	
	public Collidable getCollidableObject() {
		return collidableObject;
	}
}