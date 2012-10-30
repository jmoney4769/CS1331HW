import java.util.Random;

import javax.swing.ImageIcon;

/** Pet class used to create a Pet object for use in Pet Panel
 * 
 * @author Jared Moore
 * @version 10/3/12
 *
 */
public class Pet {

	private enum State {SLEEPING, EATING, DEAD, LAUGHING, NORMAL}
	private State state;
	private int hunger;
	private final static int FULL = 10;
	private ImageIcon dead = new ImageIcon("res/dead.png"), eating = new ImageIcon("res/eating.png"), laughing = new ImageIcon("res/laughing.png"), normal = new ImageIcon("res/normal.png"),
			sleeping = new ImageIcon("res/sleeping.png"); // set up her instead of in constructor just to make it easier
	
	/** Constructor for Pet.  Sets up a Pet object with hunger = FULL and state = NORMAL 
	 */
	public Pet() {
		setHunger(FULL);
		state = State.NORMAL;
		
	}

	/** Getter for state
	 * 
	 * @return current state of the object
	 */
	public State getState() {
		return state;
	}

	/** Setter for state
	 * 
	 * @param state that the user wishes to input
	 */
	public void setState(State state) {
		this.state = state;
	}

	/** Getter for hunger
	 * @return the current amount of hunger the Pet has
	 */
	public int getHunger() {
		return hunger;
	}

	/** Setter for hunger
	 * @param hunger that needs to be used
	 */
	public void setHunger(int hunger) {
		this.hunger = ((hunger >= 0) && (hunger < FULL)) ? hunger : FULL; // if hunger is not valid (negative or more than full), set it to full
	}

	/** Getter for FULL, no setter because it is final
	 * @return value of FULL
	 */
	public int getFULL() {
		return FULL;
	}
	
	/** Used to decide what image to use in PetPanel
	 * Precondition:  The Pet has changed States or the user needs to know what image to use
	 * Postcondition:  The PetPanel has the correct image to use
	 * @return ImageIcon to be used
	 */
	public ImageIcon getCurrentIcon() {
		
		switch (state) {
		case DEAD:
			return dead;
		case EATING:
			return eating;
		case LAUGHING:
			return laughing;
		case NORMAL:
			return normal;
		case SLEEPING:
			return sleeping;
		}
		return null;
	}
	
	/** Used to poke the pet, change the state, and decrement hunger
	 * Precondition:  The pet object is set up
	 * Postcondition:  The pet's state is now LAUGHING and hunger has decreased by one
	 */
	public void poke() {
		
		if (getState() != State.DEAD) {
			setState(State.LAUGHING);
			hunger--;
			checkForStarvation();
		}
	}
	
	/** Used to feed the pet, setting hunger to full
	 * Precondition:  The pet object is set up and not DEAD
	 * Postcondition:  The pet's state is EATING, hunger = FULL, and if it was already EATING, it is now DEAD
	 */
	public void feed() {
		
		if (getState() != State.DEAD) {
			if (getState() == State.EATING) {
				setState(State.DEAD);
				return;
			}
			setHunger(FULL);
			setState(State.EATING);
		}
	}
	
	/** Used to put the pet to sleep
	 * Precondition:  The pet object is set up and not DEAD
	 * Postcondition:  The pet's state is SLEEPING
	 */
	public void sleep() {
		
		setState(State.SLEEPING);
	}
	
	/** Used to make the pet sit, change the state, and decrement hunger
	 * Precondition:  The pet object is set up and not DEAD
	 * Postcondition:  The pet's state is NORMAL and hunger is decreased by one	
	 */
	public void sit() {
		
		 if (getState() != State.DEAD) {
			 hunger--;
			 setState(State.NORMAL);
			 checkForStarvation();
		 }
	}
	
	/** Used to "watch" the pet perform actions
	 * Precondition: The pet object is set up and not DEAD
	 * Postcondition:  The pet randomly calls sit(), sleep(), or poke()
	 */
	public void watch() {
		
		Random random = new Random();
		int value = random.nextInt(3);
		
		switch (value) {
		case 0:
			sit();
			return;
		case 1:
			sleep();
			return;
		case 2:
			poke();
			return;
		}
	}
	
	/** Used to kill the Pet
	 * Precondition:  The pet object is set up, can be any State
	 * Postcondition:  The pet is DEAD
	 */
	public void kill() {
		
		setState(State.DEAD);
	}
	
	/** Checks to see if the Pet is Starving
	 * Precondition:  The pet has just decremented the hunger variable
	 * Postcondition:  If hunger == 0, the Pet becomes DEAD, otherwise, it will continue as it was
	 */
	public void checkForStarvation() {
		
		if (hunger == 0)
			setState(State.DEAD);
	}
}
