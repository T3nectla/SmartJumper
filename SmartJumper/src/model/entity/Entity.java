package model.entity;

import controller.event.bus.SmartJumperEventBus;
import javafx.geometry.Point2D;
import model.bounds.Bound;
import model.collision.CollisionBound;
import model.constants.Constants;
import model.event.event.entityevent.movementevent.MovementEvent;
import model.move.Movable;

public abstract class Entity implements Movable {

	private Point2D pos;
	private Point2D vel;
	private Point2D grav;
	private Bound bound;
	private CollisionBound collisionBound;
	private boolean onGround;
	private boolean gravityActive;
	private boolean jumpPressed;
	
	public Entity(double posX, double posY, double boundX, double boundY) {
		pos = new Point2D(posX, posY);
		vel = new Point2D(0, 0);
		grav = new Point2D(0, Constants.GRAVITY);
		bound = new Bound(boundX, boundY);
		collisionBound = new CollisionBound(this);
		onGround = false;
		gravityActive = true;
		jumpPressed = false;
	}
	
	public void grav() {
		if(isGravityActive() && !isOnGround()) {
			setPos(getPos().add(getGrav()));
			setJumpPressed(false);
		}
	}
	
	public abstract  void update();
	
	@Override
	public void setPos(Point2D pos) {
		this.pos = pos;
		SmartJumperEventBus.getInstance().post(new MovementEvent(this));
	}
	@Override
	public void setPos(double posX, double posY) {
		pos = new Point2D(posX, posY);
		SmartJumperEventBus.getInstance().post(new MovementEvent(this));
	}
	public void setVel(Point2D vel) {
		this.vel = vel;
	}
	public void setVel(double velX, double velY) {
		vel = new Point2D(velX, velY);
	}
	public void setGrav(Point2D grav) {
		this.grav = grav;
	}
	public void setGrav(double gravX, double gravY) {
		grav = new Point2D(gravX, gravY);
	}
	public void setBound(Bound bound) {
		this.bound = bound;
	}
	public void setBound(double boundX, double boundY) {
		bound = new Bound(boundX, boundY);
	}
	@Override
	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}
	@Override
	public void setGravityActive(boolean gravityActive) {
		this.gravityActive = gravityActive;
	}
	public void setJumpPressed(boolean jumpPressed) {
		this.jumpPressed = jumpPressed;
	}
	
	@Override
	public Point2D getPos() {
		return pos;
	}
	public Point2D getVel() {
		return vel;
	}
	public Point2D getGrav() {
		return grav;
	}
	@Override
	public Bound getBound() {
		return bound;
	}
	@Override
	public CollisionBound getCollisionBound() {
		return collisionBound;
	}
	@Override
	public boolean isOnGround() {
		return onGround;
	}
	public boolean isGravityActive() {
		return gravityActive;
	}
	public boolean isJumpPressed() {
		return jumpPressed;
	}
}