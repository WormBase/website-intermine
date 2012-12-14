package junit.test;

import static org.junit.Assert.*;

import java.util.regex.*;

import org.junit.Test;

public class RegexTest {

	/**
	 * Extract "HELLO" out of string
	 */
	@Test
	public void test() {
		String testString = "asdfHELLO12345";
		
		// create a pattern object with pattern string
		Pattern pattern = Pattern.compile("asdf(.*?)\\d+"); 
		
		// create a matcher object with pattern
		Matcher matcher = pattern.matcher(testString);
		
		// apply the pattern
		matcher.find(); 
		
		assertEquals("HELLO",matcher.group(1));
		
	}

}
