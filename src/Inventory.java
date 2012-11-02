import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/** Class used to hold the objects that are in the user's inventory
 * @author Jared Moore
 * @version 11/2/12
 */
public class Inventory extends JLayeredPane implements Serializable {

	private ArrayList<Item> items;
	private JLabel label = new JLabel("Inventory:");
	
	/** Constructor for the class.  Sets up a new, empty inventory
	 */
	public Inventory() {
		
		items = new ArrayList<Item>();
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(label, POPUP_LAYER);
		setOpaque(true);
	}
	
	/** Repaint the panel, with the items in alphabetical order
	 * @param g Unused
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		removeAll();
		add(label, POPUP_LAYER);
		Collections.sort(items);
		for (Item i : items)
			add(i.getLabel(), POPUP_LAYER);
	}
	
	/** Adds an item to the inventory
	 * @param i The item to be added
	 * @throws Exception to let the main panel know that the win condition was reached
	 */
	public void addItem(Item i) throws Exception {
		items.add(i);
		repaint();
		if (items.size() == Scene.NUM_OF_SCENES)
			throw new Exception();
	}
}
