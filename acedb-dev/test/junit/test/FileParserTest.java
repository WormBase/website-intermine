package junit.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import wormbase.model.parser.FileParser;

public class FileParserTest {

	@Test
	public void test() throws IOException {
		String datafile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/gene3.jace";
		Integer[] paraLengths = {563, 315, 594};
		
		FileParser fp = new FileParser(datafile);
		
		String[] dataObj;
		ArrayList<Integer> al = new ArrayList<Integer>(3);
		
		while( (dataObj = fp.getDataObj()) != null ){ 
			al.add(dataObj.length);
		}
		
		assertArrayEquals(al.toArray(new Integer[3]), paraLengths);

	}

}
