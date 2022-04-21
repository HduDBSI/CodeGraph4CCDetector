package googlejam3.p094;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemA {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("A-large (2).in"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("a.out"));
		int tests = Integer.parseInt(reader.readLine());
		int currTest = 1;
		while (currTest <= tests) {
			String[] line = reader.readLine().split(" ");
			int R = Integer.parseInt(line[0]);
			int C = Integer.parseInt(line[1]);
			int W = Integer.parseInt(line[2]);
			long count = 0;
			count += C / W;
			count *= R;
			if (W > 1) {
				if ((C % W) !=0) {
					count += W;
				}
				else count += W - 1;
			}
			System.out.println("Case #"+currTest+": "+count);
			currTest++;
		}
		reader.close();
		writer.flush();
		writer.close();
	}

}
