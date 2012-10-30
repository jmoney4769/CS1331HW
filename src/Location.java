/** Location class used to store information about a location
 * @author Jared Moore
 * @version 09/20/12
 */
public class Location {

	private String city, state;
	
	/** Constructor for Location
	 * Precondition:  An object needs to be made
	 * Postcondition:  An object is created with appropriate data
	 * @param city
	 * @param state
	 */
	public Location(String city, String state) {
		setCity(city);
		setState(state);
	}
	
	/** Setter for city
	 * Precondition:  The city variable needs to be initialized to an appropriate value
	 * Postcondition:  The city variable is set up
	 * @param city
	 */
	public void setCity(String city) {
		this.city = normalize(city);
	}

	/** Setter for state
	 * Precondition:  The state variable needs to be initialized to an appropriate value
	 * Postcondition:  The state variable is set up
	 * @param state
	 */
	public void setState(String state) {
		this.state = normalize(state);
	}

	/** Method used to change the capitalization to title case
	 * Precondition:  A parameter is given that may or may not be in the correct case
	 * Postcondition:  A string is returned in the correct case
	 * @param name
	 * @return String name with first letter capitalized
	 */
	private String normalize(String name) {
		name = name.toLowerCase();
		name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
		return name;
	}
	
	/** Getter for city
	 * @return instance variable city
	 */
	public String getCity() {
		return city;
	}
	
	/** Getter for state
	 * @return instance variable state
	 */
	public String getState() {
		return state;
	}
	
	/** Checks to see if two location objects have the same state
	 * Precondition:  The user wants to know if two location objects are the same state
	 * Postcondition:  The method returns a boolean value saying whether or not the two objects have the same state
	 * @param other
	 * @return boolean 
	 */
	public boolean isSameState(Location other) {
		if (this.getState().equals(other.getState()))
			return true;
		return false;
	}
	
	/** toString() method for the class.  Called when the class is being printed or the user wants the class to be 
	 *  represented as a String
	 */
	@Override
	public String toString() {
		return String.format("%s,%s", city, (state.substring(0,1) + state.substring(state.length() - 1, state.length())).toUpperCase());
	}
}
