import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.Box.Filler;
import javax.swing.border.BevelBorder;

/** WelcomeSign class is a JPanel used to display a welcome sign 
 * @author jmoney4769
 * @version 09/26/12
 */
public class WelcomeSign extends JPanel{

	private Location loc;
	private JFrame frame;
	
	
	/** Constructor for the class 
	 * @param loc
	 */
	public WelcomeSign(Location loc) {
		setLoc(loc);
		frame = new JFrame("Welcome!");
		JLabel label1 = new JLabel("Welcome to");
		JLabel label2 = new JLabel(loc.toString());
		label1.setFont(new Font("Arial", Font.ITALIC, 30));
		label2.setFont(new Font("Times New Roman", Font.BOLD, 60));
		this.add(label1);
		this.add(label2);
		this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));	
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				repaint();
			}
		});
		timer.start();
	}
	
	/** Getter for loc 
	 * @return the instance variable loc
	 */
	public Location getLoc() {
		return loc;
	}

	/** Setter for loc
	 * @param loc
	 */
	public void setLoc(Location loc) {
		this.loc = loc;
	}

	/** Getter for frame
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/** Method used to show the sign
	 * Precondition:  There is a WelcomeSign object, but there is no window on the screen
	 * Postcondition:  The correctly formatted window appears on the screen
	 */
	public void showWelcomeSign() {
		frame.setMinimumSize(new Dimension(300, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Random random = new Random();
		g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
