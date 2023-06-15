package echo;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class testinout {

	// a method that reads a line from the input stream, converts it to uppercase,
	// and writes it to the output stream
	public static void upperCaseLine(BufferedReader in, PrintWriter out) {
		try {
			// check if the input stream is ready to be read
			if (in.ready()) {
				// read a line from the input stream
				String line = in.readLine();
				// check if the line is not null
				if (line != null) {
					// convert the line to uppercase
					String upper = line.toUpperCase();
					// write the uppercase line to the output stream, followed by a newline
					out.println(upper);
				}
			}
		} catch (IOException e) {
			// handle the exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String inString = "dog\ncat";
		// fixed input stream of "dog" (line 1) and "cat" (line 2)
		try (ByteArrayInputStream inBytes = new ByteArrayInputStream(inString.getBytes());
				ByteArrayOutputStream outBytes = new ByteArrayOutputStream();

				// read a stream of characters from the fixed input string
				BufferedReader in = new BufferedReader(new InputStreamReader(inBytes, StandardCharsets.UTF_8));
				// write characters to temporary storage, with autoflushing
				PrintWriter out = new PrintWriter(new OutputStreamWriter(outBytes, StandardCharsets.UTF_8), true);) {
			upperCaseLine(in, out);
			// check that it readf the expected amount of input
			assertEquals("cat", in.readLine());
			// check that it wrote the expected output
			String out1 = outBytes.toString().substring(0, 3);
			String test = "DOG";
			assertEquals(test, out1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
