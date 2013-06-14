package junit.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.Test;

public class BufferedReaderTest {

	
	
	@Test
	public void test() throws Exception {
		String datafile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/test.properties";
		BufferedReader in = new BufferedReader( new FileReader(datafile) );
		while(in.ready()){
			System.out.println(in.readLine());
		}
	}

}
