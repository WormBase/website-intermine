/**
 * 
 */
package wormbase.model.test;

import java.io.IOException;

import wormbase.model.parser.FileParser;
import wormbase.model.parser.ModelParser;

/**
 * @author jwong
 * This class instantiates and runs methods from other classes.
 */
public class TestClass {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String datafile = "test/test_datafiles/models.wrm";
		
		ModelParser mp = new ModelParser(datafile);

		
		System.out.println("End program");
	}
	
	

}
