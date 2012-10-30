import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryOperationsTest {

	@Test
	public void testAnd() {
		
		assertEquals("0001", BinaryOperations.and("0101", "0011"));
		assertEquals("0111", BinaryOperations.or("0101", "0011"));
		assertEquals("0110", BinaryOperations.xor("0101", "0011"));
		assertEquals("1000", BinaryOperations.xor("1010", "0010"));
	}

}
