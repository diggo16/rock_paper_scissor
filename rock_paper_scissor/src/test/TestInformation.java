package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import model.Information;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInformation {
	
	private Information info;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		info = new Information("info.txt");
	}
	@After
	public void tearDown() throws Exception {
	}

	/* 
	 * Test to save the information
	 */
	@Test
	public void testSave() {
		List<User> users = new ArrayList<User>();
		User user1 = new User("Name1");
		user1.setChoice("rock");
		User user2 = new User("Name2");
		user2.setChoice("paper");
		users.add(user1);
		users.add(user2);
		if(info.save(users) == false) {
			fail();
		}
	}
	/*
	 * test to load the information
	 */
	@Test
	public void TestLoad() {
		try {
			info.load();
		} catch (FileNotFoundException e) {
			System.out.println("fail");
			fail();
		}
		User user = info.getUser("Name1");
		assertEquals("rock",user.getChoice());
	}

}
