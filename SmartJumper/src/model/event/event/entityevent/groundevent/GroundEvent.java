package model.event.event.entityevent.groundevent;

import model.collision.Collidable;
import model.entity.Entity;
import model.event.event.entityevent.EntityEvent;

public class GroundEvent extends EntityEvent {

	private Collidable collidableObject;
	
	public GroundEvent(Entity entity, Collidable collidableObject) {
		super(entity);
		this.collidableObject = collidableObject;
	}
	
	
	public Collidable getCollidableObject() {
		return collidableObject;
	}
}