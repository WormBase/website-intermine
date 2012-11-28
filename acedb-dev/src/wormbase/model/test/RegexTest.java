package wormbase.model.test;

import static org.junit.Assert.*;

import java.util.regex.*;

import org.junit.Test;

public class RegexTest {

	@Test
	public void test() {
		
		String modelHeader = "?Gene   Evidence #Evidence"; 
		String firstLine = "?Gene?WBGene00000001?	?tag?Evidence?	?tag?CGC_data_submission?";
		
//		String regex = "^\\?(Gene).*";
//
//		Pattern p = Pattern.compile(regex);
//		Matcher m = p.matcher(testString);
//		
//		String[] strAry = testString.split("\\s+");
//		
//		boolean b = m.matches();
		
		String[] spaceTokens = firstLine.split("\\s+");
		
		String[] qtokens = spaceTokens[0].split("\\?",0);
		
		String type = qtokens[1];
		String ID = qtokens[2];

		
		assertTrue("JD: incorrect type",type.matches("Gene"));
		assertTrue("JD: incorrect ID", ID.matches("WBGene00000001"));
		
	}

}
