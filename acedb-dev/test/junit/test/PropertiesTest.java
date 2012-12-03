/**
 * 
 */
package junit.test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Properties;
import java.io.*;


/**
 * @author jwong
 *
 */
public class PropertiesTest {
	
	@Test
	public void test() throws Exception {
		String pFile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/test.properties";
		
		Properties p = new Properties();
		
		FileReader fr = new FileReader(pFile);
		
		p.load(fr);
		
		System.out.println(p.toString());
		
		//fail("Not yet implemented");
	}

}
