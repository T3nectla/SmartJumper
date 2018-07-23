package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.entity.Player;

public class PlayerTest {

	@Test
	public void spawnTest() {
		Player player = new Player(27.5d, 63.2d, 44.3d, 89.47d);
		Assertions.assertEquals(27.5d, player.getPos().getX(), "x position failed!");
		Assertions.assertEquals(63.2d, player.getPos().getY(), "y position failed!");
		Assertions.assertEquals(0d, player.getVel().getX(), "x velocity failed!");
		Assertions.assertEquals(-1d, player.getVel().getY(), "y velocity failed!");
		Assertions.assertEquals(44.3d, player.getBound().getWidth(), "width boundary failed!");
		Assertions.assertEquals(89.47d, player.getBound().getHeight(), "height boundary failed!");
	}
	
	@Test
	public void jumpTest() {
		Player player = new Player(30, 60, 50, 50);
		Assertions.assertEquals(30d, player.getPos().getX(), "x position failed!");
		Assertions.assertEquals(60d, player.getPos().getY(), "y position failed!");
		player.jump();
		Assertions.assertEquals(30d, player.getPos().getX(), "x position failed!");
		Assertions.assertNotEquals(60d, player.getPos().getY(), "y position failed!");
		Assertions.assertTrue(player.getPos().getY() < 60, "y position is falling below the ground!");
	}
}
