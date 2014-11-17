package test;

import static org.junit.Assert.*;
import model.Rules;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRules {

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
	public void testSetAndGetBestOf() {
		Rules rules = new Rules();
		rules.setBestOf(3);
		assertEquals(3,rules.getBestOf());
	}

}
