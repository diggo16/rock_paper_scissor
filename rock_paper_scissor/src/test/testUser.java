package test;

import static org.junit.Assert.*;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testUser {

	private User user;
	private String choice;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User("user");
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testSetAndGetChoice() {
		choice = "rock";
		user.setChoice(choice);
		assertEquals(choice,user.getChoice());
	}
	@Test
	public void testWrongAnswer() {
		choice = "rocking";
		user.setChoice(choice);
		assertEquals(null,user.getChoice());
	}
	@Test
	public void testStatistics() {
		for(int i = 0 ; i < 5 ; i++) {
		user.win();
		}
		assertEquals(5,user.getScore());
	}

}
