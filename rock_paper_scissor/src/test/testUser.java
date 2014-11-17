package test;

import static org.junit.Assert.*;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testUser {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testSetAndGetChoice() {
		User user = new User();
		String choice = "rock";
		user.setChoice(choice);
		assertEquals(choice,user.getChoice());
	}
	@Test
	public void testWrongAnswer() {
		User user = new User();
		String choice = "rocking";
		user.setChoice(choice);
		assertEquals(null,user.getChoice());
	}

}
