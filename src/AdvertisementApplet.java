import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JApplet;

/**
 * Applet used to show an advertisement 
 * @author Jared Moore
 *
 */
public class AdvertisementApplet extends JApplet {

	/** Precondition:  The applet hasn't started yet or needs to be refreshed
	 * 	Postcondition:  The applet is up and running 
	 */
	@Override
	public void paint(Graphics g) {
		setSize(500, 500); // set the size so it is always the same 
		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 250, 250);
		
		g.setColor(new Color(200, 0, 0));
		g.fillOval(0, 250, 250, 250);
		
		g.setColor(Color.GREEN);
		g.fillRoundRect(250, 0, 250, 250, 100, 100);
		
		g.setColor(Color.BLACK);
		g.drawString("Coca Cola:  Open Happiness", 250, 300);
		
	}
}
