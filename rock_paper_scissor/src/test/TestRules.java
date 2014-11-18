package test;

import static org.junit.Assert.*;
import model.Rules;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRules {

	private Rules rules;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rules = new Rules();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetAndGetBestOf() {
		assertEquals(1,rules.getBestOf());
		rules.setBestOf(3);
		assertEquals(3,rules.getBestOf());
	}

}
