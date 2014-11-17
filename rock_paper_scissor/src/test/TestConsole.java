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

public class TestConsole {

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
	public void testAskForInputOption() {
		Console consoleStub = Mockito.mock(Console.class);
		Mockito.when(consoleStub.askForInputOption()).thenReturn("rock");
		
		String input = consoleStub.askForInputOption();
		if(input.equals("rock") != true) {
			fail();
		}
		consoleStub.closeScanner();
	}
	@Test
	public void testShowWinner() {
		Console console = new Console();
		
		console.showWinner(""); // should print out "tie!" in the console
		console.showWinner("user"); // should print out "user won!" in the console
		console.closeScanner();
	}
	@Test
	public void testPresentProfileOption() {
		
		Console console = new Console();
		User user = new User();
		user.setChoice("rock");
		
		Bot bot = new Bot();
		bot.setChoice();
		System.out.print("User got rock=");
		console.presentProfileOption(user.getClass().getSimpleName(),user.getChoice());
		System.out.print("Bot got \"option\"=");
		console.presentProfileOption(bot.getClass().getSimpleName(),bot.getChoice());
	}
}
