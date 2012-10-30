import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class HW8Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		ImageIcon image = new ImageIcon("res/room1.jpg");
		frame.add(new Scene(image));
		//frame.add(new Door(true));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
