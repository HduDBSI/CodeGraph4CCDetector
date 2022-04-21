package googlejam6.p610;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class RankAndFile {
	static boolean fileOutput = true;
	static Path outputPath = Paths.get("output.txt");
	static PrintWriter fileWriter;

	public static void main(String[] args) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new File("input/B-large.in"))) {
			int T = scanner.nextInt();

			for (int t = 0; t < T; ++t) {
				int N = scanner.nextInt(); scanner.nextLine();
				Map<Integer, Integer> map = new HashMap<>();

				int NN = N * (2*N - 1);
				for (int i = 0; i < NN; ++i) {
					int n = scanner.nextInt();
					
					Integer I = map.get(n);
					if (I == null)
						I = 1;
					else
						I += 1;
					map.put(n, I);
				}
				
				final List<Integer> l = new ArrayList<>();
				map.forEach((k, v) -> {
					if (v % 2 == 1)
						l.add(k);
				});
				Collections.sort(l);
				
				final StringJoiner sj = new StringJoiner(" ");
				l.forEach(s -> { sj.add(s.toString()); });
				String txt = "Case #" + (t + 1) + ": " + sj.toString();
					
				
				if (fileOutput && fileWriter == null)
					fileWriter = new PrintWriter(outputPath.toFile());
				
				if (fileOutput)
					fileWriter.write(txt + "\n");
				else
					System.out.println(txt);
			}
		}

		if (fileWriter != null)
			fileWriter.close();
	}
}
