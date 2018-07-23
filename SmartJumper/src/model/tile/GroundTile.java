package model.tile;

public class GroundTile extends Tile {
	public GroundTile(double posX, double posY, double boundX, double boundY) {
		super(posX, posY, boundX, boundY);
		setCollisionActive(true);
	}
}