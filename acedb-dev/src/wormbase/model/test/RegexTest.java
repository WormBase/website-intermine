package wormbase.model.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegexTest {

	@Test
	public void test() {
		
		String testString = "?Gene   Evidence #Evidence"; // DELETE
		//testString = "?Gene";
		
		String regex = "^\\?Gene.*";
		
		
		assertTrue("String doesn't match",false);
		
	}

}
