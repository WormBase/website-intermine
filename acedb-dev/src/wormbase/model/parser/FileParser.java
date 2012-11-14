package wormbase.model.parser;

import java.io.*;
import java.util.*;

public class FileParser {

	private BufferedReader inputStream;
	private boolean isStreamClosed = false; 
	
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
		if( isStreamClosed ){
			return null;
		}
		
		ArrayList<String> lines = new ArrayList<String>();
		
		String line;
		boolean startedObj = false; // Switched if non-whitespace passed in 
        try {
			while ((line = (String) inputStream.readLine()) != null) {
			    
				
			    if(line.equals("")){
			    	if(startedObj){
			    		break;
			    	}else{
			    		continue;
			    	}
			    }else if(startedObj != true){
			    	startedObj = true;
			    }
			    lines.add(line);
			}
		} finally {
            if (inputStream != null && inputStream.ready() != true) {
            	isStreamClosed = true;
            	inputStream.close();
            }
		}

		return lines.toArray(new String[lines.size()]);
	}
	
	/**
	 * Applies command to inputStream global variable
	 * @param command can be "reset" or "close"
	 */
	public void streamCmd(String command){
		
	}
}
