import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Door extends JPanel {

	ImageIcon image = new ImageIcon("res/door.jpg");
	
	public Door(boolean isFirst) {
		
		setLayout(new BorderLayout());
		if (isFirst) {
			add(new JLabel(image), BorderLayout.CENTER);
			add(new Inventory(), BorderLayout.NORTH);
		}
		else 
			add(new JLabel(image), BorderLayout.CENTER);
		setOpaque(false);
	}
}
