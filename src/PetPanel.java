import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Class that is used to make a JPanel that allows the user to interact with a Pet object
 * @author Jared Moore
 * @version 10/3/12
 */
public class PetPanel extends JPanel {

	@SuppressWarnings("unused") // note I use in eclipse so I do not get a warning that pet is unused
	private Pet pet; // unused in the class, is essentially "dead" code, became unnecessary with the creation of the array
	private JLabel hunger, picture, number;
	private JButton feed, watch, poke, kill, lullaby, addPet, switchPet;
	private ArrayList<Pet> array;
	private int activePet = 0;
	
	/** Constructor for Pet Panel
	 * Sets up a JPanel object with the appropriate components
	 * @param p is the pet that will be the first pet in the object
	 */
	public PetPanel(Pet p) {

		pet = p; // don't really need, but need to have it according to the homework
		
		feed = new JButton("Feed"); // set up JButtons
		watch = new JButton("Watch");
		poke = new JButton("Poke");
		kill = new JButton("Kill");
		lullaby = new JButton("Lullaby");
		addPet = new JButton("Add a Pet");
		switchPet = new JButton("Switch Pets");
		
		ButtonListener listener = new ButtonListener(); // set up the listener for the buttons
		feed.addActionListener(listener);
		watch.addActionListener(listener);
		poke.addActionListener(listener);
		kill.addActionListener(listener);
		lullaby.addActionListener(listener);
		addPet.addActionListener(listener);
		switchPet.addActionListener(listener);
		
		array = new ArrayList<Pet>(); // set up array for Pet objects
		array.add(p);
		
		hunger = new JLabel(String.format("Hunger: %d", array.get(activePet).getHunger())); // set up JLabels
		picture = new JLabel(array.get(activePet).getCurrentIcon());
		number = new JLabel("");
		
		add(picture); // add components
		add(hunger);
		add(feed);
		add(kill);
		add(poke);
		add(watch);
		add(lullaby);
		add(addPet);
		add(number);
		
	}
	
	/** Class ButtonListener is a Listener for the JButtons
	 * @author Jared Moore
	 * @version 10/3/12
	 */
	private class ButtonListener implements ActionListener {
	
		/** Method used to determine if a button was clicked and, if so, take action
		 * Precondition:  A button was clicked
		 * Postcondition:  The appropriate action is taken
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == feed)
				array.get(activePet).feed();
			else if (event.getSource() == watch)
				array.get(activePet).watch();
			else if (event.getSource() == poke)
				array.get(activePet).poke();
			else if (event.getSource() == kill)
				array.get(activePet).kill();
			else if (event.getSource() == lullaby)
				array.get(activePet).sleep();
			else if (event.getSource() == addPet)
				addPet();
			else if (event.getSource() == switchPet)
				switchPet(false);
				
			refresh();
		}
	}
	
	/** Method used to refresh the contents of the Panel
	 * Precondition:  The pet object has been changed, but the Panel has not been updated
	 * Postcondition:  The Panel reflects the data of the current Pet object
	 */
	
	private void refresh() {
		
		hunger.setText(String.format("Hunger: %d", array.get(activePet).getHunger()));
		picture.setIcon(array.get(activePet).getCurrentIcon());
		if (array.size() > 1)
			number.setText(String.format("Current pet is %d", activePet + 1));
	}
	
	/** Used to add a pet to the array
	 * Precondition:  The user wants to add a pet
	 * Postcondition:  There is another pet in the array and it is now the active pet
	 */
	private void addPet() {
		array.add(new Pet());
		switchPet(true);
	}
	
	/** Used to switch the active Pet
	 * Precondition:  Either a pet was just added or the user wants to switch pets
	 * Postcondition:  The active pet is either the next one in order or it is the pet that was just added (if there was one)
	 * @param b to see if a pet was just added.  If it was, make that the active pet
	 */
	private void switchPet(boolean b) {
		if (array.size() == 2) {
			add(switchPet);
			number.setText(String.format("Current pet is %d", activePet + 1));
			
		}
		if (b) 
			activePet = array.size() - 1;
		else if (activePet + 1 <= array.size() - 1)
			activePet++;
		else
			activePet = 0;
		refresh();		
	}
}
