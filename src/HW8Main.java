import javax.swing.ImageIcon;
import javax.swing.JFrame;

/** Runner class for the program
 * @author Jared Moore
 * @version 11/2/12
 */
public class HW8Main {

	private static Scene scene = null;
	
	/** Constructor used to make the save/load methods work
	 * @param scene The scene object to be used
	 */
	
	public HW8Main(Scene scene) {
		this.scene = scene;
	}
	
	/** Main method to run the program
	 * @param args Unused
	 */
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		
		if (scene == null) {
			ImageIcon image = new ImageIcon("res/room1.jpg");
			scene = new Scene(image);	
		}
		frame.add(scene);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
