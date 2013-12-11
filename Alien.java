import java.awt.Image;

import javax.swing.ImageIcon;

public class Alien {
	private int x = 100 * (int) (1 + Math.random() * 7) + 8;
	private int y = 100 * (int) (1 + Math.random() * 5) + 8;
	private Image alienRight = (new ImageIcon("images/alienRight.gif"))
			.getImage();
	private Image alienLeft = (new ImageIcon("images/alienLeft.gif"))
			.getImage();
	private Image alienDead = (new ImageIcon("images/alienDead(1.5).gif"))
			.getImage();
	private Image alien = alienRight;
	private int direction = (int) (1 + Math.random() * 2);
	private int speed = 4;
	private boolean dead = false;

	public void move(boolean type) {
		if (dead)
			return;
		if (meetBomb() && Bomb.isBombSet()) {
			if (type)
				switch (direction) {
				case 1:
					x += speed;
					setAlien(alienRight);
					break;
				case 2:
					x -= speed;
					setAlien(alienLeft);
					break;
				}
			else
				switch (direction) {
				case 1:
					y += speed;
					setAlien(alienRight);
					break;
				case 2:
					y -= speed;
					setAlien(alienLeft);
					break;
				}
		} else {
			if (type)
				switch (direction) {
				case 1:
					x += speed;
					setAlien(alienRight);
					if (outOfPanel() || meetBomb() && Bomb.isBombSet())
						direction = 2;
					break;
				case 2:
					x -= speed;
					setAlien(alienLeft);
					if (outOfPanel() || meetBomb() && Bomb.isBombSet())
						direction = 1;
					break;
				}
			else
				switch (direction) {
				case 1:
					y += speed;
					setAlien(alienRight);
					if (outOfPanel() || meetBomb() && Bomb.isBombSet())
						direction = 2;
					break;
				case 2:
					y -= speed;
					setAlien(alienLeft);
					if (outOfPanel() || meetBomb() && Bomb.isBombSet())
						direction = 1;
					break;
				}
		}
	}

	public static boolean allAliensDead(Alien[] alien) {
		boolean state = true;
		for (int i = 0; i < alien.length; i++)
			state = state && alien[i].isDead();
		return state;
	}

	public boolean meetBang() {
		boolean state = false;
		boolean west, east, north, south;

		if (Bomb.getBang1X() > 0 && Bomb.getBang1Y() > 0) {
			west = x - Bomb.getBang1X() < 35;
			east = Bomb.getBang1X() - x < 35;
			north = Bomb.getBang1Y() - y < 35;
			south = y - Bomb.getBang1Y() < 35;
			state = state || (west && south && north && east);
		}
		if (Bomb.getBang2X() >= 0 && Bomb.getBang2Y() >= 0) {
			west = x - Bomb.getBang2X() < 35;
			east = Bomb.getBang2X() - x < 35;
			north = Bomb.getBang2Y() - y < 35;
			south = y - Bomb.getBang2Y() < 35;
			state = state || (west && south && north && east);
		}
		if (Bomb.getBang3X() >= 0 && Bomb.getBang3Y() >= 0) {
			west = x - Bomb.getBang3X() < 35;
			east = Bomb.getBang3X() - x < 35;
			north = Bomb.getBang3Y() - y < 35;
			south = y - Bomb.getBang3Y() < 35;
			state = state || (west && south && north && east);
		}
		if (Bomb.getBang4X() > 0 && Bomb.getBang4Y() > 0) {
			west = x - Bomb.getBang4X() < 35;
			east = Bomb.getBang4X() - x < 35;
			north = Bomb.getBang4Y() - y < 35;
			south = y - Bomb.getBang4Y() < 35;
			state = state || (west && south && north && east);
		}
		if (Bomb.getBang5X() > 0 && Bomb.getBang5Y() > 0) {
			west = x - Bomb.getBang5X() < 35;
			east = Bomb.getBang5X() - x < 35;
			north = Bomb.getBang5Y() - y < 35;
			south = y - Bomb.getBang5Y() < 35;
			state = state || (west && south && north && east);
		}
		return state;
	}

	public boolean meetBomb() {
		boolean state = false;
		boolean west, east, north, south;
		west = x - Bomb.getX() < 35;
		east = Bomb.getX() - x < 35;
		north = Bomb.getY() - y < 35;
		south = y - Bomb.getY() < 35;
		state = state || (west && south && north && east);

		return state;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public boolean outOfPanel() {
		return x < 0 || y < 0 || x > 715 || y > 510;
	}

	public Image getAlienRight() {
		return alienRight;
	}

	public void setAlienRight(Image alienRight) {
		this.alienRight = alienRight;
	}

	public Image getAlienLeft() {
		return alienLeft;
	}

	public void setAlienLeft(Image alienLeft) {
		this.alienLeft = alienLeft;
	}

	public Image getAlienDead() {
		return alienDead;
	}

	public void setAlienDead(Image alienDead) {
		this.alienDead = alienDead;
	}

	public Image getAlien() {
		return alien;
	}

	public void setAlien(Image alien) {
		this.alien = alien;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
