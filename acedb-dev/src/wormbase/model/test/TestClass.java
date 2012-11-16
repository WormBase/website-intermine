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
		
		String jaceFile = "/home/jwong/git/website-intermine/acedb-dev/acedb/datafiles/gene3.jace";
		
		ModelParser mp = new ModelParser();
		try {
			FileParser fp = new FileParser(jaceFile);
			
			String[] dataObj;
			// foreach ""-separated paragraph in jacefile
			while( (dataObj = fp.getDataObj()) != null ){ 
				System.out.println(dataObj.length);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("End program");
	}

}
