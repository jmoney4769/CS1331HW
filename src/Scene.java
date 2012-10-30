import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;


public class Scene extends JLayeredPane {

	private ImageIcon image;
	private Door door1 = new Door(true), door2 = new Door(false);
	private int currentScene = 1;
	public final int NUM_OF_SCENES = 3;
	private JLabel background;
	
	public Scene(ImageIcon img) {
		
		setLayout(new BorderLayout());
		MouseClick listener = new MouseClick();
		
		door1.addMouseListener(listener);
		door2.addMouseListener(listener);
		add(door1,BorderLayout.WEST, DEFAULT_LAYER);
		add(door2,BorderLayout.EAST, DEFAULT_LAYER);
		
		image = img;
		background = new JLabel(image);
		background.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		add(background, Integer.MIN_VALUE);
		setOpaque(false);
		
		Dimension panelSize = new Dimension(image.getIconWidth(), image.getIconHeight());
		setPreferredSize(panelSize);
		setMaximumSize(panelSize);
		setMinimumSize(panelSize);
		
	}
	
	private class MouseClick extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			if (e.getSource() == door1)
				advanceScene(true);
			else if (e.getSource() == door2)
				advanceScene(false);
		}
	}

	
	private void advanceScene(boolean b) {
		
		if (currentScene == NUM_OF_SCENES && b)
			currentScene = 1;
		else if (currentScene == 1 && !b)
			currentScene = NUM_OF_SCENES;			
		else 
			if (b)
				currentScene++;
			else
				currentScene--;
		image = new ImageIcon("res/room" + Integer.toString(currentScene) + ".jpg");
		background.setIcon(image);
	}
}
