package junit.test;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.Test;

public class GenericsTest {

	@Test
	public void test() {
		GC<Integer> gClass = new GC<Integer>();
		gClass.setObj(5);
		int i = gClass.getObj();
		assertEquals(5, i);
//		assertEquals(true, true);
	}
	
	public class GC<T>{
		
		private T obj;
		
		public GC(){
			
		}
		
		public void setObj(T _obj){
			obj = _obj;
		}
		
		public T getObj(){
			return obj;
		}
	}


}

