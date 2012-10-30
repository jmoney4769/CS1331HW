import java.util.ArrayList;

/** Class used to store and perform operations on an array
 * @author Jared Moore
 * @version 10/21/12
 * In order to help learn course concepts, I consulted materials found at http://en.wikipedia.org/wiki/Mergesort 
 * in order to learn about the implementation of Merge Sort as I could not quite remember the way I had done it before
 */
public class ArrayWrapper {

	private int[] array;
	
	/** Constructor that sets the array in the class
	 * @param array list of parameters or array that will be used as the array in the class
	 */
	public ArrayWrapper(int ... array) {
		setArray(array);
	}
	
	@Override
	/** Output a String with the array's elements properly displayed
	 * @return a String containing the elements of the array
	 */
	public String toString() {
		if (array.length == 0)
			return "[]";
		else {
			String temp = "[";
			for (int i = 0; i < array.length; i++) {
				temp += (array[i]);
				if (i + 1 < array.length)
					temp += ", ";
			}
			temp += "]";
			return temp;
		}
	}
	
	/** Find the first index where the int is located
	 * @param i the element that you want to find
	 * @return the first index where the element appears.  If it is not there, return -1
	 */
	public int indexOf(int i) {
		for (int j = 0; j < array.length; j++)
			if (array[j] == i)
				return j;
		return -1;
	}
	
	/** Returns the size of the array
	 * @return an int describing the amount of elements in the array
	 */
	public int size() {
		return array.length;
	}
	
	/** Insert an element into the array at the desired index
	 * @param index the index to place the element
	 * @param element the element to be added
	 */
	public void insert(int index, int element) {
		
		index = (index > 0) ? index : 0;
		index = (index < array.length) ? index : array.length - 1;
		int[] newArray = new int[array.length + 1];
		for (int i = 0; i < newArray.length; i++) {
			if (i < index)
				newArray[i] = array[i];
			else if (i == index)
				newArray[i] = element;
			else if (i > index)
				newArray[i] = array[i - 1];
		}
		array = newArray;
	}
	
	/** Put an ArrayWrapper at the end of this one
	 * @param wrapper the ArrayWrapper to be added
	 */
	public void concatenate(ArrayWrapper wrapper) {
		
		int[] newArray = new int[array.length + wrapper.size()];
		for (int i = 0; i < array.length; i++) 
			newArray[i] = array[i];
		for (int i = 0; i < wrapper.size(); i++) 
			newArray[array.length + i] = wrapper.get(i);
		array = newArray;
	}
	
	/** Put an array of ints at the end of this array
	 * @param n the array to be added 
	 */
	public void addToEnd(int ... n) {
		concatenate(new ArrayWrapper(n));
	}
	
	/** Remove the element at the specified index
	 * @param index the index of the element to be removed
	 * @return the element that was removed
	 */
	public int remove(int index) {
		
		index = (index > 0) ? index : 0;
		index = (index < array.length) ? index : array.length - 1;
		int element = get(index);
		int[] newArray = new int[array.length - 1];
		for (int i = 0; i < newArray.length; i++)
			if (i < index)
				newArray[i] = array[i];
			else if (i >= index)
				newArray[i] = array[i + 1];
		array = newArray;
		return element;
	}
	
	/** Remove the specified element from the array assuming it exists
	 * @param element the element that will be removed
	 * @return the element if it exists, else return -1
	 */
	public int removeElement(int element) {
		
		for (int i = 0; i < array.length; i++)
			if (get(i) == element) {
				remove(i);
				return element;
			}
		return -1;
	}
	
	/** Clear the array, leaving no elements
	 */
	public void clear() {
		
		array = new int[0];
	}
	
	/** Get the element at the specified index
	 * @param index the index of the element desired
	 * @return the element at the specified index
	 */
	public int get(int index) {
		return array[index];
	}
	
	/** Get the average of the elements in the array
	 * @return a double that is the average of the elements
	 */
	public double mean() {
		
		double total = 0;
		for (int i : array)
			total += i;
		return total / array.length;
	}

	/** Getter for array
	 * @return array
	 */
	public int[] getArray() {
		return array;
	}

	/** Setter for array
	 * @param array the array to be used
	 */
	public void setArray(int[] array) {
		this.array = array;
	}
	
	/** Shift the array the specified amount of elements, if a is negative, shift backwards
	 * @param a the amount of indices to shift the elements
	 */
	public void shift(int a) {
		
		int[] newArray = new int[array.length];
		
		for (int i = 0; i < array.length; i++) 
			if ((a + i < array.length) && (a + i >= 0))
				newArray[a + i] = array[i];
			else if (a + i >= array.length)
				newArray[(i + a) - array.length] = array[i];
			else if (a + i < 0)
				newArray[array.length + (i + a)] = array[i];
		array = newArray;
	}
	
	/** Sort the elements in the array
	 */
	public void sort() {
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		for (int i : array)
			arrayList.add(i);
		arrayList = mergesort(arrayList);
		for (int i = 0; i < size(); i++)
			array[i] = arrayList.get(i);
	}

	/** Use a recursive mergesort algorithm to sort the array
	 * @param sort the array to be sorted
	 * @return the sorted array
	 */
	private ArrayList<Integer> mergesort(ArrayList<Integer> sort) {
		
		if (sort.size() <= 1)
			return sort; // base case to end the recursive calls
		ArrayList<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
		int mid = sort.size() / 2;
		
		for (int i = 0; i < mid; i++) // split the array in half
			left.add(sort.get(i));
		for (int i = mid; i < sort.size(); i++)
			right.add(sort.get(i));
		
		left = mergesort(left); // split the arrays into smaller and smaller pieces so that eventually the will have just one element, meaning they have to be sorted
		right = mergesort(right);
		
		return merge(left, right);
	}

	/** Merges together two sorted arrays into one sorted one
	 * @param left the first array
	 * @param right the second array
	 * @return an array containing the elements of both of the arrays sorted
	 */
	private ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right) {
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while ((left.size() > 0) || (right.size() > 0)) // while there all still elements
			
			if ((left.size() > 0) && (right.size() > 0)) // remove the larger and add it to result
				if (left.get(0) < right.get(0))
					result.add(left.remove(0)); 
				else 
					result.add(right.remove(0));
		
			else if (left.size() > 0)
				result.add(left.remove(0));
		
			else if (right.size() > 0)
				result.add(right.remove(0));
		return result;
	}
	
}
