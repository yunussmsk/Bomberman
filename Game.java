import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements ActionListener {

	private Image wall = (new ImageIcon("images/wall.png")).getImage();

	private Image door = (new ImageIcon("images/door.png")).getImage();

	private Alien[] alien = new Alien[2];

	private Timer time;

	private long periodBomb = 0, periodBang = 0, periodAlienDead = 0, periodDead = 0;

	public Game() {
		System.out.println((int)(Math.ceil((1 + Math.random() * 1))));
		for (int i = 0; i < alien.length; i++)
			alien[i] = new Alien();
		addKeyListener(new XListener());
		add(new GamePanel());
		time = new Timer(25, this);
	}

	public static void main(String args[]) {
		Game game = new Game();
		game.setTitle("Bomberman");
		game.setSize(755, 580);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setVisible(true);
		game.time.start();
	}

	class GamePanel extends JPanel {

		public GamePanel() {
			setBackground(new Color(31, 139, 0));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setFont(new Font("Calibri", Font.BOLD + Font.ITALIC, 40));
			if (Character.meetDoor() && Alien.allAliensDead(alien)) {
				time.stop();
				g.setColor(Color.BLUE);
				g.drawString("Well Done!!", getWidth() / 2 - 100,
						getHeight() / 2 - 20);
				return;
			}
			if (Character.isDead()) {
				if (System.currentTimeMillis() - periodDead > 1000) {
					time.stop();
					g.setColor(Color.red);
					g.drawString("Game Over!!", getWidth() / 2 - 100,
							getHeight() / 2 - 20);
					return;
				}
				Character.setCharacter(6);
			}
			g.drawImage(door, 700, 500, 50, 50, null);
			if (Bomb.isBang()
					&& (System.currentTimeMillis() - periodBang < 1000))
				Bomb.BangEvent(g);

			else if (Bomb.isBombSet()) {
				g.drawImage(Bomb.getBomb(), Bomb.getX(), Bomb.getY(), 35, 35,
						null);
				if (System.currentTimeMillis() - periodBomb > 3000) {
					periodBang = System.currentTimeMillis();
					Bomb.setBang(true);
					Bomb.off();
				}
			}

			else
				Bomb.setBang(false);

			g.drawImage(Character.getCharacter(), Character.getX(),
					Character.getY(), 35, 35, null);
			for (int i = 0; i < alien.length; i++) {
				if ((alien[i].isDead() && System.currentTimeMillis() - periodAlienDead > 1200)) {
					alien[i].setX(1000);
					alien[i].setY(1000);
				}
				g.drawImage(alien[i].getAlien(), alien[i].getX(),
						alien[i].getY(), 35, 35, null);
			}
			for (int i = 0; i < 7; i++)
				for (int j = 0; j < 5; j++)
					g.drawImage(wall, 50 * (2 * i + 1), 50 * (2 * j + 1), 50,
							50, null);
		}
	}

	class XListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			if (Character.isDead()
					|| (Character.meetDoor() && Alien.allAliensDead(alien)))
				return;
			if (Character.meetBomb() && Bomb.isBombSet()) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					Character.moveUp();
					Character.setCharacter(1);
					if (Character.meetWall() || Character.outOfPanel())
						Character.moveDown();
					break;
				case KeyEvent.VK_DOWN:
					Character.setCharacter(2);
					Character.moveDown();
					if (Character.meetWall() || Character.outOfPanel())
						Character.moveUp();
					break;
				case KeyEvent.VK_RIGHT:
					Character.setCharacter(3);
					Character.moveRight();
					if (Character.meetWall() || Character.outOfPanel())
						Character.moveLeft();
					break;
				case KeyEvent.VK_LEFT:
					Character.setCharacter(4);
					Character.moveLeft();
					if (Character.meetWall() || Character.outOfPanel())
						Character.moveRight();
					break;
				}
			} else
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					Character.moveUp();
					Character.setCharacter(1);
					if (Character.meetWall() || Character.outOfPanel()
							|| Character.meetBomb() && Bomb.isBombSet())
						Character.moveDown();
					break;
				case KeyEvent.VK_DOWN:
					Character.setCharacter(2);
					Character.moveDown();
					if (Character.meetWall() || Character.outOfPanel()
							|| Character.meetBomb() && Bomb.isBombSet())
						Character.moveUp();
					break;
				case KeyEvent.VK_RIGHT:
					Character.setCharacter(3);
					Character.moveRight();
					if (Character.meetWall() || Character.outOfPanel()
							|| Character.meetBomb() && Bomb.isBombSet())
						Character.moveLeft();
					break;
				case KeyEvent.VK_LEFT:
					Character.setCharacter(4);
					Character.moveLeft();
					if (Character.meetWall() || Character.outOfPanel()
							|| Character.meetBomb() && Bomb.isBombSet())
						Character.moveRight();
					break;
				case KeyEvent.VK_SPACE:
					if (!Bomb.isBombSet() && !Bomb.isBang()) {
						Bomb.setX(Character.getX());
						Bomb.setY(Character.getY());
						Bomb.on();
						periodBomb = System.currentTimeMillis();
					}
					break;
				}
			repaint();
		}

		public void keyReleased(KeyEvent e) {
			Character.setCharacter(5);
			repaint();
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < alien.length; i++) {
			alien[i].move(i % 2 == 1);
			if (alien[i].meetBang() && Bomb.isBang()) {
				alien[i].setAlien(alien[i].getAlienDead());
				alien[i].setDead(true);
				periodAlienDead = System.currentTimeMillis();
			}
		}

		if (Character.meetAlien(alien)
				|| (Character.meetBang() && Bomb.isBang())) {
			Character.setDead(true);
			periodDead = System.currentTimeMillis();
		}
		repaint();
	}

}
