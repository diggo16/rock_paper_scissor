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
	
	private Console consoleMock;
	private Console console;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		consoleMock = Mockito.mock(Console.class);
		console = new Console();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * test to ask for input option
	 */
	@Test
	public void testAskForInputOption() {
		Mockito.when(consoleMock.askForInputOption()).thenReturn("rock");
		
		String input = consoleMock.askForInputOption();
		if(input.equals("rock") != true) {
			fail();
		}
		consoleMock.closeScanner();
	}
	/*
	 * test to show the winner
	 */
	@Test
	public void testShowWinner() {
		console.showWinner(""); // should print out "tie!" in the console
		console.showWinner("user"); // should print out "user won!" in the console
		console.closeScanner();
	}
	/*
	 * test to present the the option
	 */
	@Test
	public void testPresentProfileOption() {
		
		User user = new User();
		user.setChoice("rock");
		
		Bot bot = new Bot();
		bot.setChoice();
		System.out.print("User got rock=");
		console.presentProfileOption(user.getClass().getSimpleName(),user.getChoice());
		System.out.print("Bot got \"option\"=");
		console.presentProfileOption(bot.getClass().getSimpleName(),bot.getChoice());
		console.closeScanner();
	}
	/*
	 * test the meny
	 */
	@Test
	public void testMeny() {
		/*
		 * loop for every option
		 */
		for(int k = 1; k < 4; k++) {
			Mockito.when(consoleMock.meny()).thenReturn(k);		// return k when method meny() from the console i called
			int choice = consoleMock.meny();
			int[] validNumbers = {1,2,3};		// every valid numbers in an array
			boolean ifValid = false;
			for(int i = 0; i < validNumbers.length; i++) {		// check if the return value was valid else fail the test
				if(choice == validNumbers[i]) {
					ifValid = true;
				}
			}
			if(ifValid == false) {
				fail();
			}
		}
	}
	@Test
	public void test() {
		console.meny();
		
	}
}
