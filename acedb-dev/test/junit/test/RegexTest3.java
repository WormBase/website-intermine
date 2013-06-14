package junit.test;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.xerces.impl.xpath.regex.Match;
import org.junit.Test;

public class RegexTest3 {

	/**
	 * Safer way, extracting all before first '.'
	 */
	
	@Test
	public void test() {
		String mappingFileKey = "(Phenotype) parents";
		String castType = "";
		
		Pattern paransB4XPath  = Pattern.compile("\\((.*)\\)\\s*");
		Matcher typeCastMatcher = paransB4XPath.matcher(mappingFileKey);
		
		String matchedText = null;
     	if(typeCastMatcher.find()){
    		matchedText = typeCastMatcher.group(1);
    		String dataPath = mappingFileKey.substring(typeCastMatcher.end());
    		
			assertEquals("parents", dataPath);
     	}
     	
	}

}
