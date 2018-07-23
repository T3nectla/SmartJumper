package model.event.entityevent;

import model.entity.Entity;

public abstract class EntityEvent {

	private Entity entity;
	
	public EntityEvent(Entity entity) {
		this.entity = entity;
	}
	
	
	public Entity getEntity() {
		return entity;
	}
}