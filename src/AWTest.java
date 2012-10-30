/** Class used to the ArrayWrapper class
 * @author Jared Moore
 * @version 10/21/12
 */
public class AWTest {

	/** Test all of the methods in the ArrayWrapper class
	 * @param args unused
	 */
	public static void main(String[] args) {
		
		ArrayWrapper wrapper = new ArrayWrapper(1, 14, 12, 7, 8, 16, 5);
		System.out.println(wrapper);
		System.out.printf("The index of 14 is %d\n", wrapper.indexOf(14));
		System.out.printf("The size of the array is %d\n", wrapper.size());
		wrapper.insert(4, 6);
		System.out.printf("The new 4th element is %d\n", wrapper.getArray()[4]);
		System.out.printf("The array with a 6 inserted at index 4 is %s\n", wrapper.toString());
		ArrayWrapper array = new ArrayWrapper(2, 3);
		wrapper.concatenate(array);
		System.out.printf("The array with %s concatenated is %s\n", array.toString(), wrapper.toString());
		wrapper.addToEnd(1, 15);
		System.out.printf("The array with [1, 15] added to the end is %s\n", wrapper.toString());
		wrapper.remove(6);
		System.out.printf("The array without the 6th index is %s\n", wrapper.toString());
		System.out.printf("The new 6th index is %d\n", wrapper.getArray()[6]);
		System.out.printf("The array without the number %d is %s\n", wrapper.removeElement(15), wrapper.toString());
		wrapper.clear();
		System.out.printf("The array cleared is %s\n", wrapper.toString());
		wrapper.addToEnd(1, 14, 12, 7, 8, 16, 5);
		System.out.println(wrapper.toString());
		System.out.printf("The number in the fifth index is %d\n", wrapper.get(5));
		System.out.printf("The mean of the array is %.2f\n", wrapper.mean());
		wrapper.shift(4);
		System.out.printf("The array shifted forward 4 places is %s\n", wrapper.toString());
		wrapper.shift(-4);
		System.out.printf("And back:  %s\n", wrapper.toString());
		wrapper.sort();
		System.out.printf("The array sorted is %s", wrapper.toString());
	}
}
