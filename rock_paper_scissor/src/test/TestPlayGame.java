package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.Bot;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import view.Console;
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
	/*
	 * test the function newGame
	 */
	@Test
	public void testNewGame() {
		User user = new User();
		Console console = new Console();
		PlayGame pg = new PlayGame(user,console);
		
		pg.settings();
		
		pg.newGame();
		assertEquals("rock",user.getChoice()); // test if the users choice is the same that he chose
		
		boolean succeed = pg.showWinner(); // test if the winner is correct
		if(succeed == false) {
			fail();
		}
	}
	@Test
	public void testConsoleCall() {
		User user = new User();
		Console console = Mockito.mock(Console.class);
		Mockito.when(console.askForInputOption()).thenReturn("rock");
		PlayGame pg = new PlayGame(user,console);
		pg.newGame();
		
		Mockito.verify(console).presentProfileOption("User","rock");
		
	}
}