package junit.test;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class FileWriterTest {

	@Test
	public void test() throws IOException {
		FileWriter fw = new FileWriter("DELETE.txt");
		fw.write("TESTING123");
		fw.close();
	}

}
