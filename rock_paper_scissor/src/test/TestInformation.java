package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import model.Information;
import model.Statistics;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestInformation {
	
	private Information info;
	private int user1Wins, user2Wins, user1Losses, user2Losses;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		info = new Information("info.txt");
		user1Wins = 3;
		user1Losses = 1;
		user2Wins = 2;
		user2Losses = 4;
		
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
		//user 1
		User user1 = new User("Name1");
		for(int i = 0; i < user1Wins; i++) {
			user1.gameResult("won");
		}
		user1.gameResult("lost");
		//user 2
		User user2 = new User("Name2");
		for(int i = 0; i < user2Wins; i++) {
			user2.gameResult("won");
		}
		for(int i = 0; i < user2Losses; i++) {
		user2.gameResult("lost");
		}
		
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
		//user 1
		User user1 = info.getUser("Name1");
		assertEquals("Name1",user1.getName());
		Statistics userStats1 = user1.getStatistics();
		assertEquals(user1Wins,userStats1.getWins());
		assertEquals(user1Losses,userStats1.getLosses());
		//user 2
		User user2 = info.getUser("Name2");
		assertEquals("Name2",user2.getName());
		Statistics userStats2 = user2.getStatistics();
		assertEquals(user2Wins,userStats2.getWins());
		assertEquals(user2Losses,userStats2.getLosses());
	}

}
