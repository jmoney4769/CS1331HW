import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JApplet;


public class MoodRingApplet extends JApplet {

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		Random number = new Random();
		g.setColor(new Color(number.nextInt(256), number.nextInt(256), number.nextInt(256)));
		int diameter = 100 + number.nextInt(getWidth() / 2);
		g.fillArc(getWidth() / 2 - diameter / 2, getHeight() / 2 - diameter / 2, diameter, diameter, 0, 360);
		g.setColor(Color.BLACK);
		g.fillArc(getWidth() / 2 - diameter / 2 * 9 / 10, getHeight() / 2 - diameter / 2 * 9 / 10, diameter * 9 / 10, diameter * 9 / 10, 0, 360);
	}
}
 