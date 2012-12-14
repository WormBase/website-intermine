package junit.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest2 {

	@Test
	public void test() {
		String dataPath = "ClassA.ClassB.Attr";
		String fieldName = "";
		
    	Matcher fNMatcher = Pattern.compile("(.*?)\\.").matcher(dataPath);
    	if( fNMatcher.find() ){
        	fieldName = fNMatcher.group(1);
    	}
    	
		assertEquals("ClassA", fieldName);
	}

}
