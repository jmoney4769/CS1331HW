import java.awt.BorderLayout;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/** A panel that is the image of a door and can also have the user's inventory
 * @author jmoney4769
 * @version 11/2/12
 */
public class Door extends JLayeredPane implements Serializable {

	private ImageIcon image = new ImageIcon("res/door.jpg");
	private Inventory inventory = new Inventory();
	private boolean isFirst;
	
	/** Constructor for the door object.  Sets up the panel
	 * @param isFirst
	 */
	public Door(boolean isFirst) {
		
		this.isFirst = isFirst;
		
		setLayout(new BorderLayout());
		if (isFirst) {
			add(new JLabel(image), BorderLayout.SOUTH, DEFAULT_LAYER);
			add(inventory, BorderLayout.NORTH, POPUP_LAYER);
		}
		else 
			add(new JLabel(image), BorderLayout.SOUTH, DEFAULT_LAYER);
		setOpaque(false);
	}
	
	/** Add an item that was clicked on to the inventory
	 * @param item The item to be added
	 * @throws Exception So that the Scene class can be notified of a win condition
	 */
	public void addItem(Item item) throws Exception {
		inventory.addItem(item);
		repaint();
	}
	
	/** Repaint the panel
	 * @param arg0 Unused
	 */
	@Override
	protected void paintComponent(Graphics arg0) {
		super.paintComponent(arg0);
		
		if (isFirst) { // should help update the inventory
			remove(inventory);
			add(inventory, BorderLayout.NORTH);
		}
	}
}
