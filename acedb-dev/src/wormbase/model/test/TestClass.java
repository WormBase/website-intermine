/**
 * 
 */
package wormbase.model.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

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
		
		final String datafile = "test/test_datafiles/models.wrm";
		
//		Scanner user_input = new Scanner( System.in );
//		String line;
//		while( (line = user_input.nextLine()) != null ){
//			System.out.println(line.matches("^\\s*//.*"));
//		}
		
		
		try {
			FileParser fp = new FileParser(datafile);
			
			String[] dataChunk;
			while( (dataChunk = fp.getDataObj()) != null ){ 
			//WMDebug.debug(dataChunk[0]);  // DEBUG
			
				String firstLine = dataChunk[0];
				if( firstLine.matches("^\\s*//.*") ){
					continue;
				}
				
				if( firstLine.split("\\s+").length > 1 ){
					System.out.println( firstLine.split("\\s+")[0] );
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		System.out.println("End program");
	}
	
	

}
