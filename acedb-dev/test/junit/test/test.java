package junit.test;

import static org.junit.Assert.*;
import org.junit.Test;

public class test {

	
	
	@Test
	public void test() {
		int three[] = { 1,2,3 };
		assertEquals(3, three.length);
		
		assertEquals(3, three[three.length-1]);
	}

}
