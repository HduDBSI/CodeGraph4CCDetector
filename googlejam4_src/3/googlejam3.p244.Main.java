package googlejam3.p244;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		if(!INPUT.isDirectory())
			throw new RuntimeException("Input folder dosen't exist");
		for(File file : INPUT.listFiles(f -> f.getName().endsWith(".in"))) {
			File outputFile = new File(file.getAbsolutePath().replaceAll("\\.([^\\.]*)$", "")+".out");
			BufferedReader inputReader = new BufferedReader(new FileReader(file));
			PrintWriter outputWriter = new PrintWriter(outputFile);
			int testNum = Integer.parseInt(inputReader.readLine());
			for (int i=0; i<testNum; i++) {
				String[] rcw = inputReader.readLine().split(" ");
				int r = Integer.parseInt(rcw[0]);
				int c = Integer.parseInt(rcw[1]);
				int w = Integer.parseInt(rcw[2]);
				int res = c/w * r;
				if (c % w != 0)
					res += 1;
				res += (w-1);
				int answer = res;
				outputWriter.format("Case #%d: %d\n", (i+1), answer);
			}
			inputReader.close();
			outputWriter.close();
		}
	}
	
	public static final File INPUT = new File("d:/TEST/");
	
}