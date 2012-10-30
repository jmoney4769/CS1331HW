import static org.junit.Assert.*;

import org.junit.Test;


public class PetTest {

	@Test
	public void testGetHunger() {
		Pet pet = new Pet();
		assertEquals(10, pet.getHunger());
		pet.poke();
		assertEquals(9, pet.getHunger());
	}

}
