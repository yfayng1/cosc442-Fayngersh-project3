/**
 * 
 */
package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Fima
 *
 */
public class VendingMachineItemTest {

	private VendingMachineItem v1, v2;
	private String n1, n2;
	private double p1, p2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		n1 = "Oreo";
		p1 = 0.0;
		v1 = new VendingMachineItem(n1, p1);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 * Testing for successfully instantiating a new VendingMachineItem.
	 */
	@Test
	public void testVendingMachineItem1() throws Exception {
		assertNotNull(v1);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 * Testing for unsuccessfully instantiating a new VendingMachineItem due to a negative price.
	 */
	@Test
	public void testVendingMachineItem2() {
		boolean thrown = false;
		try {
			n2 = "Dorito";
			p2 = -5.0;
			v2 = new VendingMachineItem(n2, p2);
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem#getName()}.
	 * Testing for successfully returning the name of the VendingMachineItem.
	 */
	@Test
	public void testGetName() {
		assertSame("Oreo", v1.getName());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem#getPrice()}.
	 * Testing for successfully returning the price of the VendingMachineItem.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(0.0, v1.getPrice(), 0.001);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
}
