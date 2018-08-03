package controller.event.listener.entitylistener;

import java.util.ArrayList;
import java.util.List;

import com.google.common.eventbus.Subscribe;

import controller.event.bus.SmartJumperEventBus;
import controller.manager.CollisionManager;
import controller.manager.EntityManager;
import controller.manager.GameManager;
import controller.manager.TileManager;
import controller.manager.ViewManager;
import model.collision.Collidable;
import model.entity.Entity;
import model.event.entityevent.collisionevent.CollisionEvent;
import model.event.entityevent.groundevent.GroundEvent;
import model.event.entityevent.movementevent.MovementEvent;
import model.event.playerevent.scoreevent.ScoreEvent;
import model.tile.GroundTile;

public class EntityListener {
	
	public static final double DISTANCE_BETWEEN_GROUND_AND_ENTITY = 0;
	
	@Subscribe
	private void onMove(MovementEvent e) {
		List<Collidable> collidableObjects = new ArrayList<>();
		collidableObjects.addAll(EntityManager.getInstance().getEntities());
		collidableObjects.add(TileManager.getInstance().getGroundTile());
		for(Collidable collidableObject : collidableObjects) {
			CollisionManager collisionManager = CollisionManager.getInstance();
			if(collisionManager.checkCollision(e.getEntity(), collidableObject)) {
				SmartJumperEventBus.getInstance().post(new CollisionEvent(e.getEntity(), collidableObject));
			}
			if(collisionManager.checkOutOfBounds(e.getEntity())) {
				SmartJumperEventBus.getInstance().post(new ScoreEvent(EntityManager.getInstance().getPlayer()));
				break;
			}
		}
	}
	
	@Subscribe
	private void onGround(GroundEvent e) {
		if(!(e.getCollidableObject() instanceof GroundTile)) {
			return;
		}
		if(e.getCollidableObject().getCollisionBound().getTopBound() - e.getEntity().getCollisionBound().getBottomBound() <= DISTANCE_BETWEEN_GROUND_AND_ENTITY) {
			e.getEntity().setGravityActive(false);
			e.getEntity().setOnGround(true);
			e.getEntity().setPos(
				e.getEntity().getPos().getX(),
				e.getCollidableObject().getCollisionBound().getTopBound()-(e.getEntity().getBound().getHeight()/2)
			);
		}
	}
	
	 @Subscribe
	 public void onCollision(CollisionEvent e) {
		 if(e.getCollidableObject() instanceof Entity) {
			 ViewManager.getInstance().removeViews(EntityManager.getInstance().getEntityViews());
			 GameManager.getInstance().stop();
			 return;
		 }
		 
		if(!e.getEntity().isOnGround()) {
			SmartJumperEventBus.getInstance().post(new GroundEvent(e.getEntity(), e.getCollidableObject()));
		}
	 }
}