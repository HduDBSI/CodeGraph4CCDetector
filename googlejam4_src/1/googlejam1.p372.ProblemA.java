package googlejam1.p372;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProblemA {	

	private static BufferedWriter writer;
	private static Scanner scanner;
	
	private static int n;
	private static int[] m;

	private static int a;
	private static int b;
	
	public static void main(String[] args) throws IOException {
		Path input = Paths.get("input.txt");
		Path output = Paths.get("output.txt");
		scanner = new Scanner(input);
		writer = Files.newBufferedWriter(output);
		int testCases = scanner.nextInt();
		for (int i = 0; i < testCases; i++) {
			n = scanner.nextInt();
			m = new int[n];
			for(int i3 = 0; i3< n;i3++) {
				m[i3] = scanner.nextInt(); 
			}
			a = 0;
			for(int i1 = 1; i1 < m.length; i1++) {
				if (m[i1] < m[i1-1]) {
					a += (-m[i1] + m[i1-1]);
				}
			}
			b = 0;
			int minIn10Secs =0;
			for(int i1 = 0; i1 < m.length-1;i1++){
				int diff = m[i1+1] -m[i1];
				if (diff < 0)
				minIn10Secs = Math.max(minIn10Secs, -diff);
			}
			
			for(int i2 = 0; i2 < m.length -1; i2++) {	
					b += Math.min(minIn10Secs, m[i2]);
			}
			String out = String.format("Case #%d: %d %d", i + 1, a, b);
			System.err.println(out);
			writer.write(out);
			writer.newLine();
		}
		writer.close();

	}

}
