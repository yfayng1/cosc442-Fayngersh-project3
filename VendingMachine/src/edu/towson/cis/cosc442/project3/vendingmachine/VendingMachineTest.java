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
public class VendingMachineTest {

	VendingMachine myVendingMachine;
	VendingMachineItem v1, v2;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myVendingMachine = new VendingMachine();
		v1 = new VendingMachineItem("Oreo", 5);
		v2 = new VendingMachineItem("Dorito", 4);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing for successfully adding an item to an empty slot of the vending machine.
	 */
	@Test
	public void testAddItem1() {
		myVendingMachine.addItem(v1, "A");
		assertNotNull(myVendingMachine.getSlotIndex("A"));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing for unsuccessfully adding an item to a slot in the vending machine because the slot is occupied.
	 */
	@Test
	public void testAddItem2() {
		boolean thrown = false;
		try {
			myVendingMachine.addItem(v1, "A");
			myVendingMachine.addItem(v2, "A");
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project3.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Testing for unsuccessfully adding an item to a slot in the vending machine because the slot code is invalid.
	 */
	@Test
	public void testAddItem3() {
		boolean thrown = false;
		try {
			myVendingMachine.addItem(v1, "G");
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Testing for successfully removing an item from a slot in the vending machine.
	 */
	@Test
	public void testRemoveItem1() {
		myVendingMachine.addItem(v1, "A");
		myVendingMachine.removeItem("A");
		assertNull(myVendingMachine.getItem("A"));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Testing for unsuccessfully removing an item from a slot in the vending machine due to the slot being empty.
	 */
	@Test
	public void testRemoveItem2() {
		boolean thrown = false;
		try {
			myVendingMachine.removeItem("A");
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Testing for unsuccessfully removing an item from a slot in the vending machine due to the slot being invalid.
	 */
	@Test
	public void testRemoveItem3() {
		boolean thrown = false;
		try {
			myVendingMachine.removeItem("E");
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Testing for successfully inserting money into the vending machine.
	 */
	@Test
	public void testInsertMoney1() {
		myVendingMachine.insertMoney(5);
		assertEquals(5, myVendingMachine.getBalance(), 0.001);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Testing for unsuccessfully inserting money into the vending machine due to negative amount.
	 */
	@Test
	public void testInsertMoney2() {
		boolean thrown = false;
		try {
			myVendingMachine.insertMoney(-5);
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#getBalance()}.
	 * Testing for initial balance being 0.
	 */
	@Test
	public void testGetBalance1() {
		double b = myVendingMachine.getBalance();
		assertEquals(0, b, 0.001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#getBalance()}.
	 * Testing for balance increasing after inserting money.
	 */
	@Test
	public void testGetBalance2() {
		double b1 = myVendingMachine.getBalance();
		myVendingMachine.insertMoney(5);
		double b2 = myVendingMachine.getBalance();
		assertNotEquals(b1, b2);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Testing for successfully purchasing an item.
	 */
	@Test
	public void testMakePurchase1() {
		myVendingMachine.addItem(v1, "A");
		myVendingMachine.insertMoney(5);
		boolean successfullyPurchased = myVendingMachine.makePurchase("A");
		assertTrue(successfullyPurchased);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Testing for unsuccessfully purchasing an item due to insufficient balance.
	 */
	@Test
	public void testMakePurchase2() {
		myVendingMachine.addItem(v1, "A");
		boolean unsuccessfullyPurchased = myVendingMachine.makePurchase("A");
		assertFalse(unsuccessfullyPurchased);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Testing for unsuccessfully purchasing an item due to empty slot.
	 */
	@Test
	public void testMakePurchase3() {
		boolean unsuccessfullyPurchased = myVendingMachine.makePurchase("A");
		assertFalse(unsuccessfullyPurchased);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Testing for unsuccessfully purchasing an item due to invalid slot.
	 */
	@Test
	public void testMakePurchase4() {
		boolean thrown = false;
		try {
			myVendingMachine.makePurchase("F");
			} catch (VendingMachineException e) {
			    thrown = true;
			  }
		assertTrue(thrown);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#returnChange()}.
	 * Testing for successfully returning no change due to initial balance being 0.
	 */
	@Test
	public void testReturnChange1() {
		assertEquals(0, myVendingMachine.returnChange(), 0.001);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#returnChange()}.
	 * Testing for successfully returning change equal to the previous balance.
	 */
	@Test
	public void testReturnChange2() {
		myVendingMachine.insertMoney(5);
		assertEquals(myVendingMachine.getBalance(), myVendingMachine.returnChange(), 0.001);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project3.vendingmachine.VendingMachine#returnChange()}.
	 * Testing to ensure balance is 0 after returning change.
	 */
	@Test
	public void testReturnChange3() {
		myVendingMachine.insertMoney(5);
		myVendingMachine.returnChange();
		assertEquals(0, myVendingMachine.getBalance(), 0.001);
	}
}
