package model.event.entityevent.collisionevent;

import model.collision.Collidable;
import model.entity.Entity;
import model.event.entityevent.EntityEvent;

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