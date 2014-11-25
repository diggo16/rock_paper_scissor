package test;

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

	private User user;
	private Bot bot;
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

		user = new User("user");
		bot  = new Bot();
		console = Mockito.mock(Console.class);
		Mockito.when(console.askForInputOption()).thenReturn("rock");
		pg = new PlayGame(user,bot,console);
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
	/*
	 * test the meny
	 */
	@Test
	public void testMeny() {
		console = new Console();
		pg = new PlayGame(user,bot,console);
		pg.meny();	
	}
	/*
	 * test several games with different best of numbers
	 */
	@Test
	public void testBestOf() {
		/*
		 * test best of 1, 3, 5, 7 and 9
		 */
		for(int i = 1 ; i <10; i = i + 2) {
			int round = i;
			int maxScore = round / 2 +1;
			Mockito.when(console.askForRounds()).thenReturn(round);
			pg.settings();
			pg.newGame();
			
			if(user.getScore() != maxScore && bot.getScore() != maxScore) {
				System.out.println(user.getScore()+" "+bot.getScore());
				fail("");
			}
		}
	}
	@Test
	public void testWinner() {
		user.reset();
		bot.reset();
		for(int i = 0; i < 2; i++) {
			user.win();
		}
		bot.win();
		pg.winner();
		Mockito.verify(console).showWinner("user");
		
	}
	@Test
	public void testReset() {
		User mockUser = Mockito.mock(User.class);
		Bot mockBot = Mockito.mock(Bot.class);
		mockUser.win();
		mockBot.win();
		PlayGame play = new PlayGame(mockUser,mockBot,console);
		play.newGame();
		
		Mockito.verify(mockUser).reset();
		Mockito.verify(mockBot).reset();
		
		
	}
}