package _1_enhancements;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MultiCatch {

	public MultiCatch() {
		// TODO Auto-generated constructor stub
	}

	public void metodo() {
		// try {
		// con excepciones separadas por pipe |
		// } catch (IOException|SQLException ex) {
		// throw ex;
		// }

		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(
				"data"))) {
			out.writeUTF("Hello");
		} catch (IOException e) { // COMPILATION FAILS !!!
			// ...
		}
	}

	// Metodo para ver como se hace un TRY WITH
	// here are two resources defined in the try statement, separated by a
	// semicolon,
	// which are automatically closed when the statement completes:
	static String readFirstLineFromFileWithFinallyBlock(String path)
			throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}

	// NOTE: the close() methods of resources are called in the OPPOSITE order
	// of their creation.

	// NOTE: in try-with-resource statement the catch and the finally blocks are
	// OPTIONAL.
	// In a try-with-resources statement, any catch or finally block is run AFTER the resources declared have been closed.
	public static void copyFile(String src, String dest) {
		try (BufferedReader in = new BufferedReader(new FileReader(src));
				BufferedWriter out = new BufferedWriter(new FileWriter(dest))) {
			String line;
			while ((line = in.readLine()) != null) {
				out.write(line);
				out.write('\n');
			}
		} catch (IOException | IllegalStateException e) {// No need to close resources in a "finally"
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
