package junit.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XPathStringTest {

	@Test
	public void test() throws Exception{
		String xml = "<root><lang id=\"1\"><name>C</name>	</lang>	<lang id=\"2\"><name>Java</name></lang></root>";
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    factory.setIgnoringElementContentWhitespace(true);
	    
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(xml)));
        // now we have the document
        
	    // Get XPathFactory
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();
        
        // The XPath object compiles the XPath expression
        XPathExpression expr = xpath.compile("/root/lang[@id=1]/name"); 
        
	    /* Finally, you evaluate the XPath expression to get the result.
	     *  The expression is evaluated with respect to a certain context 
	     *  node, which in this case is the entire document. 
	    */
        String result = expr.evaluate(doc);
        
        assertEquals(result, "C");
	}

}
