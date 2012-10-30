import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Item implements Comparable<Item>{

	private ImageIcon icon;
	private String name, description;
	private JLabel label;
	
	public Item(ImageIcon icon, String nm, String des) {
		this.icon = icon;
		this.name = nm;
		this.description = des;
		
		label = new JLabel(this.name);
		label.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				JOptionPane.showMessageDialog(null, description, name, JOptionPane.PLAIN_MESSAGE);
			}
		});
	}

	public JLabel getLabel() {
		return label;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(Item o) {
		return (getName().compareTo(o.getName()));
	}
	
	
}
