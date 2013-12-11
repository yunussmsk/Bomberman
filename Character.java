import java.awt.Image;

import javax.swing.ImageIcon;

public class Character {
	private static int x = 0;
	private static int y = 0;
	private static int speed = 7;
	private static boolean dead = false;
	private static Image character = (new ImageIcon(
			"images/characterSteady.png")).getImage();
	private static Image characterUp = (new ImageIcon("images/characterUp.gif"))
			.getImage();
	private static Image characterDown = (new ImageIcon(
			"images/characterDown.gif")).getImage();
	private static Image characterRight = (new ImageIcon(
			"images/characterRight.gif")).getImage();
	private static Image characterLeft = (new ImageIcon(
			"images/characterLeft.gif")).getImage();
	private static Image characterSteady = (new ImageIcon(
			"images/characterSteady.png")).getImage();
	private static Image characterDead = (new ImageIcon(
			"images/characterDead(1.8).gif")).getImage();

	public static boolean isDead() {
		return dead;
	}

	public static void setDead(boolean dead) {
		Character.dead = dead;
	}

	public static boolean meetDoor() {
		boolean state = false;
		boolean west, east, north, south;
		west = x - 700 < 30;
		east = 700 - x < 15;
		north = 500 - y < 15;
		south = y - 500 < 30;
		state = state || (west && south && north && east);
		return state;
	}

	public static boolean meetBang() {
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

	public static boolean meetAlien(Alien[] alien) {
		boolean state = false;
		for (int i = 0; i < alien.length; i++) {

			if (alien[i].isDead())
				state = state || false;

			boolean west, east, north, south;
			west = x - alien[i].getX() < 35;
			east = alien[i].getX() - x < 35;
			north = alien[i].getY() - y < 35;
			south = y - alien[i].getY() < 35;
			state = state || (west && south && north && east);
		}
		return state;
	}

	public static boolean outOfPanel() {
		return x < 0 || y < 0 || x > 715 || y > 510;
	}

	public static boolean meetWall() {
		boolean state = false;
		boolean west, east, north, south;
		for (int i = 0; i < 7; i++)
			for (int j = 0; j < 5; j++) {
				west = x - 50 * (2 * i + 1) < 50;
				east = 50 * (2 * i + 1) - x < 35;
				north = 50 * (2 * j + 1) - y < 35;
				south = y - 50 * (2 * j + 1) < 50;
				state = state || (west && south && north && east);
			}
		return state;
	}

	public static boolean meetBomb() {
		boolean state = false;
		boolean west, east, north, south;
		west = x - Bomb.getX() < 35;
		east = Bomb.getX() - x < 35;
		north = Bomb.getY() - y < 35;
		south = y - Bomb.getY() < 35;
		state = state || (west && south && north && east);
		return state;
	}

	public static void moveUp() {
		y -= speed;
	}

	public static void moveDown() {
		y += speed;
	}

	public static void moveRight() {
		x += speed;
	}

	public static void moveLeft() {
		x -= speed;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Character.speed = speed;
	}

	public static Image getCharacter() {
		return character;
	}

	public static void setCharacter(int ch) {
		switch (ch) {
		case 1:
			character = characterUp;
			break;
		case 2:
			character = characterDown;
			break;
		case 3:
			character = characterRight;
			break;
		case 4:
			character = characterLeft;
			break;
		case 5:
			character = characterSteady;
			break;
		case 6:
			character = characterDead;
			break;
		}
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Character.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Character.y = y;
	}

}
