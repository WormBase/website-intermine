package junit.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.regex.*;

import org.junit.Test;

public class RegexReplaceTest {

	@Test
	public void test() {
		String inputStr = "aabfooaabfooabfoob";
		String patternStr = "a*b";
		String replacementStr = "-";
		
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(inputStr);
		StringBuffer sb = new StringBuffer();
		while(matcher.find()){
			matcher.appendReplacement(sb, replacementStr);
		}
		matcher.appendTail(sb);
		
		
		assertEquals("No match","-foo-foo-foo-", sb.toString());
		
		test2();
	}
	
	// Replace all numbers with "asdf"
	public void test2(){
				
		String inputStr = "1-2-3-4";
		
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(inputStr);
		StringBuffer sb = new StringBuffer();
		
		String resultStr = matcher.replaceAll("asdf");
		
		
		assertEquals("No match","asdf-asdf-asdf-asdf", resultStr);
		
		test3();
	}
	
	// Replace each number with it's string
	public void test3(){
		
		HashMap<Integer, String> numberMap = new HashMap<Integer, String>();
		numberMap.put(1, "one");
		numberMap.put(2, "two");
		numberMap.put(3, "three");
		numberMap.put(4, "four");

		String inputStr = "1-2-3-4";
		String patternStr = "(\\d+)";
		
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(inputStr);
		StringBuffer sb = new StringBuffer();
		while(matcher.find()){
			String matchedText = matcher.group(1);
			String processedText = numberMap.get(Integer.parseInt(matchedText));
			matcher.appendReplacement(sb, processedText);
		}
		matcher.appendTail(sb);
		
		
		assertEquals("No match","one-two-three-four", sb.toString());

	}

}
