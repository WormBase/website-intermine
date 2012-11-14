package wormbase.model.parser;

import java.io.*;
import java.util.*;

public class FileParser {

	BufferedReader inputStream;
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public FileParser(String jaceFile) throws IOException {
        
		inputStream = new BufferedReader(new FileReader(jaceFile));

	}
	
	/**
	 * 
	 * @return Array of strings comprising the Ace data object
	 * @throws IOException 
	 */
	public String[] getDataObj() throws IOException{
		ArrayList<String> lines = new ArrayList<String>();
		
		String line;
        try {
			while ((line = (String) inputStream.readLine()) != null) {
			    System.out.println(line);
			    lines.add(line);
			}
		} finally {
            if (inputStream != null) {
                inputStream.close();
            }
		}

		return lines.toArray(new String[0]);
	}
}
