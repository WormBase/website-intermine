package junit.test;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.*;
import wormbase.model.parser.*;

import org.junit.Test;

public class PropertiesXPathTest {

	@Test
	public void test() throws Exception{
		String dataFile = "/home/jwong/git/website-intermine/acedb-dev/acedb/datafiles/Gene1.xml";
//		String dataFile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/test.xml";
		
//		String pFile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/test.properties";
		String pFile = "/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/Gene1_xml_xpath.properties";
		
		// Load properties into file
		Properties p = new Properties();
		p.load(new FileReader(pFile));
		
		// Get properties keys
		Enumeration<Object> propKeys = p.keys();
		
		// Get XML chunk 
		FileParser fp = new FileParser(dataFile);
		String xml = fp.getDataString(); 

		// Load XML into org.w3c.dom.Document 
		Document doc = PackageUtils.loadXMLFrom(xml);
		
	    // Get XPathFactory
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        
        String propKey;
        while( propKeys.hasMoreElements() ){
        	propKey = (String) propKeys.nextElement();
        	
	        // The XPath object compiles the XPath expression
	        XPathExpression expr = xpath.compile( p.getProperty(propKey) ); 
	        
	        System.out.printf("%25s =\t%s\n", propKey, expr.evaluate(doc));
        }
        
       
        
		
		
		
	}

}
