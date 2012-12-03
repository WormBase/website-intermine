/**
 * 
 */
package junit.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
//import org.dom4j.*;

/**
 * @author jwong
 * Search an XML file with XPath
 * Refer to http://www.ibm.com/developerworks/library/x-javaxpathapi/index.html
 */
public class XpathFileTest {

	@Test
	public void test() throws Exception {
//		Document document = DocumentHelper.createDocument();
		
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setIgnoringElementContentWhitespace(true);
	    
        DocumentBuilder builder = factory.newDocumentBuilder();
        File file = new File("/home/jwong/git/website-intermine/acedb-dev/test/test_datafiles/test.xml");
        Document doc = builder.parse(file);
        // now we have the document
        
	    // Get XPathFactory
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        
        // The XPath object compiles the XPath expression
        XPathExpression expr = xpath.compile("/root/lang[@id=2]/name"); 
        
	    /* Finally, you evaluate the XPath expression to get the result.
	     *  The expression is evaluated with respect to a certain context 
	     *  node, which in this case is the entire document. 
	    */
        String result = expr.evaluate(doc);
        
        assertEquals(result, "Java");
	}

}
