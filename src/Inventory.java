import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;


public class Inventory extends JPanel {

	private ArrayList<Item> items;
	
	public Inventory() {
		
		items = new ArrayList<Item>();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Collections.sort(items);
		for (Item i : items)
			add(i.getLabel());
	}
	
	public void add(Item i) {
		items.add(i);
		repaint();
	}
}
