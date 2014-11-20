package test;

import static org.junit.Assert.fail;
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

	private User user;
	private Console console;
	private PlayGame pg;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		user = new User();
		console = Mockito.mock(Console.class);
		Mockito.when(console.askForInputOption()).thenReturn("rock");
		pg = new PlayGame(user,console);
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	 * test the function newGame
	 */
	@Test
	public void testNewGameAndWinner() {
		pg.newGame();
		boolean succeed = pg.showWinner();
		if(succeed == false) {
			fail();
		}		
	}
	@Test
	public void testConsoleCall() {
		pg.newGame();
		Mockito.verify(console).presentProfileOption("User","rock");
		
	}
	@Test
	public void TestMeny() {
		pg.meny();
		Mockito.verify(console).meny();
	}
}