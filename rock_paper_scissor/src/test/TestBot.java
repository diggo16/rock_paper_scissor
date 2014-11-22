package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import model.Bot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBot {

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
	/*
	 * test set and get choice methods
	 */
	@Test
	public void testSetAndGetChoice() {
		Bot bot = new Bot();
		//test 10 times
		for(int i = 0; i < 10; i++) {
			bot.setChoice();
			String botChoice = bot.getChoice();
			List<String> options = new ArrayList<String>();
			options.add("rock");
			options.add("paper");
			options.add("scissor");
			assertEquals(options.get(options.indexOf(botChoice)),botChoice);
		}
	}

}
