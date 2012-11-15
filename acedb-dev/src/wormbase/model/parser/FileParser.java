package wormbase.model.parser;

import java.io.*;
import java.util.*;

public class FileParser {

	private MyBufferedReader inputStream;
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public FileParser(String jaceFile) throws IOException {
        
		inputStream = new MyBufferedReader(new FileReader(jaceFile));

	}
	
	/**
	 * 
	 * @return Array of strings comprising the Ace data object
	 * @throws IOException 
	 */
	public String[] getDataObj() throws IOException{
		if( inputStream.isStreamClosed() ){
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
            if (inputStream.isStreamClosed() != true) {
            	inputStream.close();
            }
		}

		return lines.toArray(new String[lines.size()]);
	}
	
	/**
	 * Applies command to inputStream global variable
	 * @param command can be "reset" or "close"
	 * @throws IOException 
	 */
	public int streamCmd(String command) throws IOException{
		if(command.equals("close")){
			inputStream.close();
			return 1;
		}else if(command.equals("reset")){
			inputStream.reset();
			return 1;
		}else{
			return -1;
		}
	}
}
