package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.PlayGame;

public class TestPlayGame {

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
	public void testGetUserOption() {
		User user = new User();
		PlayGame pg = new PlayGame(user);
		pg.newGame();
		assertEquals("rock",user.getChoice());
	}
	@Test
	public void testWinner() {
		User user = new User();
		PlayGame pg = new PlayGame(user);
		pg.showWinner();
	}
}
