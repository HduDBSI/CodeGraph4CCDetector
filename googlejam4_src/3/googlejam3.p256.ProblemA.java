package googlejam3.p256;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemA {

	/**
	 * @param args
	 *            : first arg - input file, second arg - output file
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Missing parameters (2 required)");
			System.out.println(" * parameter 1 - input file");
			System.out.println(" * parameter 2 - output file");
			return;
		}
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			reader = new BufferedReader(new FileReader(args[0]));
			writer = new BufferedWriter(new FileWriter(args[1]));

			String s_t = reader.readLine();
			int t = Integer.valueOf(s_t).intValue();
			
			for (int i = 1; i <= t; i++) {
				String line = reader.readLine();
				String[] vars = line.split(" ");  
				
				int r = Integer.valueOf(vars[0]).intValue();
				int c = Integer.valueOf(vars[1]).intValue();
				int w = Integer.valueOf(vars[2]).intValue();
				
				int result = 0;
				
				int perR = c / w;
				
				result = r * perR + w;
				
				if (c % w == 0) {
					result = result - 1; 
				}
				
				writer.write("Case #" + i + ": " + result);
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
			}
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
	}

}
