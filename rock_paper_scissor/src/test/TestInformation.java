package test;

import static org.junit.Assert.*;
import model.Information;
import model.User;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class TestInformation {

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
	public void testSave() {
		Information info = new Information("info.txt");
		info.save();
		User user = info.getUser("Daniel");
		assertEquals("rock",user.getChoice());
		
		
	}

}
