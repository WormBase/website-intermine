package wormbase.model.parser;

import java.io.IOException;
import java.util.regex.*;

public class ModelParser {

	
	
	/**
	 * 
	 */
	public ModelParser(String modelFile){
		
		try {
			FileParser fp = new FileParser(modelFile);
			
			String[] dataObj;
			
			// Get the gene model specification
			while( (dataObj = fp.getDataObj()) != null ){ 
				System.out.println(dataObj[0]);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
