import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bomb {
	private static int x = -300;
	private static int y = -300;
	private static boolean bang = false;
	private static Image bomb = (new ImageIcon("images/bomb(1).gif"))
			.getImage();
	private static Image bang1 = (new ImageIcon("images/bang1.gif")).getImage();
	private static Image bang2 = (new ImageIcon("images/bang2.gif")).getImage();
	private static Image bang3 = (new ImageIcon("images/bang3.gif")).getImage();
	private static Image bang4 = (new ImageIcon("images/bang4.gif")).getImage();
	private static Image bang5 = (new ImageIcon("images/bang5.gif")).getImage();
	private static boolean bombSet = false;
	private static int bang1X, bang2X, bang3X, bang4X, bang5X, bang1Y, bang2Y,
			bang3Y, bang4Y, bang5Y;

	public static boolean isBang() {
		return bang;
	}

	public static void setBang(boolean bang) {
		Bomb.bang = bang;
	}

	public static boolean isBombSet() {
		return bombSet;
	}

	public static void setBombSet(boolean bombSet) {
		Bomb.bombSet = bombSet;
	}

	public static void on() {
		bombSet = true;
	}

	public static void off() {
		bombSet = false;
	}

	public static int getX() {
		return x;
	}

	public static void BangEvent(Graphics g) {
		g.drawImage(bang1, bang1X, bang1Y, 35, 35, null);
		g.drawImage(bang2, bang2X, bang2Y, 58, 35, null);
		g.drawImage(bang3, bang3X, bang3Y, 35, 58, null);
		g.drawImage(bang4, bang4X, bang4Y, 58, 35, null);
		g.drawImage(bang5, bang5X, bang5Y, 35, 58, null);
	}

	public static void setX(int x) {

		if (x % 50 > 34)
			x += 25;
		while (x % 50 < 8)
			x++;
		while (x % 50 > 8)
			x--;
		Bomb.x = x;

		bang1X = Bomb.x;
		bang2X = Bomb.x - 58;
		bang3X = Bomb.x;
		bang4X = Bomb.x + 35;
		bang5X = Bomb.x;

	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {

		if (y % 50 > 34)
			y += 25;
		while (y % 50 < 8)
			y++;
		while (y % 50 > 8)
			y--;
		Bomb.y = y;

		bang1Y = Bomb.y;
		bang2Y = Bomb.y;
		bang3Y = Bomb.y - 58;
		bang4Y = Bomb.y;
		bang5Y = Bomb.y + 35;
	}

	public static Image getBomb() {
		return bomb;
	}

	public static void setBomb(Image bomb) {
		Bomb.bomb = bomb;
	}

	public static Image getBang1() {
		return bang1;
	}

	public static void setBang1(Image bang1) {
		Bomb.bang1 = bang1;
	}

	public static Image getBang2() {
		return bang2;
	}

	public static void setBang2(Image bang2) {
		Bomb.bang2 = bang2;
	}

	public static Image getBang3() {
		return bang3;
	}

	public static void setBang3(Image bang3) {
		Bomb.bang3 = bang3;
	}

	public static Image getBang4() {
		return bang4;
	}

	public static void setBang4(Image bang4) {
		Bomb.bang4 = bang4;
	}

	public static Image getBang5() {
		return bang5;
	}

	public static void setBang5(Image bang5) {
		Bomb.bang5 = bang5;
	}

	public static int getBang1X() {
		return bang1X;
	}

	public static int getBang2X() {
		return bang2X;
	}

	public static int getBang3X() {
		return bang3X;
	}

	public static int getBang4X() {
		return bang4X;
	}

	public static int getBang5X() {
		return bang5X;
	}

	public static int getBang1Y() {
		return bang1Y;
	}

	public static int getBang2Y() {
		return bang2Y;
	}

	public static int getBang3Y() {
		return bang3Y;
	}

	public static int getBang4Y() {
		return bang4Y;
	}

	public static int getBang5Y() {
		return bang5Y;
	}

}
