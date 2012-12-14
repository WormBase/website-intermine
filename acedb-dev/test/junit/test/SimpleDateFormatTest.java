package junit.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class SimpleDateFormatTest {

	@Test
	public void test() throws ParseException {
		// Create a new SDFormat object with a specific pattern
		SimpleDateFormat SDFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		// Parse date string using held pattern
		Date date = SDFormat.parse("2006-03-02");
		
		// date is internalized, now change held pattern
		SDFormat.applyPattern("MMM/dd/yyyy");

		// printed date should be in this pattern now
		assertEquals("Mar/02/2006", SDFormat.format(date));
		
		
	}

}
