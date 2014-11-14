package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.Bot;
import model.User;

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

	@Test
	public void testSetAndGetChoice() {
		Bot bot = new Bot();
		bot.setChoice();
		
		String botChoice = bot.getChoice();
		List<String> options = new ArrayList<String>();
		options.add("rock");
		options.add("paper");
		options.add("scissor");
		if(options.contains(botChoice)) {
			assertEquals(options.get(options.indexOf(botChoice)),botChoice);
		}
	}

}
