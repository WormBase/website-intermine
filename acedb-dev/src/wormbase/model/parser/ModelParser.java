package wormbase.model.parser;

import java.io.IOException;
import java.util.regex.*;

public class ModelParser {

	private String jaceFile = "/home/jwong/git/website-intermine/acedb-dev/acedb/datafiles/gene1.jace";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ModelParser mp = new ModelParser();
		try {
			FileParser fp = new FileParser(mp.jaceFile);
			fp.getDataObj();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("End program");
	}

}
